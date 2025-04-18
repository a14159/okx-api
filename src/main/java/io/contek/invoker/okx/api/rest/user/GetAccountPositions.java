package io.contek.invoker.okx.api.rest.user;

import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.rest.RestMethod;
import io.contek.invoker.commons.rest.RestParams;
import io.contek.invoker.okx.api.common._Position;
import io.contek.invoker.okx.api.rest.common.ResponseWrapper;

import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

import static io.contek.invoker.commons.rest.RestMethod.GET;

@NotThreadSafe
public final class GetAccountPositions extends UserRestRequest<GetAccountPositions.Response> {

  private String instType;
  private String instId;
  private String posId;

  GetAccountPositions(IActor actor, RestContext context) {
    super(actor, context);
  }

  public GetAccountPositions setInstType(@Nullable String instType) {
    this.instType = instType;
    return this;
  }

  public GetAccountPositions setInstId(@Nullable String instId) {
    this.instId = instId;
    return this;
  }

  public GetAccountPositions setPosId(@Nullable String posId) {
    this.posId = posId;
    return this;
  }

  @Override
  protected RestMethod getMethod() {
    return GET;
  }

  @Override
  protected String getEndpointPath() {
    return "/api/v5/account/positions";
  }

  @Override
  protected RestParams getParams() {
    RestParams.Builder builder = RestParams.newBuilder();

    if (instType != null) {
      builder.add("instType", instType);
    }

    if (instId != null) {
      builder.add("instId", instId);
    }

    if (posId != null) {
      builder.add("posId", posId);
    }

    return builder.build();
  }

  @Override
  protected Class<Response> getResponseType() {
    return Response.class;
  }

  @NotThreadSafe
  public static final class Response extends ResponseWrapper<_Position> {}
}
