package com.wdt.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class Client {
	public static void main(String[] args) throws Exception {
	
		EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
		
		try {
			Bootstrap bootstrap = new Bootstrap();
			bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class).
				handler(new ClinetInitializer());
			
			ChannelFuture channelFuture = bootstrap.connect("223.244.87.50", 9999).sync();
			channelFuture.channel().closeFuture().sync();
			
		}finally {
			eventLoopGroup.shutdownGracefully();
		}
		
	
	}
}
	

