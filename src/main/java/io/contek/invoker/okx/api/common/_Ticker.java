package io.contek.invoker.okx.api.common;

import javax.annotation.concurrent.NotThreadSafe;
import java.math.BigDecimal;

@NotThreadSafe
public class _Ticker {

  public String instType;
  public String instId;
  public BigDecimal last;
  public String lastSz;
  public String askPx;
  public BigDecimal askSz;
  public String bidPx;
  public BigDecimal bidSz;
  public String open24h;
  public String high24h;
  public String low24h;
  public BigDecimal volCcy24h;
  public BigDecimal vol24h;
  public String sodUtc0;
  public String sodUtc8;
  public String ts;

  public BigDecimal getAskPx() {
    return Util.parseString(askPx, BigDecimal.ZERO);
  }

  public BigDecimal getBidPx() {
    return Util.parseString(bidPx, BigDecimal.ZERO)
  }
}
