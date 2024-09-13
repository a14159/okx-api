package io.contek.invoker.okx.api.common;

import javax.annotation.concurrent.NotThreadSafe;
import java.math.BigDecimal;

@NotThreadSafe
public class _RateLimits {

    public BigDecimal fillRatio;
    public BigDecimal mainFillRatio;
    public Integer accRateLimit;
    public Integer nextAccRateLimit;
    public long ts;
}
