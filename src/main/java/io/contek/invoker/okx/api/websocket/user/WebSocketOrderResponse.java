package io.contek.invoker.okx.api.websocket.user;

import io.contek.invoker.okx.api.websocket.common.WebSocketChannelPushData;

import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class WebSocketOrderResponse<T> extends WebSocketChannelPushData<T> {

    public String id;
    public String op;
    public String code;
    public String msg;
    public long inTime;
    public long outTime;
}
