package io.contek.invoker.okx.api.rest.user;

import com.google.common.collect.ImmutableList;
import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.actor.ratelimit.RateLimitRule;
import io.contek.invoker.commons.actor.ratelimit.TypedPermitRequest;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.rest.RestMethod;
import io.contek.invoker.commons.rest.RestParams;
import io.contek.invoker.okx.api.common._PlaceOrderAck;
import io.contek.invoker.okx.api.rest.common.ResponseWrapper;

import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
import java.math.BigDecimal;
import java.time.Duration;

import static io.contek.invoker.commons.actor.ratelimit.LimitType.API_KEY;
import static io.contek.invoker.commons.rest.RestMethod.POST;
import static java.util.Objects.requireNonNull;

@NotThreadSafe
public final class PostAmendOrder extends UserRestRequest<PostAmendOrder.Response> {

  public static final RateLimitRule RATE_LIMIT_RULE =
      RateLimitRule.newBuilder()
          .setName("api_key_rest_post_amend_order")
          .setType(API_KEY)
          .setMaxPermits(60)
          .setResetPeriod(Duration.ofSeconds(2))
          .build();

  private static final ImmutableList<TypedPermitRequest> REQUIRED_QUOTA =
      ImmutableList.of(RATE_LIMIT_RULE.forPermits(1));

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

  @Override
  protected ImmutableList<TypedPermitRequest> getRequiredQuotas() {
    return REQUIRED_QUOTA;
  }

  @NotThreadSafe
  public static final class Response extends ResponseWrapper<_PlaceOrderAck> {}
}
