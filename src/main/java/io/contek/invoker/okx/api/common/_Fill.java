package io.contek.invoker.okx.api.common;

import javax.annotation.concurrent.NotThreadSafe;
import java.math.BigDecimal;

@NotThreadSafe
public class _Fill {

  public String instType;
  public String instId;
  public String tradeId;
  public String ordId;
  public String clOrdId;
  public String billId;
  public String tag;
  public BigDecimal fillPx;
  public BigDecimal fillSz;
  public String side;
  public String posSide;
  public String execType;
  public String feeCcy;
  public BigDecimal fee;
  public long ts;
  public long fillTime;
  public long traceNano = System.nanoTime();
}
