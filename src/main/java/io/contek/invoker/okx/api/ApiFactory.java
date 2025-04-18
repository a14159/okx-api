package io.contek.invoker.okx.api;

import io.contek.invoker.commons.ApiContext;
import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.actor.IActorFactory;
import io.contek.invoker.commons.actor.SimpleActorFactory;
import io.contek.invoker.commons.actor.http.SimpleHttpClientFactory;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.websocket.WebSocketContext;
import io.contek.invoker.okx.api.rest.market.MarketRestApi;
import io.contek.invoker.okx.api.rest.user.UserRestApi;
import io.contek.invoker.okx.api.websocket.market.MarketWebSocketApi;
import io.contek.invoker.okx.api.websocket.user.UserWebSocketApi;
import io.contek.invoker.security.ApiKey;
import io.contek.invoker.security.SimpleCredentialFactory;
import is.fm.util.BaseEncoding;

import javax.annotation.concurrent.ThreadSafe;
import java.time.Duration;

import static io.contek.invoker.security.SecretKeyAlgorithm.HMAC_SHA256;

@ThreadSafe
public final class ApiFactory {

  public static final ApiContext MAIN_NET_CONTEXT =
      ApiContext.newBuilder()
          .setRestContext(RestContext.newBuilder()
                  .setBaseUrl("https://www.okx.com")
                  .setConnectionTimeout(Duration.ofMillis(2000))
                  .setReadTimeout(Duration.ofMillis(1000))
                  .setWriteTimeout(Duration.ofMillis(1000))
                  .build())
          .setWebSocketContext(
              WebSocketContext.forBaseUrl("wss://ws.okx.com:8443", Duration.ofSeconds(0)))
          .build();

  public static final ApiContext AWS_NET_CONTEXT =
      ApiContext.newBuilder()
          .setRestContext(RestContext.newBuilder()
                  .setBaseUrl("https://aws.okx.com")
                  .setConnectionTimeout(Duration.ofMillis(2000))
                  .setReadTimeout(Duration.ofMillis(1000))
                  .setWriteTimeout(Duration.ofMillis(1000))
                  .build())
          .setWebSocketContext(
              WebSocketContext.forBaseUrl("wss://wsaws.okx.com:8443", Duration.ofSeconds(0)))
          .build();

  public static final ApiContext TEST_CONTEXT =
          ApiContext.newBuilder()
                  .setRestContext(RestContext.forBaseUrl("https://www.okx.com"))
                  .setWebSocketContext(
                          WebSocketContext.forBaseUrl("wss://wspap.okx.com:8443", Duration.ofSeconds(0)))
                  .build();

  private final ApiContext context;
  private final IActorFactory actorFactory;

  private ApiFactory(ApiContext context, IActorFactory actorFactory) {
    this.context = context;
    this.actorFactory = actorFactory;
  }

  public static ApiFactory getMainNet() {
    return fromContext(MAIN_NET_CONTEXT);
  }

  public static ApiFactory getAwsNet() {
    return fromContext(AWS_NET_CONTEXT);
  }

  public static ApiFactory getTestNet() {
    return fromContext(TEST_CONTEXT);
  }

  public static ApiFactory fromContext(ApiContext context) {
    return new ApiFactory(context, createActorFactory());
  }

  public SelectingRestApi rest() {
    return new SelectingRestApi();
  }

  public SelectingWebSocketApi ws() {
    return new SelectingWebSocketApi();
  }

  private static SimpleActorFactory createActorFactory() {
    return SimpleActorFactory.newBuilder()
        .setCredentialFactory(createCredentialFactory())
        .setHttpClientFactory(SimpleHttpClientFactory.getInstance())
        .build();
  }

  private static SimpleCredentialFactory createCredentialFactory() {
    return SimpleCredentialFactory.newBuilder()
        .setAlgorithm(HMAC_SHA256)
        .setEncoding(BaseEncoding.base64())
        .build();
  }

  @ThreadSafe
  public final class SelectingRestApi {

    private SelectingRestApi() {}

    public MarketRestApi market() {
      RestContext restContext = context.getRestContext();
      IActor actor = actorFactory.create(null, restContext);
      return new MarketRestApi(actor, restContext);
    }

    public MarketRestApi market(ApiKey apiKey) { // used for test env
      RestContext restContext = context.getRestContext();
      IActor actor = actorFactory.create(apiKey, restContext);
      return new MarketRestApi(actor, restContext);
    }

    public UserRestApi user(ApiKey apiKey) {
      RestContext restContext = context.getRestContext();
      IActor actor = actorFactory.create(apiKey, restContext);
      return new UserRestApi(actor, restContext);
    }
  }

  @ThreadSafe
  public final class SelectingWebSocketApi {

    private SelectingWebSocketApi() {}

    public MarketWebSocketApi market() {
      return market("");
    }

    public MarketWebSocketApi market(String name) {
      WebSocketContext wsContext = context.getWebSocketContext();
      IActor actor = actorFactory.create(null, wsContext);
      return new MarketWebSocketApi(name, actor, wsContext);
    }

    public UserWebSocketApi user(ApiKey apiKey) {
      return user(apiKey.getId(), apiKey);
    }

    public UserWebSocketApi user(String name, ApiKey apiKey) {
      WebSocketContext wsContext = context.getWebSocketContext();
      IActor actor = actorFactory.create(apiKey, wsContext);
      return new UserWebSocketApi(name, actor, wsContext);
    }
  }
}
