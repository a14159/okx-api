package io.contek.invoker.okx.api.rest.user;

import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.rest.RestMethod;
import io.contek.invoker.commons.rest.RestParams;
import io.contek.invoker.okx.api.common._FeeRate;
import io.contek.invoker.okx.api.rest.common.ResponseWrapper;

import javax.annotation.concurrent.NotThreadSafe;

import static io.contek.invoker.commons.rest.RestMethod.GET;
import static java.util.Objects.requireNonNull;

@NotThreadSafe
public final class GetAccountFeeRate extends UserRestRequest<GetAccountFeeRate.Response> {

  private String instType;
  private String instId;

  GetAccountFeeRate(IActor actor, RestContext context) {
    super(actor, context);
  }

  public GetAccountFeeRate setInstId(String instId) {
    this.instId = instId;
    return this;
  }

  public GetAccountFeeRate setInstType(String instType) {
    this.instType = instType;
    return this;
  }

  @Override
  protected RestMethod getMethod() {
    return GET;
  }

  @Override
  protected String getEndpointPath() {
    return "/api/v5/account/trade-fee";
  }

  @Override
  protected RestParams getParams() {
    RestParams.Builder builder = RestParams.newBuilder();

    requireNonNull(instType);
    builder.add("instType", instType);

    if (instId != null) {
      builder.add("instId", instId);
    }

    return builder.build();
  }

  @Override
  protected Class<Response> getResponseType() {
    return Response.class;
  }

  @NotThreadSafe
  public static final class Response extends ResponseWrapper<_FeeRate> {}
}
