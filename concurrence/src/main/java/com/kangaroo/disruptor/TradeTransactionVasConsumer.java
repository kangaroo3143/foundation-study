package com.kangaroo.disruptor;


import com.lmax.disruptor.EventHandler;

import java.util.UUID;

/**
 * @Description:
 * @author ;liub
 * @Date: 2018-05-26 11:25
**/

public class TradeTransactionVasConsumer  implements EventHandler<TradeTransaction> {

    @Override
    public void onEvent(TradeTransaction event, long seq, boolean endOfBatch) throws Exception {
        event.setId(UUID.randomUUID().toString());//简单生成下ID
        System.out.println(TradeTransactionVasConsumer.class.getName()+",seq="+seq+",endofbatch="+endOfBatch+ event.getId());
    }
}