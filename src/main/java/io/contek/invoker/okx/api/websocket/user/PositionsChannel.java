package io.contek.invoker.okx.api.websocket.user;

import io.contek.invoker.okx.api.common._Position;
import io.contek.invoker.okx.api.websocket.common.WebSocketChannelPushData;

import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import javax.annotation.concurrent.ThreadSafe;

import static io.contek.invoker.okx.api.websocket.common.constants.WebSocketChannelKeys._positions;

@ThreadSafe
public final class PositionsChannel extends WebSocketUserChannel<PositionsChannel.Message> {

  PositionsChannel(PositionsChannel.Id id) {
    super(id);
  }

  @Override
  public Class<Message> getMessageType() {
    return Message.class;
  }

  @Immutable
  public static final class Id extends WebSocketUserChannelId<Message> {

    private Id(String type, @Nullable String instId) {
      super(_positions, type, instId);
    }

    public static Id of(String type, @Nullable String instId) {
      return new Id(type, instId);
    }
  }

  /**
   * A {@code positions} push. {@link #eventType} is {@code snapshot} for the initial and regular
   * snapshot push and {@code event_update} for event-driven updates; {@link #curPage} and
   * {@link #lastPage} are only present for snapshot pushes. The exchange timestamp is carried by
   * {@link _Position#pTime} / {@link _Position#uTime}.
   */
  @NotThreadSafe
  public static final class Message extends WebSocketChannelPushData<_Position> {

    public String eventType;
    public Integer curPage;
    public Boolean lastPage;
  }
}
