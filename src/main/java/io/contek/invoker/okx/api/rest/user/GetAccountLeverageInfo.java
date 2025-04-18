package io.contek.invoker.okx.api.rest.user;

import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.rest.RestMethod;
import io.contek.invoker.commons.rest.RestParams;
import io.contek.invoker.okx.api.common._Leverage;
import io.contek.invoker.okx.api.rest.common.ResponseWrapper;

import javax.annotation.concurrent.NotThreadSafe;

import static io.contek.invoker.commons.rest.RestMethod.GET;
import static java.util.Objects.requireNonNull;

@NotThreadSafe
public final class GetAccountLeverageInfo extends UserRestRequest<GetAccountLeverageInfo.Response> {

  private String instId;
  private String mgnMode;

  GetAccountLeverageInfo(IActor actor, RestContext context) {
    super(actor, context);
  }

  public GetAccountLeverageInfo setInstId(String instId) {
    this.instId = instId;
    return this;
  }

  public GetAccountLeverageInfo setMgnMode(String mgnMode) {
    this.mgnMode = mgnMode;
    return this;
  }

  @Override
  protected RestMethod getMethod() {
    return GET;
  }

  @Override
  protected String getEndpointPath() {
    return "/api/v5/account/leverage-info";
  }

  @Override
  protected RestParams getParams() {
    RestParams.Builder builder = RestParams.newBuilder();

    requireNonNull(instId);
    builder.add("instId", instId);

    requireNonNull(mgnMode);
    builder.add("mgnMode", mgnMode);

    return builder.build();
  }

  @Override
  protected Class<Response> getResponseType() {
    return Response.class;
  }

  @NotThreadSafe
  public static final class Response extends ResponseWrapper<_Leverage> {}
}
