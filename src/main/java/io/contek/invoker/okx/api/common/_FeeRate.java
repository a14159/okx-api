package io.contek.invoker.okx.api.common;

import javax.annotation.concurrent.NotThreadSafe;
import java.math.BigDecimal;

@NotThreadSafe
public class _FeeRate {

    public String level;
    public BigDecimal taker;
    public BigDecimal maker;
    public String takerU;
    public String makerU;
    public String delivery;
    public String exercise;
    public String instType;
    public long ts;
}
