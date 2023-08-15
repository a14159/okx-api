package io.contek.invoker.okx.api.common;

import javax.annotation.concurrent.NotThreadSafe;
import java.math.BigDecimal;

@NotThreadSafe
public class _Leverage {

  public String instId;
  public String mgnMode;
  public String posSide;
  public BigDecimal lever;
}
