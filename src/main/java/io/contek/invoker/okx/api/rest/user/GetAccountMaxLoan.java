package io.contek.invoker.okx.api.rest.user;

import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.rest.RestMethod;
import io.contek.invoker.commons.rest.RestParams;
import io.contek.invoker.okx.api.common._LoanDetails;
import io.contek.invoker.okx.api.rest.common.ResponseWrapper;

import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

import static io.contek.invoker.commons.rest.RestMethod.GET;

@NotThreadSafe
public final class GetAccountMaxLoan extends UserRestRequest<GetAccountMaxLoan.Response> {

  private String instId;
  private String mgnMode;

  GetAccountMaxLoan(IActor actor, RestContext context) {
    super(actor, context);
  }

  public GetAccountMaxLoan setInstId(@Nullable String instId) {
    this.instId = instId;
    return this;
  }

  public GetAccountMaxLoan setMgnMode(@Nullable String mgnMode) {
    this.mgnMode = mgnMode;
    return this;
  }

  @Override
  protected RestMethod getMethod() {
    return GET;
  }

  @Override
  protected String getEndpointPath() {
    return "/api/v5/account/max-loan";
  }

  @Override
  protected RestParams getParams() {
    RestParams.Builder builder = RestParams.newBuilder();


    builder.add("instId", instId);
    builder.add("mgnMode", mgnMode);

    return builder.build();
  }

  @Override
  protected Class<Response> getResponseType() {
    return Response.class;
  }

  @NotThreadSafe
  public static final class Response extends ResponseWrapper<_LoanDetails> {}
}
