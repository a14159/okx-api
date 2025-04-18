package io.contek.invoker.okx.api.websocket;

import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.websocket.AnyWebSocketMessage;
import io.contek.invoker.commons.websocket.BaseWebSocketApi;
import io.contek.invoker.commons.websocket.WebSocketIllegalStateException;
import io.contek.invoker.commons.websocket.WebSocketRuntimeException;
import io.contek.invoker.okx.api.websocket.common.WebSocketGeneralResponse;

import javax.annotation.concurrent.ThreadSafe;

import static io.contek.invoker.okx.api.websocket.common.constants.WebSocketInboundKeys._error;

@ThreadSafe
public abstract class WebSocketApi extends BaseWebSocketApi {

  protected WebSocketApi(String name, IActor actor) {
    super(
        actor,
        WebSocketMessageParser.getInstance(),
        new WebSocketAuthenticator(actor.getCredential(), actor.getClock()),
        new WebSocketLiveKeeper(name, actor.getClock()));
  }

  @Override
  protected final void checkErrorMessage(AnyWebSocketMessage message)
      throws WebSocketRuntimeException {
    if (message instanceof WebSocketGeneralResponse response) {
      if (_error.equals(response.event)) {
        throw new WebSocketIllegalStateException(response.code + ": " + response.msg);
      }
    }
  }
}
