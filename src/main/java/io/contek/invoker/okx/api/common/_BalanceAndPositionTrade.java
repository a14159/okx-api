package io.contek.invoker.okx.api.common;

import javax.annotation.concurrent.NotThreadSafe;

/** One element of {@code trades} in a private {@code balance_and_position} WebSocket push. */
@NotThreadSafe
public class _BalanceAndPositionTrade {

  public String instId;
  public String tradeId;
}
