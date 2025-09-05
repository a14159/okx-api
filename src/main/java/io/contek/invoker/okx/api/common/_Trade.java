package io.contek.invoker.okx.api.common;

import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class _Trade {

  public String instId;
  public String tradeId;
  public Double px;
  public Double sz;
  public String side;
  public long ts;
  public long traceNano = System.nanoTime();
}
