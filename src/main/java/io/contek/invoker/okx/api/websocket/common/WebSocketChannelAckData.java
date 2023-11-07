package io.contek.invoker.okx.api.websocket.common;

import javax.annotation.concurrent.NotThreadSafe;
import java.util.List;

@NotThreadSafe
public abstract class WebSocketChannelAckData<T> extends WebSocketInboundMessage {

  public List<T> data;
}
