package io.contek.invoker.okx.api.websocket.common;

import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public final class WebSocketConnCountResponse extends WebSocketEvent {

  public String channel;
  public int connCount;
  public String connId;
}
