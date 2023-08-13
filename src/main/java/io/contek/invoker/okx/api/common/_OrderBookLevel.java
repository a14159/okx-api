package io.contek.invoker.okx.api.common;

import javax.annotation.concurrent.NotThreadSafe;
import java.math.BigDecimal;
import java.util.ArrayList;

@NotThreadSafe
public class _OrderBookLevel extends ArrayList<String> {

    private BigDecimal price = null;
    private BigDecimal qty = null;

    public BigDecimal getPrice() {
        if (price != null)
            return price;
        price = new BigDecimal(get(0));
        return price;
    }

    public BigDecimal getQty() {
        if (qty != null)
            return qty;
        qty = new BigDecimal(get(1));
        return qty;
    }

    public int getOrdersAtLevel() {
        return Integer.parseInt(get(3));
    }
}
