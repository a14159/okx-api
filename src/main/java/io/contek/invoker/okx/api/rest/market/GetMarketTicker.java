package io.contek.invoker.okx.api.rest.market;

import com.google.common.collect.ImmutableList;
import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.actor.ratelimit.RateLimitRule;
import io.contek.invoker.commons.actor.ratelimit.TypedPermitRequest;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.rest.RestParams;
import io.contek.invoker.okx.api.common._Ticker;
import io.contek.invoker.okx.api.rest.common.ResponseWrapper;

import javax.annotation.concurrent.NotThreadSafe;
import java.time.Duration;

import static io.contek.invoker.commons.actor.ratelimit.LimitType.IP;
import static java.util.Objects.requireNonNull;

@NotThreadSafe
public final class GetMarketTicker extends MarketRestRequest<GetMarketTicker.Response> {

  public static final RateLimitRule RATE_LIMIT_RULE =
      RateLimitRule.newBuilder()
          .setName("ip_rest_get_market_ticker")
          .setType(IP)
          .setMaxPermits(20)
          .setResetPeriod(Duration.ofSeconds(2))
          .build();

  private static final ImmutableList<TypedPermitRequest> REQUIRED_QUOTA =
      ImmutableList.of(RATE_LIMIT_RULE.forPermits(1));

  private String instId;

  GetMarketTicker(IActor actor, RestContext context) {
    super(actor, context);
  }

  public GetMarketTicker setInstId(String instId) {
    this.instId = instId;
    return this;
  }

  @Override
  protected String getEndpointPath() {
    return "/api/v5/market/ticker";
  }

  @Override
  protected RestParams getParams() {
    RestParams.Builder builder = RestParams.newBuilder();

    requireNonNull(instId);
    builder.add("instId", instId);

    return builder.build();
  }

  @Override
  protected Class<Response> getResponseType() {
    return Response.class;
  }

  @Override
  protected ImmutableList<TypedPermitRequest> getRequiredQuotas() {
    return REQUIRED_QUOTA;
  }

  @NotThreadSafe
  public static final class Response extends ResponseWrapper<_Ticker> {}
}
