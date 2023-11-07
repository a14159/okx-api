package io.contek.invoker.okx.api.websocket.common;

import javax.annotation.concurrent.NotThreadSafe;
import java.util.List;

@NotThreadSafe
public class WebSocketOrderResponse<Arg> extends WebSocketInboundMessage {

    public String id;
    public String op;
    public List<Arg> data;
    public String code;
    public String msg;
}
