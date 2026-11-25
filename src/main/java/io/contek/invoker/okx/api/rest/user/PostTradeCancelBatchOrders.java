package io.contek.invoker.okx.api.rest.user;

import com.alibaba.fastjson2.JSON;
import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.rest.RestMediaBody;
import io.contek.invoker.commons.rest.RestMediaType;
import io.contek.invoker.commons.rest.RestMethod;
import io.contek.invoker.commons.rest.RestParams;
import io.contek.invoker.okx.api.common._CancelOrderAck;
import io.contek.invoker.okx.api.rest.common.ResponseWrapper;

import javax.annotation.concurrent.NotThreadSafe;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.contek.invoker.commons.rest.RestMethod.POST;
import static java.util.Objects.requireNonNull;

// Response code 0: every order succeeded; 1: every order failed; 2: some failed. Non-zero codes
// are thrown as ParsedHttpException carrying this Response, whose data holds each order's sCode.
@NotThreadSafe
public final class PostTradeCancelBatchOrders
    extends UserRestRequest<PostTradeCancelBatchOrders.Response> {

  public static final int MAX_ORDERS = 20;

  private final List<Map<String, String>> orders = new ArrayList<>();

  PostTradeCancelBatchOrders(IActor actor, RestContext context) {
    super(actor, context);
  }

  public PostTradeCancelBatchOrders addOrdId(String instId, String ordId) {
    return addOrder("ordId", instId, ordId);
  }

  public PostTradeCancelBatchOrders addClOrdId(String instId, String clOrdId) {
    return addOrder("clOrdId", instId, clOrdId);
  }

  private PostTradeCancelBatchOrders addOrder(String idKey, String instId, String id) {
    if (orders.size() >= MAX_ORDERS) {
      throw new IllegalStateException(
          "At most " + MAX_ORDERS + " orders can be canceled per request");
    }
    orders.add(Map.of("instId", requireNonNull(instId), idKey, requireNonNull(id)));
    return this;
  }

  @Override
  protected RestMethod getMethod() {
    return POST;
  }

  @Override
  protected String getEndpointPath() {
    return "/api/v5/trade/cancel-batch-orders";
  }

  @Override
  protected RestParams getParams() {
    return RestParams.empty(); // the body is a JSON array of orders: see getBody
  }

  @Override
  protected RestMediaBody getBody() {
    if (orders.isEmpty()) {
      throw new IllegalStateException("At least one order is required");
    }
    return RestMediaType.JSON.createBody(JSON.toJSONString(orders));
  }

  @Override
  protected Class<Response> getResponseType() {
    return Response.class;
  }

  @NotThreadSafe
  public static final class Response extends ResponseWrapper<_CancelOrderAck> {}
}
