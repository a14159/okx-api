package io.contek.invoker.okx.api.websocket.user;

import io.contek.invoker.okx.api.common._BalanceAndPosition;
import io.contek.invoker.okx.api.websocket.WebSocketChannelId;
import io.contek.invoker.okx.api.websocket.common.WebSocketChannelArg;
import io.contek.invoker.okx.api.websocket.common.WebSocketChannelPushData;

import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import javax.annotation.concurrent.ThreadSafe;

import java.util.Objects;

import static io.contek.invoker.okx.api.websocket.common.constants.WebSocketChannelKeys._balance_and_position;

/**
 * Private {@code balance_and_position} channel.
 *
 * <p>Emits the raw exchange payload without filtering: each {@link _BalanceAndPosition#eventType}
 * is preserved, including {@code snapshot} (initial snapshot) and {@code funding_fee}. The channel
 * itself performs no account-balance differencing and issues no REST calls.
 */
@ThreadSafe
public final class BalanceAndPositionChannel
    extends WebSocketUserChannel<BalanceAndPositionChannel.Message> {

  BalanceAndPositionChannel(BalanceAndPositionChannel.Id id) {
    super(id);
  }

  @Override
  public Class<Message> getMessageType() {
    return Message.class;
  }

  @Immutable
  public static final class Id extends WebSocketChannelId<Message> {

    private Id() {
      super(_balance_and_position, "");
    }

    public static Id of() {
      return new Id();
    }

    @Override
    public WebSocketChannelArg toChannelArg() {
      WebSocketChannelArg result = new WebSocketChannelArg();
      result.channel = getChannel();
      return result;
    }

    @Override
    public boolean accepts(Message message) {
      WebSocketChannelArg details = message.arg;
      return details != null && Objects.equals(getChannel(), details.channel);
    }
  }

  @NotThreadSafe
  public static final class Message extends WebSocketChannelPushData<_BalanceAndPosition> {}
}
