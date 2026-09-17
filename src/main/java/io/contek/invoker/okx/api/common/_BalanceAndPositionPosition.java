package io.contek.invoker.okx.api.common;

import javax.annotation.concurrent.NotThreadSafe;

/** One element of {@code posData} in a private {@code balance_and_position} WebSocket push. */
@NotThreadSafe
public class _BalanceAndPositionPosition {

  public String posId;
  public String tradeId;
  public String instId;
  public String instType;
  public String mgnMode;
  public String avgPx;
  public String ccy;
  public String posSide;
  public String pos;
  public String baseBal;
  public String quoteBal;
  public String posCcy;
  public String nonSettleAvgPx;
  public String settledPnl;
  public String uTime;
}
