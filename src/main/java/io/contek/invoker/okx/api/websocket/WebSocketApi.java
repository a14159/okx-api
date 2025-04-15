package io.contek.invoker.okx.api.websocket;

import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.actor.ratelimit.RateLimitRule;
import io.contek.invoker.commons.actor.ratelimit.TypedPermitRequest;
import io.contek.invoker.commons.websocket.AnyWebSocketMessage;
import io.contek.invoker.commons.websocket.BaseWebSocketApi;
import io.contek.invoker.commons.websocket.WebSocketIllegalStateException;
import io.contek.invoker.commons.websocket.WebSocketRuntimeException;
import io.contek.invoker.okx.api.websocket.common.WebSocketGeneralResponse;

import javax.annotation.concurrent.ThreadSafe;
import java.time.Duration;
import java.util.List;

import static io.contek.invoker.commons.actor.ratelimit.LimitType.IP;
import static io.contek.invoker.okx.api.websocket.common.constants.WebSocketInboundKeys._error;

@ThreadSafe
public abstract class WebSocketApi extends BaseWebSocketApi {

  public static final RateLimitRule RATE_LIMIT_RULE =
      RateLimitRule.newBuilder()
          .setName("ip_ws_connection")
          .setType(IP)
          .setMaxPermits(1)
          .setResetPeriod(Duration.ofSeconds(1))
          .build();

  private static final List<TypedPermitRequest> REQUIRED_QUOTA =
      List.of(RATE_LIMIT_RULE.forPermits(1));

  protected WebSocketApi(String name, IActor actor) {
    super(
        actor,
        WebSocketMessageParser.getInstance(),
        new WebSocketAuthenticator(actor.getCredential(), actor.getClock()),
        new WebSocketLiveKeeper(name, actor.getClock()));
  }

  @Override
  protected List<TypedPermitRequest> getRequiredQuotas() {
    return REQUIRED_QUOTA;
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
