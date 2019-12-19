package com.wdt.client;

import com.wdt.util.CommondName;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ClientHandler extends SimpleChannelInboundHandler<String> {
	
	int i =10;
	

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
		// (byte) 0x7E, (byte) 0x32, (byte) 0x30, (byte) 0x30, (byte) 0x31, (byte) 0x34,
		// (byte) 0x37,
		// (byte) 0x38, (byte) 0x34, (byte) 0x45, (byte) 0x30, (byte) 0x30, (byte) 0x32,
		// (byte) 0x30, (byte) 0x30,
		// (byte) 0x46, (byte) 0x44, (byte) 0x32, (byte) 0x46, (byte) 0x0D
		// ~200147845002006426
		System.out.println("server:" + msg);
		if (msg.trim().equals("~200147845002006426")) {
			byte[] bt = new CommondName().xyModel();
			ByteBuf seneMsg = Unpooled.buffer(bt.length);
			seneMsg.writeBytes(bt);
			ctx.writeAndFlush(seneMsg);
		}
		if (msg.trim().equals("~20014742E002FFFD09")) {
			byte[] bt = new CommondName().xyModel();
			ByteBuf seneMsg = Unpooled.buffer(bt.length);
			seneMsg.writeBytes(bt);
			ctx.writeAndFlush(seneMsg);
		}
		if (msg.trim().equals("~20014744E002FFFD07")) {
			byte[] bt = new CommondName().xyWarn();
			ByteBuf seneMsg = Unpooled.buffer(bt.length);
			seneMsg.writeBytes(bt);
			ctx.writeAndFlush(seneMsg);
		}
		SendHeart sendHeart = new SendHeart(ctx);
		Thread th1 = new Thread(sendHeart);
		th1.start();
		
	}
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		byte[] bt = { (byte) 0x23, (byte) 0x57, (byte) 0x44, (byte) 0x54, (byte) 0x30, (byte) 0x30, (byte) 0x33 };
		ByteBuf seneMsg = Unpooled.buffer(bt.length);
		seneMsg.writeBytes(bt);
		ctx.writeAndFlush(seneMsg);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

	class SendHeart implements Runnable {
		private ChannelHandlerContext ctx;

		public SendHeart() {
	
		}

		public SendHeart(ChannelHandlerContext ctx) {
			this.ctx = ctx;
		}

		public void run() {
			// TODO Auto-generated method stub
			try {
				byte[] bt = { (byte) 0x23, (byte) 0x57, (byte) 0x44, (byte) 0x54, (byte) 0x30, (byte) 0x30,
						(byte) 0x33 };
				while (true) {
					Thread.currentThread().sleep(1000 * 30);
					ByteBuf seneMsg = Unpooled.buffer(bt.length);
					seneMsg.writeBytes(bt);
					ctx.writeAndFlush(seneMsg);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
