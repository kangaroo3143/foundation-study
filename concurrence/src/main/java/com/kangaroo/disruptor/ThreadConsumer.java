package com.kangaroo.disruptor;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ;liub
 * @Description:
 * @Date: 2018-05-26 10:40
 **/

public class ThreadConsumer extends Thread {

    private BlockingQueue<String> blockingQueue;

    public ThreadConsumer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        String msg;
        try {
            while (true) {
                msg = blockingQueue.take();
                if (msg == null) {
                    System.out.println("nodata");
                    Thread.sleep(1);
                } else {
                    // 消费
                    System.out.println(msg + "over");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**得到隊列的值也是读写鎖*/
/*    public E take() throws InterruptedException {
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try {
            while (count == 0)
                notEmpty.await();
            return dequeue();
        } finally {
            lock.unlock();
        }*/



}