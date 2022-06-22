package com.bzy.service.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * https://www.cnblogs.com/nanaheidebk/p/11025362.html
 */
public class HttpServer {
    
    public static void main(String[] args) {
        //构造两个线程组  bossGroup 用于接收客户端传过来的请求，接收到请求后将后续操作交由 workerGroup 处理
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            //服务端启动辅助类
            ServerBootstrap bootstrap = new ServerBootstrap();
 
            bootstrap.group(bossGroup, workerGroup)
             //channel 方法用于指定服务器端监听套接字通道 NioServerSocketChannel，其内部管理了一个 Java NIO 中的ServerSocketChannel实例。
            .channel(NioServerSocketChannel.class) 
             //channelHandler 方法用于设置业务职责链，责任链是我们下面要编写的，责任链具体是什么，它其实就是由一个个的 ChannelHandler 串联而成，形成的链式结构。正是这一个个的 ChannelHandler 帮我们完成了要处理的事情。
            .childHandler(new HttpServerInitializer());
 
            // bind 方法将服务绑定到 8080 端口上，bind 方法内部会执行端口绑定等一系列操，使得前面的配置都各就各位各司其职，
            //sync 方法用于阻塞当前 Thread，一直到端口绑定操作完成
            ChannelFuture future = bootstrap.bind(8189).sync();
            //等待服务端口关闭
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            // 优雅退出，释放线程池资源
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}