package io.contek.invoker.okx.api.common;

import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class _Ticker {

  public String instType;
  public String instId;
  public Double last;
  public String lastSz;
  public String askPx;
  public Double askSz;
  public String bidPx;
  public Double bidSz;
  public String open24h;
  public String high24h;
  public String low24h;
  public Double volCcy24h;
  public Double vol24h;
  public String sodUtc0;
  public String sodUtc8;
  public long ts;
  public long traceNano = System.nanoTime();

  public Double getAskPx() {
    return Util.parseString(askPx, 0.0);
  }

  public Double getBidPx() {
    return Util.parseString(bidPx, 0.0);
  }
}
