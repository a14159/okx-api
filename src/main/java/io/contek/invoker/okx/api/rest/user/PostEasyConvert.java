package io.contek.invoker.okx.api.rest.user;

import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.actor.ratelimit.RateLimitRule;
import io.contek.invoker.commons.actor.ratelimit.TypedPermitRequest;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.rest.RestMethod;
import io.contek.invoker.commons.rest.RestParams;
import io.contek.invoker.okx.api.common._PlaceEasyConvertAck;
import io.contek.invoker.okx.api.rest.common.ResponseWrapper;

import javax.annotation.concurrent.NotThreadSafe;
import java.time.Duration;
import java.util.List;

import static io.contek.invoker.commons.actor.ratelimit.LimitType.API_KEY;
import static io.contek.invoker.commons.rest.RestMethod.POST;
import static java.util.Objects.requireNonNull;

@NotThreadSafe
public final class PostEasyConvert extends UserRestRequest<PostEasyConvert.Response> {

  public static final RateLimitRule RATE_LIMIT_RULE =
      RateLimitRule.newBuilder()
          .setName("api_key_rest_post_easy_convert")
          .setType(API_KEY)
          .setMaxPermits(1)
          .setResetPeriod(Duration.ofSeconds(2))
          .build();

  private static final List<TypedPermitRequest> REQUIRED_QUOTA =
      List.of(RATE_LIMIT_RULE.forPermits(1));

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

  @Override
  protected List<TypedPermitRequest> getRequiredQuotas() {
    return REQUIRED_QUOTA;
  }

  @NotThreadSafe
  public static final class Response extends ResponseWrapper<_PlaceEasyConvertAck> {}
}
