package com.yz.rpcfx.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.yz.rpcfx.api.RpcfxRequest;
import com.yz.rpcfx.api.RpcfxResponse;
import com.yz.rpcfx.nettyclent.NettyHttpClient;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequest;
import okhttp3.MediaType;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.net.URI;


/**
 * cglib + nettyclient
 */
public final class RpcfxCglib {

    static {
        ParserConfig.getGlobalInstance().addAccept("com.yz");
    }

    public static final MediaType JSONTYPE = MediaType.get("application/json; charset=utf-8");

    public static <T> T create(final Class<T> serviceClass, final String url) {
        return (T) Enhancer.create(serviceClass, new MyInterceptor(serviceClass, url));
    }

    private static class MyInterceptor implements MethodInterceptor {

        private final String url;

        private final Class<?> serviceClass;

        public <T> MyInterceptor(Class<?> serviceClass, String url) {
            this.serviceClass = serviceClass;
            this.url = url;
        }

        /**
         * @param proxy       被代理对象 com.yz.rpcfx.demo.provider.UserServiceImpl@3b90ec55
         * @param method      代理的方法 public abstract com.yz.rpcfx.demo.api.User com.yz.rpcfx.demo.api.UserService.findById(int)
         * @param params      方法参数
         * @param methodProxy 当前执行方法的代理对象
         * @return
         * @throws Throwable
         */
        @Override
        public Object intercept(Object proxy, Method method, Object[] params, MethodProxy methodProxy) throws Throwable {
            RpcfxRequest request = new RpcfxRequest();
            request.setServiceClass(this.serviceClass.getName());
            request.setMethod(method.getName());
            request.setParams(params);
            RpcfxResponse response = post(request, url);
            return JSON.parse(response.getResult().toString());
        }

        private RpcfxResponse post(RpcfxRequest req, String url) throws Exception {
            String reqJson = JSON.toJSONString(req);
            System.out.println("req json: " + reqJson);

            NettyHttpClient client = new NettyHttpClient();
            URI uri = URI.create(url);
            HttpRequest httpRequest = client.createHttpRequest(uri, reqJson, HttpMethod.POST);
            client.sendRequest(uri, httpRequest);
            client.latch.await();
            System.out.println(client.result);
            client.workerGroup.shutdownGracefully();

            return JSON.parseObject(client.result, RpcfxResponse.class);
        }
    }
}
