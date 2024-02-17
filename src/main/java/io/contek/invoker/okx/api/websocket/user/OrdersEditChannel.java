package io.contek.invoker.okx.api.websocket.user;

import io.contek.invoker.okx.api.common._WSOrderEditAck;
import io.contek.invoker.okx.api.common.constants.OrderTypeKeys;
import io.contek.invoker.okx.api.common.constants.StpModeKeys;
import io.contek.invoker.okx.api.websocket.common.constants.WebSocketOrderOpKeys;

import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import javax.annotation.concurrent.ThreadSafe;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static io.contek.invoker.okx.api.common.constants.InstrumentTypeKeys._MARGIN;
import static io.contek.invoker.okx.api.common.constants.InstrumentTypeKeys._SPOT;
import static io.contek.invoker.okx.api.websocket.common.constants.WebSocketChannelKeys._orders;

@ThreadSafe
public final class OrdersEditChannel extends WebSocketUserChannel<OrdersEditChannel.Message> {

  private final AtomicInteger messageId = new AtomicInteger(0);

  private final String marketType;

  OrdersEditChannel(OrdersEditChannel.Id id) {
    super(id);
    this.marketType = id.type;
  }

  @Override
  public Class<Message> getMessageType() {
    return Message.class;
  }

  @Immutable
  public static final class Id extends WebSocketUserChannelId<Message> {

    private final String type;

    private Id(String type, @Nullable String instId) {
      super(_orders, type, instId);
      this.type = type;
    }

    public static Id of(String type, @Nullable String instId) {
      return new Id(type, instId);
    }
  }

  public int placeLimitOrder(String market, String tdMode, String clientId, String side, BigDecimal price, BigDecimal qty) {
    WebSocketPostOrderArg postArg = new WebSocketPostOrderArg();
    postArg.clOrdId = clientId;
    postArg.instId = market;
    postArg.ordType = OrderTypeKeys._limit;
    postArg.tdMode = tdMode;
    postArg.side = side;
    postArg.px = price.toPlainString();
    postArg.sz = qty.toPlainString();
    postArg.stpId = 1;
    postArg.stpMode = StpModeKeys._cancel_taker;
    if (_SPOT.equals(marketType))
      postArg.tgtCcy = "base_ccy";
    if (_MARGIN.equals(marketType)) // Only applicable to cross MARGIN orders in Single-currency margin.
      postArg.ccy = "USDT";
    WebSocketOrderRequest<WebSocketPostOrderArg> request = new WebSocketOrderRequest<>();
    int rez = messageId.incrementAndGet();
    request.id = Integer.toString(rez);
    request.args = List.of(postArg);
    request.op = WebSocketOrderOpKeys._order;
    if (session != null) {
      session.send(request);
      return rez;
    }
    return -1;
  }

  public int placeMarketOrder(String market, String tdMode, String clientId, String side, BigDecimal qty) {
    WebSocketPostOrderArg postArg = new WebSocketPostOrderArg();
    postArg.clOrdId = clientId;
    postArg.instId = market;
    postArg.ordType = OrderTypeKeys._market;
    postArg.tdMode = tdMode;
    postArg.side = side;
    postArg.sz = qty.toPlainString();
    postArg.stpId = 1;
    postArg.stpMode = StpModeKeys._cancel_taker;
    if (_SPOT.equals(marketType))
      postArg.tgtCcy = "base_ccy";
    if (_MARGIN.equals(marketType)) // Only applicable to cross MARGIN orders in Single-currency margin.
      postArg.ccy = "USDT";
    WebSocketOrderRequest<WebSocketPostOrderArg> request = new WebSocketOrderRequest<>();
    int rez = messageId.incrementAndGet();
    request.id = Integer.toString(rez);
    request.args = List.of(postArg);
    request.op = WebSocketOrderOpKeys._order;
    if (session != null) {
      session.send(request);
      return rez;
    }
    return -1;
  }

  public int cancelOrder(String market, String clientId) {
    WebSocketCancelOrderArg postArg = new WebSocketCancelOrderArg();
    postArg.clOrdId = clientId;
    postArg.instId = market;
    WebSocketOrderRequest<WebSocketCancelOrderArg> request = new WebSocketOrderRequest<>();
    int rez = messageId.incrementAndGet();
    request.id = Integer.toString(rez);
    request.args = List.of(postArg);
    request.op = WebSocketOrderOpKeys._cancel;
    if (session != null) {
      session.send(request);
      return rez;
    }
    return -1;
  }

  @NotThreadSafe
  public static final class Message extends WebSocketOrderResponse<_WSOrderEditAck> {
    @Override
    public String toString() {
      if (data != null && !data.isEmpty()) {
        _WSOrderEditAck orderEditAck = data.get(0);
        if (orderEditAck.sCode == null || orderEditAck.sCode.isEmpty() || "0".equals(orderEditAck.sCode))
          return id + " " + op + " " + orderEditAck.clOrdId;
        else
          return id + " " + op + " " + orderEditAck.clOrdId + " error: " + orderEditAck.sCode + " " + orderEditAck.sMsg;
      } else return id + " " + op + " " + code + " " + msg;
    }
  }
}
