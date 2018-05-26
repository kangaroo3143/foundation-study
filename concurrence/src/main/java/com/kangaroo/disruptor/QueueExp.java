package com.kangaroo.disruptor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ;liub
 * @Description:阻塞队列
 * @Date: 2018-05-26 10:35
 **/

public class QueueExp {

    public static void main(String[] args) {
        BlockingQueue<String> blockingDeque = new ArrayBlockingQueue(1024);

        Thread consumer = new Thread(new ThreadConsumer( blockingDeque));

        consumer.start();

        long t1 = System.currentTimeMillis();
        System.out.println("begin=" + t1);
        // 创建数据
        for (int i = 0; i <= 1000000; i++) {
            try {
                blockingDeque.put(i + "");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("over ,user=" + (System.currentTimeMillis() - t1));
    }


/**加入队列使用的是读写锁*/
//    public void put(E e) throws InterruptedException {
//        checkNotNull(e);
//        final ReentrantLock lock = this.lock;
//        lock.lockInterruptibly();
//        try {
//            while (count == items.length)
//                notFull.await();
//            enqueue(e);
//        } finally {
//            lock.unlock();
//        }
//    }
}