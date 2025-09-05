package io.contek.invoker.okx.api.rest.user;

import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.rest.RestMethod;
import io.contek.invoker.commons.rest.RestParams;
import io.contek.invoker.okx.api.common._PlaceOrderAck;
import io.contek.invoker.okx.api.rest.common.ResponseWrapper;

import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

import static io.contek.invoker.commons.rest.RestMethod.POST;
import static java.util.Objects.requireNonNull;

@NotThreadSafe
public final class PostTradeOrder extends UserRestRequest<PostTradeOrder.Response> {

  private String instId;
  private String tdMode;
  private String ccy;
  private String clOrdId;
  private String tag;
  private String side;
  private String posSide;
  private String ordType;
  private String sz;
  private String px;
  private Boolean reduceOnly;
  private String tgtCcy;
  private String tpTriggerPx;
  private String tpOrdPx;
  private String slTriggerPx;
  private String slOrdPx;
  private String quickMgnType;

  PostTradeOrder(IActor actor, RestContext context) {
    super(actor, context);
  }

  public PostTradeOrder setInstId(String instId) {
    this.instId = instId;
    return this;
  }

  public PostTradeOrder setTdMode(String tdMode) {
    this.tdMode = tdMode;
    return this;
  }

  public PostTradeOrder setCcy(@Nullable String ccy) {
    this.ccy = ccy;
    return this;
  }

  public PostTradeOrder setClOrdId(@Nullable String clOrdId) {
    this.clOrdId = clOrdId;
    return this;
  }

  public PostTradeOrder setTag(@Nullable String tag) {
    this.tag = tag;
    return this;
  }

  public PostTradeOrder setSide(String side) {
    this.side = side;
    return this;
  }

  public PostTradeOrder setPosSide(@Nullable String posSide) {
    this.posSide = posSide;
    return this;
  }

  public PostTradeOrder setOrdType(String ordType) {
    this.ordType = ordType;
    return this;
  }

  public PostTradeOrder setSz(String sz) {
    this.sz = sz;
    return this;
  }

  public PostTradeOrder setPx(@Nullable String px) {
    this.px = px;
    return this;
  }

  public PostTradeOrder setTpTriggerPx(@Nullable String tpTriggerPx) {
    this.tpTriggerPx = tpTriggerPx;
    return this;
  }

  public PostTradeOrder setTpOrdPx(@Nullable String tpOrdPx) {
    this.tpOrdPx = tpOrdPx;
    return this;
  }

  public PostTradeOrder setSlTriggerPx(@Nullable String slTriggerPx) {
    this.slTriggerPx = slTriggerPx;
    return this;
  }

  public PostTradeOrder setSlOrdPx(@Nullable String slOrdPx) {
    this.slOrdPx = slOrdPx;
    return this;
  }

  public PostTradeOrder setReduceOnly(@Nullable Boolean reduceOnly) {
    this.reduceOnly = reduceOnly;
    return this;
  }

  public PostTradeOrder setTgtCcy(@Nullable String tgtCcy) {
    this.tgtCcy = tgtCcy;
    return this;
  }

  public PostTradeOrder setQuickMgnType(@Nullable String quickMgnType) {
    this.quickMgnType = quickMgnType;
    return this;
  }

  @Override
  protected RestMethod getMethod() {
    return POST;
  }

  @Override
  protected String getEndpointPath() {
    return "/api/v5/trade/order";
  }

  @Override
  protected RestParams getParams() {
    RestParams.Builder builder = RestParams.newBuilder();

    requireNonNull(instId);
    builder.add("instId", instId);

    requireNonNull(tdMode);
    builder.add("tdMode", tdMode);

    requireNonNull(side);
    builder.add("side", side);

    requireNonNull(ordType);
    builder.add("ordType", ordType);

    requireNonNull(sz);
    builder.add("sz", sz);

    if (ccy != null) {
      builder.add("ccy", ccy);
    }

    if (clOrdId != null) {
      builder.add("clOrdId", clOrdId);
    }

    if (tag != null) {
      builder.add("tag", tag);
    }

    if (posSide != null) {
      builder.add("posSide", posSide);
    }

    if (px != null) {
      builder.add("px", px);
    }

    if (tpTriggerPx != null) {
      builder.add("tpTriggerPx", tpTriggerPx);
    }

    if (tpOrdPx != null) {
      builder.add("tpOrdPx", tpOrdPx);
    }

    if (slTriggerPx != null) {
      builder.add("slTriggerPx", slTriggerPx);
    }

    if (slOrdPx != null) {
      builder.add("slOrdPx", slOrdPx);
    }

    if (reduceOnly != null) {
      builder.add("reduceOnly", reduceOnly);
    }

    if (tgtCcy != null) {
      builder.add("tgtCcy", tgtCcy);
    }

    if (quickMgnType != null) {
      builder.add("quickMgnType", quickMgnType);
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
