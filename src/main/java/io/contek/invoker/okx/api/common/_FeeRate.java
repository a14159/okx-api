package io.contek.invoker.okx.api.common;

import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class _FeeRate {

    public String level;
    public Double taker;
    public Double maker;
    public String takerU;
    public String makerU;
    public String delivery;
    public String exercise;
    public String instType;
    public long ts;
}
