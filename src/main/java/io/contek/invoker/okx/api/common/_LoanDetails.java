package io.contek.invoker.okx.api.common;

import javax.annotation.concurrent.NotThreadSafe;
import java.math.BigDecimal;

@NotThreadSafe
public class _LoanDetails {

  public String instId;
  public String mgnMode;
  public String mgnCcy;
  public BigDecimal maxLoan;
  public String ccy;
  public String side;
}
