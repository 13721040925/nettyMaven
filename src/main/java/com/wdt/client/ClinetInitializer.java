package com.wdt.client;



import java.util.concurrent.TimeUnit;

import com.wdt.server.ServerHandler;
import com.wdt.server.ServerHandler2;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.CharsetUtil;

public class ClinetInitializer extends ChannelInitializer<SocketChannel> {

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();
		//pipeline.addLast(new IdleStateHandler(5,5,7,TimeUnit.MINUTES));//空闲状态监测
		pipeline.addLast(new StringDecoder(CharsetUtil.UTF_8));
		pipeline.addLast(new StringEncoder(CharsetUtil.UTF_8));
		pipeline.addLast(new ClientHandler());
		
		
	}

	
}
