package io.contek.invoker.okx.api.common;

import io.contek.invoker.okx.api.Util;

import javax.annotation.concurrent.NotThreadSafe;
import java.math.BigDecimal;

@NotThreadSafe
public class _Instrument {

  public String instType;
  public String instId;
  public String uly;
  public String category;
  public String baseCcy;
  public String quoteCcy;
  public String settleCcy;
  public String ctVal;
  public String ctMult;
  public String ctValCcy;
  public String optType;
  public String stk;
  public String listTime;
  public String expTime;
  public String lever;
  public BigDecimal tickSz;
  public BigDecimal lotSz;
  public BigDecimal minSz;
  public String ctType;
  public String alias;
  public String state;

  public BigDecimal getCtVal() {
    return Util.parseString(ctVal, BigDecimal.ONE);
  }

  public BigDecimal getCtMult() {
    return Util.parseString(ctMult, BigDecimal.ONE);
  }
}
