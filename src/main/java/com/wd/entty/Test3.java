package com.wd.entty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;



public class Test3 {

	public static void main(String[] args) throws Exception {
		 
		
	
		/*byte[] b = FileInput.FileInput();
		System.out.println("b="+Arrays.toString(b));
		*/
		
		Queue<byte[]> resolution = Resolution.Resolution();	
		int i =1;
		for (byte[] cs : resolution) {
			
			System.out.println("cs"+i+"="+Arrays.toString(cs));
			i++;
		}
		
		Thread consumer = new Consumer(resolution);
		consumer.start();
	
	
		
 
	}
 


	/*//字符串的长度
	long max = s.length();
	//数组总长度
	long maxSize = s.length() / 2;
	//数组个数
	int line = (int) ((maxSize / 4096)+1);
	//最后一个数组的长度
	int lastMax = (int) (maxSize % 4096);
	//去除所有空格
	s = s.replaceAll(" ", "");
	
	System.out.println(s);
	
	byte[] b = new byte[(int) (maxSize+5)];
	
	
	for(int j =0;j<4096;j++) {
		//字符串分割
		String s1 = "";
		int a = 0;
		for(int i =0; i<=4096 * 2; i+=2) {
			s1 = s.substring(i, i+2);
			System.out.println(s1);
			
			//a = Integer.parseInt(s1);
			a =Integer.parseInt(s1.trim()) ;
			b[j] = (byte) a;
		}*/
		
		
		
		/*try {
		    a = Integer.parseInt(s1);
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		}*/
		
		
		
//	}
	//System.out.println("数组b = "+Arrays.toString(b));
			//String dataStr = new String(b);
			//System.out.println(dataStr);
			//int dataInt = Integer.parseInt(dataStr, 16);
			//System.out.println(dataInt );

}
