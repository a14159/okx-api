package io.contek.invoker.okx.api.common;

import javax.annotation.concurrent.NotThreadSafe;
import java.math.BigDecimal;

@NotThreadSafe
public class _FundingRate {
    public BigDecimal fundingRate;
    public long fundingTime;
    public String instId;
    public String instType;
    public BigDecimal nextFundingRate;
    public long nextFundingTime;
}
