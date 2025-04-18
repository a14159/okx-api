package io.contek.invoker.okx.api.rest.market;

import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.rest.RestParams;
import io.contek.invoker.okx.api.common._Trade;
import io.contek.invoker.okx.api.rest.common.ResponseWrapper;

import javax.annotation.concurrent.NotThreadSafe;

import static java.util.Objects.requireNonNull;

@NotThreadSafe
public final class GetMarketTradesHistory extends MarketRestRequest<GetMarketTradesHistory.Response> {

  private String instId;
  private Integer type = 2;
  private long after;
  private long before;
  private Integer limit; // max and default 100

  GetMarketTradesHistory(IActor actor, RestContext context) {
    super(actor, context);
  }

  public GetMarketTradesHistory setInstId(String instId) {
    this.instId = instId;
    return this;
  }

  public GetMarketTradesHistory setType(Integer type) {
    this.type = type;
    return this;
  }

  public GetMarketTradesHistory setBefore(long before) {
    this.before = before;
    return this;
  }

  public GetMarketTradesHistory setAfter(long after) {
    this.after = after;
    return this;
  }

  @Override
  protected String getEndpointPath() {
    return "/api/v5/market/history-trades";
  }

  @Override
  protected RestParams getParams() {
    RestParams.Builder builder = RestParams.newBuilder();

    requireNonNull(instId);
    builder.add("instId", instId);

    if (limit != null) {
      builder.add("limit", limit);
    }

    if (before != 0)
      builder.add("before", before);

    if (after != 0)
      builder.add("after", after);

    return builder.build();
  }

  @Override
  protected Class<Response> getResponseType() {
    return Response.class;
  }

  @NotThreadSafe
  public static final class Response extends ResponseWrapper<_Trade> {}
}
