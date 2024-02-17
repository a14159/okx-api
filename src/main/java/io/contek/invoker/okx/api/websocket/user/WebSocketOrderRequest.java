package io.contek.invoker.okx.api.websocket.user;

import io.contek.invoker.okx.api.websocket.common.WebSocketOutboundMessage;

import javax.annotation.concurrent.NotThreadSafe;
import java.util.List;

@NotThreadSafe
public class WebSocketOrderRequest<Arg> extends WebSocketOutboundMessage {

    public String id;
    public String op;
    public List<Arg> args;
}
