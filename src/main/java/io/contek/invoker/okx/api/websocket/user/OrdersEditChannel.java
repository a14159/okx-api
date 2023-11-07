package io.contek.invoker.okx.api.websocket.user;

import io.contek.invoker.okx.api.common._WSOrderEditAck;
import io.contek.invoker.okx.api.common.constants.OrderTypeKeys;
import io.contek.invoker.okx.api.websocket.common.constants.WebSocketOrderOpKeys;

import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import javax.annotation.concurrent.ThreadSafe;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static io.contek.invoker.okx.api.websocket.common.constants.WebSocketChannelKeys._orders;

@ThreadSafe
public final class OrdersEditChannel extends WebSocketUserChannel<OrdersEditChannel.Message> {

  private final AtomicInteger id = new AtomicInteger(0);

  OrdersEditChannel(OrdersEditChannel.Id id) {
    super(id);
  }

  @Override
  public Class<Message> getMessageType() {
    return Message.class;
  }

  @Immutable
  public static final class Id extends WebSocketUserChannelId<Message> {

    private Id(String type, @Nullable String instId) {
      super(_orders, type, instId);
    }

    public static Id of(String type, @Nullable String instId) {
      return new Id(type, instId);
    }
  }


  public void placeLimitOrder(String clientId, String market, String side, BigDecimal price, BigDecimal qty, boolean postOnly, boolean reduceOnly) {
    WebSocketPostOrderArg postArg = new WebSocketPostOrderArg();
    postArg.clOrdId = clientId;
    postArg.instId = market;
    postArg.ordType = OrderTypeKeys._limit;
    postArg.side = side;
    postArg.px = price.toPlainString();
    postArg.sz = qty.toPlainString();
    postArg.reduceOnly = reduceOnly;
    WebSocketOrderRequest<WebSocketPostOrderArg> request = new WebSocketOrderRequest<>();
    request.id = Integer.toString(id.incrementAndGet());
    request.args = List.of(postArg);
    request.op = WebSocketOrderOpKeys._order;
    if (session != null)
      session.send(request);
  }

  public void placeMarketOrder(String clientId, String market, String side, BigDecimal qty) {
    WebSocketPostOrderArg postArg = new WebSocketPostOrderArg();
    postArg.clOrdId = clientId;
    postArg.instId = market;
    postArg.ordType = OrderTypeKeys._market;
    postArg.side = side;
    postArg.sz = qty.toPlainString();
    WebSocketOrderRequest<WebSocketPostOrderArg> request = new WebSocketOrderRequest<>();
    request.id = Integer.toString(id.incrementAndGet());
    request.args = List.of(postArg);
    request.op = WebSocketOrderOpKeys._order;
    if (session != null)
      session.send(request);
  }

  public void cancelOrder(String market, String clientId) {
    WebSocketCancelOrderArg postArg = new WebSocketCancelOrderArg();
    postArg.clOrdId = clientId;
    postArg.instId = market;
    WebSocketOrderRequest<WebSocketCancelOrderArg> request = new WebSocketOrderRequest<>();
    request.id = Integer.toString(id.incrementAndGet());
    request.args = List.of(postArg);
    request.op = WebSocketOrderOpKeys._order;
    if (session != null)
      session.send(request);
  }

  @NotThreadSafe
  public static final class Message extends WebSocketOrderResponse<_WSOrderEditAck> {}
}
