package io.contek.invoker.okx.api.common;

import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class _Fill {

  public String instType;
  public String instId;
  public String tradeId;
  public String ordId;
  public String clOrdId;
  public String billId;
  public String tag;
  public Double fillPx;
  public Double fillSz;
  public String side;
  public String posSide;
  public String execType;
  public String feeCcy;
  public Double fee;
  public long ts;
  public long fillTime;
  public long traceNano = System.nanoTime();
}
