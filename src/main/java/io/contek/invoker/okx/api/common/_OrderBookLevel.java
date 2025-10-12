package io.contek.invoker.okx.api.common;

import javax.annotation.concurrent.NotThreadSafe;
import java.util.ArrayList;

@NotThreadSafe
public class _OrderBookLevel extends ArrayList<String> {

    private Double price = null;
    private Double qty = null;

    public Double getPrice() {
        if (price != null)
            return price;
        price = Double.parseDouble(get(0));
        return price;
    }

    public Double getQty() {
        if (qty != null)
            return qty;
        qty = Double.parseDouble(get(1));
        return qty;
    }

    public int getOrdersAtLevel() {
        return Integer.parseInt(get(3));
    }
}
