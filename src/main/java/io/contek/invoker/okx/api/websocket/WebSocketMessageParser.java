package io.contek.invoker.okx.api.websocket;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import io.contek.invoker.commons.websocket.IWebSocketComponent;
import io.contek.invoker.commons.websocket.WebSocketTextMessageParser;
import io.contek.invoker.okx.api.websocket.common.*;
import io.contek.invoker.okx.api.websocket.market.*;
import io.contek.invoker.okx.api.websocket.user.OrdersChannel;
import io.contek.invoker.okx.api.websocket.user.OrdersEditChannel;
import io.contek.invoker.okx.api.websocket.user.PositionsChannel;

import javax.annotation.concurrent.Immutable;

import static io.contek.invoker.commons.websocket.constants.WebSocketPingPongKeys._pong;
import static io.contek.invoker.okx.api.websocket.common.constants.WebSocketChannelKeys.*;
import static io.contek.invoker.okx.api.websocket.common.constants.WebSocketInboundKeys.*;
import static io.contek.invoker.okx.api.websocket.common.constants.WebSocketOutboundKeys._login;

@Immutable
final class WebSocketMessageParser extends WebSocketTextMessageParser {

  static WebSocketMessageParser getInstance() {
    return InstanceHolder.INSTANCE;
  }

  @Override
  public void register(IWebSocketComponent component) {}

  @Override
  protected WebSocketInboundMessage fromText(String text) {
    if (text.equals(_pong)) {
      return new WebSocketPong();
    }

    JSONObject json = JSON.parseObject(text);

    if (json.containsKey(_event)) {
      return toEvent(json);
    }

    if (json.containsKey(_data)) {
      return toPushData(json);
    }

    throw new IllegalArgumentException(text);
  }

  private WebSocketEvent toEvent(JSONObject obj) {
    String event = obj.get(_event).toString();
    return switch (event) {
      case _subscribe, _unsubscribe -> toSubscriptionMessage(obj);
      case _conn_cnt -> toConnCntMessage(obj);
      case _login, _error -> toGeneralResponse(obj);
      default -> throw new IllegalArgumentException(event);
    };
  }

  private WebSocketSubscriptionResponse toSubscriptionMessage(JSONObject obj) {
    return JSON.to(WebSocketSubscriptionResponse.class, obj);
  }

  private WebSocketConnCountResponse toConnCntMessage(JSONObject obj) {
    return JSON.to(WebSocketConnCountResponse.class, obj);
  }

  private WebSocketGeneralResponse toGeneralResponse(JSONObject obj) {
    return JSON.to(WebSocketGeneralResponse.class, obj);
  }

  private WebSocketChannelPushData<?> toPushData(JSONObject obj) {
    if (obj.containsKey(_arg)) {
      JSONObject arg = obj.getJSONObject(_arg);
      String channel = arg.get(_channel).toString();

      return switch (channel) {
        case _books, _books5, _books50_l2_tbt, _books_l2_tbt, _bbo_tbt -> obj.toJavaObject(OrderBookChannel.Message.class);
        case _trades -> obj.toJavaObject(TradesChannel.Message.class);
        case _tickers -> obj.toJavaObject(TickersChannel.Message.class);
        case _orders -> obj.toJavaObject(OrdersChannel.Message.class);
        case _positions -> obj.toJavaObject(PositionsChannel.Message.class);
        case _mark_price -> obj.toJavaObject(MarkPriceChannel.Message.class);
        case _index_tickers -> obj.toJavaObject(IndexTickersChannel.Message.class);
        default -> throw new IllegalArgumentException(obj.toString());
      };
    }

    if (obj.containsKey(_id)) {
      // channel is _orders
      return JSON.to(OrdersEditChannel.Message.class, obj);
    }

    return null;
  }

  private WebSocketMessageParser() {}

  @Immutable
  private static final class InstanceHolder {

    private static final WebSocketMessageParser INSTANCE = new WebSocketMessageParser();

    private InstanceHolder() {}
  }
}
