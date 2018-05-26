package com.kangaroo.disruptor;

import com.lmax.disruptor.EventTranslator;

import java.util.Random;

/**
 * @author ;liub
 * @Description:
 * @Date: 2018-05-26 12:02
 **/

public class TradeTransactionEventTranslator implements EventTranslator<TradeTransaction> {
    private Random random = new Random();

    @Override
    public void translateTo(TradeTransaction event, long sequence) {
        this.generateTradeTransaction(event);
    }

    private TradeTransaction generateTradeTransaction(TradeTransaction trade) {
        trade.setPrice(random.nextDouble() * 9999);
        return trade;
    }
}