package io.contek.invoker.okx.api.common;

import javax.annotation.concurrent.NotThreadSafe;
import java.math.BigDecimal;

@NotThreadSafe
public class _Ticker {

  public String instType;
  public String instId;
  public BigDecimal last;
  public String lastSz;
  public BigDecimal askPx;
  public BigDecimal askSz;
  public BigDecimal bidPx;
  public BigDecimal bidSz;
  public String open24h;
  public String high24h;
  public String low24h;
  public String volCcy24h;
  public String vol24h;
  public String sodUtc0;
  public String sodUtc8;
  public String ts;
}
