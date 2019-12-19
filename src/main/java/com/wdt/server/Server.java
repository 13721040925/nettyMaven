package com.wdt.server;

import java.net.InetSocketAddress;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.AdaptiveRecvByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class Server {

	public static void main(String[] args) throws Exception {
		//配置服务器的NIO线程组
		EventLoopGroup boss = new NioEventLoopGroup(); 
		EventLoopGroup worker = new NioEventLoopGroup(); 
		
		try {
			ServerBootstrap serverBootstrap = new ServerBootstrap();
			serverBootstrap.group(boss,worker).channel(NioServerSocketChannel.class).
				option(ChannelOption.RCVBUF_ALLOCATOR, AdaptiveRecvByteBufAllocator.DEFAULT).//会根据之前接收到的数据大小进行计算,可以动态扩展容量                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
				handler(new LoggingHandler(LogLevel.INFO)).//日志级别
				childHandler(new ServerInitializer());
			
			ChannelFuture channelFuture = serverBootstrap.bind(new InetSocketAddress(8899)).sync();
			channelFuture.channel().closeFuture().sync();//会一直等待,知道socket关闭
			
		}finally {
			boss.shutdownGracefully();
			worker.shutdownGracefully();
			
		}

	}

}
