package io.contek.invoker.okx.api.common;

import javax.annotation.concurrent.NotThreadSafe;
import java.math.BigDecimal;

@NotThreadSafe
public class _PlaceEasyConvertAck {

  public BigDecimal fillFromSz;
  public BigDecimal fillToSz;
  public String fromCcy;
  public String toCcy;
  public String status;
  public long uTime;
}
