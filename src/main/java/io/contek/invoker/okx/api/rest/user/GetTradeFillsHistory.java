package io.contek.invoker.okx.api.rest.user;

import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.rest.RestMethod;
import io.contek.invoker.commons.rest.RestParams;
import io.contek.invoker.okx.api.common._Fill;
import io.contek.invoker.okx.api.rest.common.ResponseWrapper;

import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

import static io.contek.invoker.commons.rest.RestMethod.GET;
import static java.util.Objects.requireNonNull;

@NotThreadSafe
public final class GetTradeFillsHistory extends UserRestRequest<GetTradeFillsHistory.Response> {

  private String instType;
  private String uly;
  private String instId;
  private String ordId;
  private Long before;
  private Long after;
  private Long begin;
  private Long end;
  private Integer limit;

  GetTradeFillsHistory(IActor actor, RestContext context) {
    super(actor, context);
  }

  public GetTradeFillsHistory setInstType(String instType) {
    this.instType = instType;
    return this;
  }

  public GetTradeFillsHistory setUly(@Nullable String uly) {
    this.uly = uly;
    return this;
  }

  public GetTradeFillsHistory setInstId(@Nullable String instId) {
    this.instId = instId;
    return this;
  }

  public GetTradeFillsHistory setOrdId(@Nullable String ordId) {
    this.ordId = ordId;
    return this;
  }

  public GetTradeFillsHistory setAfter(@Nullable Long billId) {
    this.after = billId;
    return this;
  }

  public GetTradeFillsHistory setBefore(@Nullable Long billId) {
    this.before = billId;
    return this;
  }

  public GetTradeFillsHistory setBegin(@Nullable Long timestamp) {
    this.begin = timestamp;
    return this;
  }

  public GetTradeFillsHistory setEnd(@Nullable Long timestamp) {
    this.end = timestamp;
    return this;
  }

  public GetTradeFillsHistory setLimit(@Nullable Integer limit) {
    this.limit = limit;
    return this;
  }

  @Override
  protected Class<GetTradeFillsHistory.Response> getResponseType() {
    return Response.class;
  }

  @Override
  protected RestMethod getMethod() {
    return GET;
  }

  @Override
  protected String getEndpointPath() {
    return "/api/v5/trade/fills-history";
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

    if (ordId != null) {
      builder.add("ordId", ordId);
    }

    if (after != null) {
      builder.add("after", after);
    }

    if (before != null) {
      builder.add("before", before);
    }

    if (begin != null) {
      builder.add("begin", begin);
    }

    if (end != null) {
      builder.add("end", end);
    }

    if (limit != null) {
      builder.add("limit", limit);
    }

    return builder.build();
  }

  @NotThreadSafe
  public static final class Response extends ResponseWrapper<_Fill> {}
}
