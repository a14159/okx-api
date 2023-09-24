package io.contek.invoker.okx.api.common;

import java.math.BigDecimal;

public final class Util {

    public static BigDecimal parseString(String s, BigDecimal defaultVal) {
        if (s == null || s.isEmpty())
            return defaultVal;
        return new BigDecimal(s);
    }

    public static long parseString(String s, long defaultVal) {
        if (s == null || s.isEmpty())
            return defaultVal;
        return Long.parseLong(s);
    }
}
