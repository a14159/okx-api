package io.contek.invoker.okx.api.rest.user;

import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.rest.RestMethod;
import io.contek.invoker.commons.rest.RestParams;
import io.contek.invoker.okx.api.common._Bill;
import io.contek.invoker.okx.api.rest.common.ResponseWrapper;

import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

import static io.contek.invoker.commons.rest.RestMethod.GET;

/**
 * {@code GET /api/v5/account/bills} - trading-account bills of the last 7 days.
 *
 * <p>Perpetual funding history is obtained with {@code subType=173} (expense) / {@code subType=174}
 * (income), optionally combined with {@code type} (the parent bill type), {@code instType},
 * {@code instId}, {@code ccy} and {@code mgnMode}. Pagination uses {@code after}/{@code before}
 * cursors keyed by {@code billId}, plus {@code begin}/{@code end} time bounds and {@code limit}.
 *
 * <p>This is the trading account ledger, not the OKX "Funding account" asset APIs
 * ({@code /api/v5/asset/bills}).
 */
@NotThreadSafe
public final class GetAccountBills extends UserRestRequest<GetAccountBills.Response> {

  private String instType;
  private String instId;
  private String ccy;
  private String mgnMode;
  private String ctType;
  private String type;
  private String subType;
  private Long after;
  private Long before;
  private Long begin;
  private Long end;
  private Integer limit;

  GetAccountBills(IActor actor, RestContext context) {
    super(actor, context);
  }

  public GetAccountBills setInstType(@Nullable String instType) {
    this.instType = instType;
    return this;
  }

  public GetAccountBills setInstId(@Nullable String instId) {
    this.instId = instId;
    return this;
  }

  public GetAccountBills setCcy(@Nullable String ccy) {
    this.ccy = ccy;
    return this;
  }

  public GetAccountBills setMgnMode(@Nullable String mgnMode) {
    this.mgnMode = mgnMode;
    return this;
  }

  public GetAccountBills setCtType(@Nullable String ctType) {
    this.ctType = ctType;
    return this;
  }

  public GetAccountBills setType(@Nullable String type) {
    this.type = type;
    return this;
  }

  public GetAccountBills setSubType(@Nullable String subType) {
    this.subType = subType;
    return this;
  }

  public GetAccountBills setAfter(@Nullable Long after) {
    this.after = after;
    return this;
  }

  public GetAccountBills setBefore(@Nullable Long before) {
    this.before = before;
    return this;
  }

  public GetAccountBills setBegin(@Nullable Long begin) {
    this.begin = begin;
    return this;
  }

  public GetAccountBills setEnd(@Nullable Long end) {
    this.end = end;
    return this;
  }

  public GetAccountBills setLimit(@Nullable Integer limit) {
    this.limit = limit;
    return this;
  }

  @Override
  protected RestMethod getMethod() {
    return GET;
  }

  @Override
  protected String getEndpointPath() {
    return "/api/v5/account/bills";
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

    if (ccy != null) {
      builder.add("ccy", ccy);
    }

    if (mgnMode != null) {
      builder.add("mgnMode", mgnMode);
    }

    if (ctType != null) {
      builder.add("ctType", ctType);
    }

    if (type != null) {
      builder.add("type", type);
    }

    if (subType != null) {
      builder.add("subType", subType);
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

  @Override
  protected Class<Response> getResponseType() {
    return Response.class;
  }

  @NotThreadSafe
  public static final class Response extends ResponseWrapper<_Bill> {}
}
