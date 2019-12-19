package com.wd.entty;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 消费者
 */
public class Consumer extends Thread{
	    private static final Lock lock = new ReentrantLock();//重入锁
	    private static final Condition fullCondition = lock.newCondition();     //队列满的条件
	    private static final Condition emptyCondition = lock.newCondition();        //队列空的条件
	    
	    //获取队列
	    QueueClass queueClass = QueueClass.getQueueClass();
		Queue<byte[]> queue = queueClass.getQueue();
		
		
	   /* String name;
	    int maxSize;*/

	    public Consumer( Queue<byte[]> queue){
	       
	        this.queue = queue;
	        
	    }

	    @Override
	    public void run(){
	        while(true){
	            //获得锁
	            lock.lock();
	             

	            if(queue.isEmpty()){
	                try {
	                    System.out.println("队列为空");
	                    //条件不满足，消费阻塞
	                    emptyCondition.await();
	                } catch (Exception ex) {
	                    ex.printStackTrace();
	                }
	            }
	            
	            BufferedOutputStream fos =null;
	            while(!queue.isEmpty()) {
	            	 byte[] b = queue.poll();
	            	 
	            	 try {
	            		 fos = new BufferedOutputStream(new FileOutputStream("E:\\b.txt"));
	            		 fos.write(b);
	            	 }catch(IOException e) {
	            		 e.printStackTrace();
	            	 }
	            	 
	            	
	            }
	            try {
					fos.flush();
					fos.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
        		
				
	           /* byte[] x = queue.poll();
	            System.out.println("");*/

	            //唤醒其他所有生产者、消费者
	           // fullCondition.signalAll();
	           // emptyCondition.signalAll();

	            //释放锁
	            lock.unlock();

	            try {
	                Thread.sleep(new Random().nextInt(1000));
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	
}
   