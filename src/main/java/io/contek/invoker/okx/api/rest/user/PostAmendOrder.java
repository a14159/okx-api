package io.contek.invoker.okx.api.rest.user;

import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.rest.RestMethod;
import io.contek.invoker.commons.rest.RestParams;
import io.contek.invoker.okx.api.common._PlaceOrderAck;
import io.contek.invoker.okx.api.rest.common.ResponseWrapper;

import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
import java.math.BigDecimal;

import static io.contek.invoker.commons.rest.RestMethod.POST;
import static java.util.Objects.requireNonNull;

@NotThreadSafe
public final class PostAmendOrder extends UserRestRequest<PostAmendOrder.Response> {

  private String instId;
  private String ordId;
  private String clOrdId;
  private Boolean cxlOnFail;
  private BigDecimal newSz;
  private BigDecimal newPx;

  PostAmendOrder(IActor actor, RestContext context) {
    super(actor, context);
  }

  public PostAmendOrder setInstId(String instId) {
    this.instId = instId;
    return this;
  }

  public PostAmendOrder setClOrdId(@Nullable String clOrdId) {
    this.clOrdId = clOrdId;
    return this;
  }

  public PostAmendOrder setOrdId(@Nullable String ordId) {
    this.ordId = ordId;
    return this;
  }

  public PostAmendOrder setCxlOnFail(@Nullable Boolean cxlOnFail) {
    this.cxlOnFail = cxlOnFail;
    return this;
  }

  public PostAmendOrder setNewSz(BigDecimal newSz) {
    this.newSz = newSz;
    return this;
  }

  public PostAmendOrder setNewPx(@Nullable BigDecimal newPx) {
    this.newPx = newPx;
    return this;
  }

  @Override
  protected RestMethod getMethod() {
    return POST;
  }

  @Override
  protected String getEndpointPath() {
    return "/api/v5/trade/amend-order";
  }

  @Override
  protected RestParams getParams() {
    RestParams.Builder builder = RestParams.newBuilder();

    requireNonNull(instId);
    builder.add("instId", instId);

    if (ordId != null) {
      builder.add("ordId", ordId);
    }

    if (clOrdId != null) {
      builder.add("clOrdId", clOrdId);
    }

    if (cxlOnFail != null) {
      builder.add("cxlOnFail", cxlOnFail);
    }

    if (newSz != null) {
      builder.add("newSz", newSz.toPlainString());
    }

    if (newPx != null) {
      builder.add("newPx", newPx.toPlainString());
    }

    return builder.build();
  }

  @Override
  protected Class<Response> getResponseType() {
    return Response.class;
  }

  @NotThreadSafe
  public static final class Response extends ResponseWrapper<_PlaceOrderAck> {}
}
