package io.contek.invoker.okx.api.common;

import javax.annotation.concurrent.NotThreadSafe;
import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;

@NotThreadSafe
public class _RateLimits {

    public String fillRatio;
    public String mainFillRatio;
    public Integer accRateLimit;
    public Integer nextAccRateLimit;
    public long ts;

    public BigDecimal getFillRatio() {
        return Util.parseString(fillRatio, ZERO);
    }

    public BigDecimal getMainFillRatio() {
        return Util.parseString(mainFillRatio, ZERO);
    }
}
