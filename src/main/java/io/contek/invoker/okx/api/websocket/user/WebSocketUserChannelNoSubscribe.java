package io.contek.invoker.okx.api.websocket.user;

import io.contek.invoker.commons.websocket.AnyWebSocketMessage;
import io.contek.invoker.commons.websocket.BaseWebSocketChannel;
import io.contek.invoker.commons.websocket.SubscriptionState;
import io.contek.invoker.commons.websocket.WebSocketSession;
import io.contek.invoker.okx.api.websocket.WebSocketNoSubscribeId;
import io.contek.invoker.okx.api.websocket.common.WebSocketChannelPushData;
import io.contek.invoker.okx.api.websocket.common.WebSocketPing;

import javax.annotation.concurrent.ThreadSafe;

import static io.contek.invoker.commons.websocket.SubscriptionState.*;

@ThreadSafe
public abstract class WebSocketUserChannelNoSubscribe<Message extends WebSocketChannelPushData<?>>
        extends BaseWebSocketChannel<WebSocketNoSubscribeId<Message>, Message, Message> {

  protected volatile WebSocketSession session;
  protected volatile SubscriptionState lastStatusSent;

  protected WebSocketUserChannelNoSubscribe(WebSocketNoSubscribeId<Message> id) {
    super(id);
  }

  @Override
  protected Message getData(Message message) {
    return message;
  }

  @Override
  protected SubscriptionState subscribe(WebSocketSession webSocketSession) {
//    System.out.println("[UserWebSocketNoSubscribeChannel] SUBSCRIBE was called");
    this.session = webSocketSession;
    // send ping request to move to subscribed state faster (will happen in BaseChannel on message received)
    session.send(new WebSocketPing());
    lastStatusSent = SUBSCRIBING;
    return SUBSCRIBING;
  }

  @Override
  protected SubscriptionState unsubscribe(WebSocketSession webSocketSession) {
//    System.out.println("[UserWebSocketNoSubscribeChannel] UNSUBSCRIBE was called");
    lastStatusSent = UNSUBSCRIBING;
    return UNSUBSCRIBING;
  }

  @Override
  protected void reset() {
//    System.out.println("[UserWebSocketNoSubscribeChannel] RESET was called");
    session = null;
  }

  @Override
  protected final SubscriptionState getState(AnyWebSocketMessage message) {
    if (lastStatusSent == SUBSCRIBING) {
      lastStatusSent = SUBSCRIBED;
      return SubscriptionState.SUBSCRIBED;
    }
    if (lastStatusSent == UNSUBSCRIBING) {
      lastStatusSent = UNSUBSCRIBED;
      return SubscriptionState.SUBSCRIBED;
    }
    return null;
  }

  @Override
  public String toString() {
    return getId().toString();
  }
}
