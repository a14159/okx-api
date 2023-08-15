package io.contek.invoker.okx.api.common;

import javax.annotation.concurrent.NotThreadSafe;
import java.math.BigDecimal;

@NotThreadSafe
public class _AssetBalance {

  public BigDecimal availBal;
  public BigDecimal bal;
  public String ccy;
  public BigDecimal frozenBal;
}
