package io.contek.invoker.okx.api.rest.user;

import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.rest.RestMethod;
import io.contek.invoker.commons.rest.RestParams;
import io.contek.invoker.okx.api.common._PlaceEasyConvertAck;
import io.contek.invoker.okx.api.rest.common.ResponseWrapper;

import javax.annotation.concurrent.NotThreadSafe;

import static io.contek.invoker.commons.rest.RestMethod.POST;
import static java.util.Objects.requireNonNull;

@NotThreadSafe
public final class PostEasyConvert extends UserRestRequest<PostEasyConvert.Response> {

  private String fromCcy;
  private String toCcy;

  PostEasyConvert(IActor actor, RestContext context) {
    super(actor, context);
  }

  public PostEasyConvert setFromCcy(String fromCcy) {
    this.fromCcy = fromCcy;
    return this;
  }

  public PostEasyConvert setToCcy(String toCcy) {
    this.toCcy = toCcy;
    return this;
  }

  @Override
  protected RestMethod getMethod() {
    return POST;
  }

  @Override
  protected String getEndpointPath() {
    return "/api/v5/trade/easy-convert";
  }

  @Override
  protected RestParams getParams() {
    RestParams.Builder builder = RestParams.newBuilder();

    requireNonNull(fromCcy);
    String[] paramFromCcy = {fromCcy};
    builder.add("fromCcy", paramFromCcy.toString());

    requireNonNull(toCcy);
    builder.add("toCcy", toCcy);

    return builder.build();
  }

  @Override
  protected Class<Response> getResponseType() {
    return Response.class;
  }

  @NotThreadSafe
  public static final class Response extends ResponseWrapper<_PlaceEasyConvertAck> {}
}
