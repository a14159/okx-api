package io.contek.invoker.okx.api.common;

import javax.annotation.concurrent.NotThreadSafe;
import java.util.List;

/**
 * One element of the {@code data} array of a private {@code balance_and_position} WebSocket push.
 *
 * <p>{@link #eventType} identifies the trigger. The value {@code "snapshot"} is the initial
 * snapshot delivered on subscription; any other value ({@code filled}, {@code funding_fee},
 * {@code settlement}, ...) is an incremental event. The channel does not discard any event type.
 *
 * <p>Only {@link #balData} is present when only the account balance changed and only
 * {@link #posData} is present when only a position changed.
 */
@NotThreadSafe
public class _BalanceAndPosition {

  public String pTime;
  public String eventType;
  public List<_BalanceAndPositionBalance> balData;
  public List<_BalanceAndPositionPosition> posData;
  public List<_BalanceAndPositionTrade> trades;
}
