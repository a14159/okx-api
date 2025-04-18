package io.contek.invoker.okx.api.rest.market;

import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.rest.RestParams;
import io.contek.invoker.okx.api.common._Ticker;
import io.contek.invoker.okx.api.rest.common.ResponseWrapper;

import javax.annotation.concurrent.NotThreadSafe;

import static java.util.Objects.requireNonNull;

@NotThreadSafe
public final class GetMarketTicker extends MarketRestRequest<GetMarketTicker.Response> {

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

  @NotThreadSafe
  public static final class Response extends ResponseWrapper<_Ticker> {}
}
