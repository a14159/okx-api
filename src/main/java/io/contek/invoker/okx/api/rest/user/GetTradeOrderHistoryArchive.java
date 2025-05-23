package io.contek.invoker.okx.api.rest.user;

import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.rest.RestMethod;
import io.contek.invoker.commons.rest.RestParams;
import io.contek.invoker.okx.api.common._Order;
import io.contek.invoker.okx.api.rest.common.ResponseWrapper;

import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

import static io.contek.invoker.commons.rest.RestMethod.GET;
import static java.util.Objects.requireNonNull;

@NotThreadSafe
public final class GetTradeOrderHistoryArchive
    extends UserRestRequest<GetTradeOrderHistoryArchive.Response> {

  private String instType;
  private String uly;
  private String instId;
  private String ordType;
  private String state;
  private String category;
  private Long after;
  private Long before;
  private Integer limit;

  GetTradeOrderHistoryArchive(IActor actor, RestContext context) {
    super(actor, context);
  }

  public GetTradeOrderHistoryArchive setInstType(String instType) {
    this.instType = instType;
    return this;
  }

  public GetTradeOrderHistoryArchive setUly(String uly) {
    this.uly = uly;
    return this;
  }

  public GetTradeOrderHistoryArchive setInstId(@Nullable String instId) {
    this.instId = instId;
    return this;
  }

  public GetTradeOrderHistoryArchive setOrdType(@Nullable String ordType) {
    this.ordType = ordType;
    return this;
  }

  public GetTradeOrderHistoryArchive setState(@Nullable String state) {
    this.state = state;
    return this;
  }

  public GetTradeOrderHistoryArchive setCategory(@Nullable String category) {
    this.category = category;
    return this;
  }

  public GetTradeOrderHistoryArchive setAfter(@Nullable Long after) {
    this.after = after;
    return this;
  }

  public GetTradeOrderHistoryArchive setBefore(@Nullable Long before) {
    this.before = before;
    return this;
  }

  public GetTradeOrderHistoryArchive setLimit(@Nullable Integer limit) {
    this.limit = limit;
    return this;
  }

  @Override
  protected RestMethod getMethod() {
    return GET;
  }

  @Override
  protected String getEndpointPath() {
    return "/api/v5/trade/orders-history-archive";
  }

  @Override
  protected RestParams getParams() {
    RestParams.Builder builder = RestParams.newBuilder();

    requireNonNull(instType);
    builder.add("instType", instType);

    if (uly != null) {
      builder.add("uly", uly);
    }

    if (instId != null) {
      builder.add("instId", instId);
    }

    if (ordType != null) {
      builder.add("ordType", ordType);
    }

    if (state != null) {
      builder.add("state", state);
    }

    if (category != null) {
      builder.add("category", category);
    }

    if (after != null) {
      builder.add("after", after);
    }

    if (before != null) {
      builder.add("before", before);
    }

    if (limit != null) {
      builder.add("limit", limit);
    }

    return builder.build();
  }

  @Override
  protected Class<Response> getResponseType() {
    return Response.class;
  }

  @NotThreadSafe
  public static final class Response extends ResponseWrapper<_Order> {}
}
