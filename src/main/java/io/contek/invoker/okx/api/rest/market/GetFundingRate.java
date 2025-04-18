package io.contek.invoker.okx.api.rest.market;

import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.rest.RestParams;
import io.contek.invoker.okx.api.common._FundingRate;
import io.contek.invoker.okx.api.rest.common.ResponseWrapper;

import javax.annotation.concurrent.NotThreadSafe;

import static java.util.Objects.requireNonNull;

@NotThreadSafe
public final class GetFundingRate extends MarketRestRequest<GetFundingRate.Response> {

  private String instId;

  GetFundingRate(IActor actor, RestContext context) {
    super(actor, context);
  }

  public GetFundingRate setInstId(String instId) {
    this.instId = instId;
    return this;
  }

  @Override
  protected String getEndpointPath() {
    return "/api/v5/public/funding-rate";
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
  public static final class Response extends ResponseWrapper<_FundingRate> {}
}
