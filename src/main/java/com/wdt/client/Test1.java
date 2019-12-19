package com.wdt.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class Test1 implements Runnable{

	public void run() {
EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
		
		try {
			Bootstrap bootstrap = new Bootstrap();
			bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class).
				handler(new ClinetInitializer());
			
			ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 8899).sync();
			channelFuture.channel().closeFuture().sync();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			eventLoopGroup.shutdownGracefully();
		}
		
	}

}
