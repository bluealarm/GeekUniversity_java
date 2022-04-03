package io.github.kimmking.gateway.outbound.netty4;

import io.github.kimmking.gateway.outbound.netty4.NettyHttpClientOutboundHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

public class NettyHttpClient {
    public void connect(String host, int port) throws Exception {
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    // 客户端接收到的是httpResponse响应，所以要使用HttpResponseDecoder进行解码
                    ch.pipeline().addLast(new HttpResponseDecoder());
                    // 客户端发送的是httprequest，所以要使用HttpRequestEncoder进行编码
                    ch.pipeline().addLast(new HttpRequestEncoder());
                    //ch.pipeline().addLast(new HttpClientCodec());
                    //聚合
                    ch.pipeline().addLast(new HttpObjectAggregator(1024 * 1024));
                    //clienthandler
                    ch.pipeline().addLast(new NettyHttpClientOutboundHandler());
                }
            });
            // Start the client.发起异步链接
            ChannelFuture f = b.connect(host, port).sync();
            //配置HttpRequest的请求数据和一些配置信息
            String meg = "hello netty client";
            FullHttpRequest request = new DefaultFullHttpRequest(
                    HttpVersion.HTTP_1_1, HttpMethod.GET, "/api/hello", Unpooled.wrappedBuffer(meg.getBytes("UTF-8")));

            request.headers()
                    .set(HttpHeaderNames.CONTENT_TYPE, "text/plain;charset=UTF-8")
                    //开启长链接
                    .set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE)
                    //设置传递请求内容的长度
                    .set(HttpHeaderNames.CONTENT_LENGTH, request.content().readableBytes());
//            request.headers().set(HttpHeaderNames.ACCEPT_ENCODING, HttpHeaderValues.GZIP);


           //发送数据
            String msg2 = request.content().toString(CharsetUtil.UTF_8);
            f.channel().write(request);
            f.channel().flush();
            //监听等待客户端链路关闭
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
        }

    }

    public static void main(String[] args) throws Exception {
        NettyHttpClient client = new NettyHttpClient();
        client.connect("127.0.0.1", 8888);
    }
}