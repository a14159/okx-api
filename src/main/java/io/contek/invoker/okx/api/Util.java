package io.contek.invoker.okx.api;

import java.math.BigDecimal;

public final class Util {

    public static BigDecimal parseString(String s, BigDecimal defaultVal) {
        if (s == null || s.isEmpty())
            return defaultVal;
        return new BigDecimal(s);
    }
}
