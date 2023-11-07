package io.contek.invoker.okx.api.websocket.common;

import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class WebSocketOrderRequest<Arg> extends WebSocketRequest<Arg> {

    public String id;
}
