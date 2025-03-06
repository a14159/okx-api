package io.contek.invoker.okx.api.websocket.user;

import java.math.BigDecimal;

public class WebSocketAmendOrderArg {

    public String instId;
    public String clOrdId;
    public String ordId;
    public Boolean cxlOnFail;
    public String newSz;
    public String newPx;
}
