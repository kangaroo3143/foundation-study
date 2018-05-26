package com.kangaroo.disruptor;

import com.lmax.disruptor.dsl.Disruptor;

import java.util.concurrent.CountDownLatch;

/**
 * @Description:生产者
 * @author ;liub
 * @Date: 2018-05-26 11:20
**/

public class TradeTransactionPublisher implements Runnable {

    Disruptor<TradeTransaction> disruptor;
    private CountDownLatch latch;
    private static int LOOP=10;//生产者发送10条消息

    public TradeTransactionPublisher(CountDownLatch latch,Disruptor<TradeTransaction> disruptor) {
        this.disruptor=disruptor;
        this.latch=latch;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        TradeTransactionEventTranslator tradeTransloator=new TradeTransactionEventTranslator();
        for(int i=0;i<LOOP;i++){
            System.out.println("生产者成功向Ringbuffer中发送了一条消息");
            disruptor.publishEvent(tradeTransloator);
        }
        latch.countDown();
    }
}