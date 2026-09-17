package io.contek.invoker.okx.api.common;

import javax.annotation.concurrent.NotThreadSafe;

/** One element of {@code balData} in a private {@code balance_and_position} WebSocket push. */
@NotThreadSafe
public class _BalanceAndPositionBalance {

  public String ccy;
  public String cashBal;
  public String uTime;
}
