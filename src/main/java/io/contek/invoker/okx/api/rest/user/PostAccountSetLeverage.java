package io.contek.invoker.okx.api.rest.user;

import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.rest.RestMethod;
import io.contek.invoker.commons.rest.RestParams;
import io.contek.invoker.okx.api.common._Leverage;
import io.contek.invoker.okx.api.rest.common.ResponseWrapper;

import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

import static io.contek.invoker.commons.rest.RestMethod.POST;
import static java.util.Objects.requireNonNull;

@NotThreadSafe
public final class PostAccountSetLeverage extends UserRestRequest<PostAccountSetLeverage.Response> {

  private String instId;
  private String ccy;
  private int lever = 1;
  private String mgnMode;
  private String posSide;

  PostAccountSetLeverage(IActor actor, RestContext context) {
    super(actor, context);
  }

  public PostAccountSetLeverage setInstId(@Nullable String instId) {
    this.instId = instId;
    return this;
  }

  public PostAccountSetLeverage setCcy(@Nullable String ccy) {
    this.ccy = ccy;
    return this;
  }

  public PostAccountSetLeverage setLever(int lever) {
    this.lever = lever;
    return this;
  }

  public PostAccountSetLeverage setMgnMode(String mgnMode) {
    this.mgnMode = mgnMode;
    return this;
  }

  public PostAccountSetLeverage setPosSide(@Nullable String posSide) {
    this.posSide = posSide;
    return this;
  }

  @Override
  protected RestMethod getMethod() {
    return POST;
  }

  @Override
  protected String getEndpointPath() {
    return "/api/v5/account/set-leverage";
  }

  @Override
  protected RestParams getParams() {
    RestParams.Builder builder = RestParams.newBuilder();

    if (instId != null) {
      builder.add("instId", instId);
    } else {
      requireNonNull(ccy);
      builder.add("ccy", ccy);
    }

    builder.add("lever", Integer.toString(lever));

    requireNonNull(mgnMode);
    builder.add("mgnMode", mgnMode);

    if (posSide != null) {
      builder.add("posSide", posSide);
    }

    return builder.build();
  }

  @Override
  protected Class<Response> getResponseType() {
    return Response.class;
  }

  @NotThreadSafe
  public static final class Response extends ResponseWrapper<_Leverage> {}
}
