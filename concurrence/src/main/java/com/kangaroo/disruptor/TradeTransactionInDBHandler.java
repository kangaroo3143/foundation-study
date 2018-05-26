package com.kangaroo.disruptor;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

import java.util.UUID;

/**
 * @Description:
 * @author ;liub
 * @Date: 2018-05-26 11:38
**/

public class TradeTransactionInDBHandler implements EventHandler<TradeTransaction> {

    @Override
    public void onEvent(TradeTransaction event, long sequence,
                        boolean endOfBatch) throws Exception {
        //这里做具体的消费逻辑
        event.setId(UUID.randomUUID().toString());//简单生成下ID
        System.out.println(TradeTransactionInDBHandler.class.getName()+",seq="+sequence+",endofbatch="+endOfBatch+ event.getId());
    }
}