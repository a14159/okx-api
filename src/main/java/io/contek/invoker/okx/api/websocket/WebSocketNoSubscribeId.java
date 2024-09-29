package io.contek.invoker.okx.api.websocket;

import io.contek.invoker.commons.websocket.BaseWebSocketChannelId;
import io.contek.invoker.okx.api.websocket.common.WebSocketChannelPushData;

public abstract class WebSocketNoSubscribeId<Message extends WebSocketChannelPushData<?>>
    extends BaseWebSocketChannelId<Message> {

    protected WebSocketNoSubscribeId(String channel) {
        super(channel);
    }

    public final String getChannel() {
        return getValue();
    }

    @Override
    public boolean accepts(Message message) {
        return true;
    }
}
