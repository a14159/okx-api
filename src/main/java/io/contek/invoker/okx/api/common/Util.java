package io.contek.invoker.okx.api.common;


public final class Util {

    public static Double parseString(String s, double defaultVal) {
        if (s == null || s.isEmpty())
            return defaultVal;
        return Double.parseDouble(s);
    }

    public static long parseString(String s, long defaultVal) {
        if (s == null || s.isEmpty())
            return defaultVal;
        return Long.parseLong(s);
    }
}
