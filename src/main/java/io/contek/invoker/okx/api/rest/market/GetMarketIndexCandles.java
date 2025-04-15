package io.contek.invoker.okx.api.rest.market;

import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.actor.ratelimit.RateLimitRule;
import io.contek.invoker.commons.actor.ratelimit.TypedPermitRequest;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.rest.RestParams;
import io.contek.invoker.okx.api.common._PriceCandlestick;
import io.contek.invoker.okx.api.rest.common.ResponseWrapper;

import javax.annotation.concurrent.NotThreadSafe;
import java.time.Duration;
import java.util.List;

import static io.contek.invoker.commons.actor.ratelimit.LimitType.IP;
import static java.util.Objects.requireNonNull;

@NotThreadSafe
public final class GetMarketIndexCandles extends MarketRestRequest<GetMarketIndexCandles.Response> {

  public static final RateLimitRule RATE_LIMIT_RULE =
      RateLimitRule.newBuilder()
          .setName("ip_rest_get_market_index_candles")
          .setType(IP)
          .setMaxPermits(20)
          .setResetPeriod(Duration.ofSeconds(2))
          .build();

  private static final List<TypedPermitRequest> REQUIRED_QUOTA =
      List.of(RATE_LIMIT_RULE.forPermits(1));

  private String instId;
  private Long after;
  private Long before;
  private String bar;
  private Integer limit;

  GetMarketIndexCandles(IActor actor, RestContext context) {
    super(actor, context);
  }

  public GetMarketIndexCandles setInstId(String instId) {
    this.instId = instId;
    return this;
  }

  public GetMarketIndexCandles setAfter(Long after) {
    this.after = after;
    return this;
  }

  public GetMarketIndexCandles setBefore(Long before) {
    this.before = before;
    return this;
  }

  public GetMarketIndexCandles setBar(String bar) {
    this.bar = bar;
    return this;
  }

  public GetMarketIndexCandles setLimit(Integer limit) {
    this.limit = limit;
    return this;
  }

  @Override
  protected String getEndpointPath() {
    return "/api/v5/market/index-candles";
  }

  @Override
  protected RestParams getParams() {
    RestParams.Builder builder = RestParams.newBuilder();

    requireNonNull(instId);
    builder.add("instId", instId);

    if (before != null) {
      builder.add("before", before);
    }

    if (after != null) {
      builder.add("after", after);
    }

    if (bar != null) {
      builder.add("bar", bar);
    }

    if (limit != null) {
      builder.add("limit", limit);
    }

    return builder.build();
  }

  @Override
  protected Class<Response> getResponseType() {
    return Response.class;
  }

  @Override
  protected List<TypedPermitRequest> getRequiredQuotas() {
    return REQUIRED_QUOTA;
  }

  @NotThreadSafe
  public static final class Response extends ResponseWrapper<_PriceCandlestick> {}
}
