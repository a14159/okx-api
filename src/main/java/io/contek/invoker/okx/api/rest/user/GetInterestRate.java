package io.contek.invoker.okx.api.rest.user;

import com.google.common.collect.ImmutableList;
import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.actor.ratelimit.RateLimitRule;
import io.contek.invoker.commons.actor.ratelimit.TypedPermitRequest;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.rest.RestMethod;
import io.contek.invoker.commons.rest.RestParams;
import io.contek.invoker.okx.api.common._Order;
import io.contek.invoker.okx.api.rest.common.ResponseWrapper;

import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
import java.time.Duration;

import static io.contek.invoker.commons.actor.ratelimit.LimitType.API_KEY;
import static io.contek.invoker.commons.rest.RestMethod.GET;
import static java.util.Objects.requireNonNull;

@NotThreadSafe
public final class GetInterestRate extends UserRestRequest<GetInterestRate.Response> {

  public static final RateLimitRule RATE_LIMIT_RULE =
      RateLimitRule.newBuilder()
          .setName("api_key_rest_get_interest_rate")
          .setType(API_KEY)
          .setMaxPermits(5)
          .setResetPeriod(Duration.ofSeconds(2))
          .build();

  private static final ImmutableList<TypedPermitRequest> REQUIRED_QUOTA =
      ImmutableList.of(RATE_LIMIT_RULE.forPermits(1));

  private String ccy;

  GetInterestRate(IActor actor, RestContext context) {
    super(actor, context);
  }

  public GetInterestRate setCcy(String ccy) {
    this.ccy = ccy;
    return this;
  }

  @Override
  protected RestMethod getMethod() {
    return GET;
  }

  @Override
  protected String getEndpointPath() {
    return "/api/v5/account/interest-rate";
  }

  @Override
  protected RestParams getParams() {
    RestParams.Builder builder = RestParams.newBuilder();

    if (ccy != null) {
      builder.add("ccy", ccy);
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
  public static final class Response extends ResponseWrapper<_Order> {}
}
