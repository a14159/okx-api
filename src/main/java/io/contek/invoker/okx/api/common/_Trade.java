package io.contek.invoker.okx.api.common;

import javax.annotation.concurrent.NotThreadSafe;
import java.math.BigDecimal;

@NotThreadSafe
public class _Trade {

  public String instId;
  public String tradeId;
  public BigDecimal px;
  public BigDecimal sz;
  public String side;
  public long ts;
  public long traceNano = System.nanoTime();
}
