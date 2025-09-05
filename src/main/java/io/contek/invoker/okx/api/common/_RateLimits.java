package io.contek.invoker.okx.api.common;

import javax.annotation.concurrent.NotThreadSafe;


@NotThreadSafe
public class _RateLimits {

    public String fillRatio;
    public String mainFillRatio;
    public Integer accRateLimit;
    public Integer nextAccRateLimit;
    public long ts;

    public Double getFillRatio() {
        return Util.parseString(fillRatio, 0.0);
    }

    public Double getMainFillRatio() {
        return Util.parseString(mainFillRatio, 0.0);
    }
}
