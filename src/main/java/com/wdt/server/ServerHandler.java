package com.wdt.server;

import java.net.SocketAddress;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.wd.entty.FileInput;
import com.wd.entty.Resolution;
import com.wd.entty.Upgrade;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class ServerHandler extends  SimpleChannelInboundHandler<String> {

	private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);//存放channel
	
	private static HashMap<Object, Channel> map  = new HashMap();
	
	private static Set<String> set = new HashSet();
	
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
		
		
		
		
		
		
		

		
		/*Upgrade upgrade = new Upgrade();
		byte[] startu = upgrade.getStartu();
		Channel channel = ctx.channel();
		set.add("JYController001");
		set.add("JYController002");
		set.add("JYController003");
		set.add("JYController004");
		set.add("JYController005");
		set.add("JYController006");
		set.forEach(id ->{
			if(id.equals(msg)) {//如果发送的是心跳的话将channel存入
				map.put(msg, channel);
			}
			
		});
		for(Object key : map.keySet()) {
			System.out.println("key:"+key + "  value:"+map.get(key));
		}
		
	
		
		for(Object key : map.keySet()) {
			if("JYController001".equals(key)) {
				if(channel == map.get(key)) {
					byte[] b = FileInput.FileInput();
					System.out.println("b="+Arrays.toString(b));
					
					
					byte[] b11 = Resolution.Resolution();
					
					//System.out.println("b1="+Arrays.toString(b1));
					
					
					ctx.writeAndFlush(b11);
					long totalMilliSeconds = System.currentTimeMillis();
					System.out.println(totalMilliSeconds);
				}
			}
		}*/
		
		
		
		
		
		/*channelGroup.forEach(ch -> {
			if(channel == ch) {
				ctx.writeAndFlush("nihao");
			}
		});*/
		
		
		
		
		
		System.out.println("收到消息："+ msg);
		ctx.writeAndFlush(new Byte[] {1,2,3});
		
		
		
	}

	//建立连接
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		Channel channel = ctx.channel();
		String id = channel.id().asLongText();//唯一标识
		
		
		System.out.println(channel.remoteAddress()+"加入");
		channelGroup.add(channel);
		int i = 0;
		for (Channel channel1 : channelGroup) {
			System.out.println("加入的channel:"+channel1);
			i++;
		}
		System.out.println("已有"+i+"个加入");
	}

	//每当服务器收到新的客户端连接时
	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		Channel channel = ctx.channel();
		
	}

	//每当服务器收到客户端断开时
	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		Channel channel = ctx.channel();
		channelGroup.remove(channel);
	}
	
	//客户端断开连接
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		Channel channel = ctx.channel();
		channelGroup.remove(channel);
		System.out.println(channel.remoteAddress()+"退出");
	}
	//出现异常时
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		// TODO Auto-generated method stub
		ctx.close();
	}
	
}
