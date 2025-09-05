package io.contek.invoker.okx.api.common;

import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class _FundingRate {
    public Double fundingRate;
    public long fundingTime;
    public String instId;
    public String instType;
    public Double nextFundingRate;
    public long nextFundingTime;
}
