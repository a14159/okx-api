package io.contek.invoker.okx.api.websocket.user;

import io.contek.invoker.okx.api.common._Fill;
import io.contek.invoker.okx.api.websocket.common.WebSocketChannelPushData;

import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import javax.annotation.concurrent.ThreadSafe;

import static io.contek.invoker.okx.api.websocket.common.constants.WebSocketChannelKeys._fills;

@ThreadSafe
public final class FillsChannel extends WebSocketUserChannel<FillsChannel.Message> {

  FillsChannel(FillsChannel.Id id) {
    super(id);
  }

  @Override
  public Class<Message> getMessageType() {
    return Message.class;
  }

  @Immutable
  public static final class Id extends WebSocketUserChannelId<Message> {

    private Id(@Nullable String instId) {
      super(_fills, null, instId);
    }

    public static Id of(@Nullable String instId) {
      return new Id(instId);
    }
  }

  @NotThreadSafe
  public static final class Message extends WebSocketChannelPushData<_Fill> {}
}
