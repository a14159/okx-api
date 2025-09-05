package io.contek.invoker.okx.api.common;

import javax.annotation.concurrent.NotThreadSafe;

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
  public Double tickSz;
  public Double lotSz;
  public Double minSz;
  public Double maxLmtSz;
  public String maxMktSz;
  public String ctType;
  public String alias;
  public String state;

  public Double getCtVal() {
    return Util.parseString(ctVal, 1.0);
  }

  public Double getCtMult() {
    return Util.parseString(ctMult, 1.0);
  }

  public Double getMaxMktSz() {
    return Util.parseString(maxMktSz, Double.MAX_VALUE);
  }
}
