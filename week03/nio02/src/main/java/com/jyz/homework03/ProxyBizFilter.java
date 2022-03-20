package com.jyz.homework03;

import io.github.kimmking.gateway.filter.HttpRequestFilter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.Headers;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;


/**
 * ClassName:ProxyBizFilter
 * Package:com.jyz.homework03
 * Description:过滤器
 *
 * @Date:2022-03-19 20:49
 * @Author:jiayz,JYZ
 */
public class ProxyBizFilter implements HttpRequestFilter {

    public static ProxyBizFilter newInstance() {
        return new ProxyBizFilter();
    }

    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        String uri = fullRequest.uri();
        System.out.println(" filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx)接收到请求，url: " + uri);
        if (uri.startsWith("/api/hello")) {
            //放过，不处理
        } else {
            throw new RuntimeException("不支持的uri:" + uri);
        }
        HttpHeaders headers = fullRequest.headers();
        if (headers == null) {
            headers = new DefaultHttpHeaders();
        }
        headers.add("mao", this.getClass().getSimpleName());


    }
}
