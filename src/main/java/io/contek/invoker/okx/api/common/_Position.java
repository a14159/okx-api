package io.contek.invoker.okx.api.common;

import javax.annotation.concurrent.NotThreadSafe;
import java.math.BigDecimal;

@NotThreadSafe
public class _Position {

  public String adl;
  public String availPos;
  public String avgPx;
  public String cTime;
  public String ccy;
  public String deltaBS;
  public String deltaPA;
  public String gammaBS;
  public String gammaPA;
  public String imr;
  public String instId;
  public String instType;
  public String interest;
  public String usdPx;
  public String last;
  public String lever;
  public String liab;
  public String liabCcy;
  public String liqPx;
  public String markPx;
  public String margin;
  public String mgnMode;
  public String mgnRatio;
  public String mmr;
  public String notionalUsd;
  public String optVal;
  public String pTime;
  public String pos;
  public String posCcy;
  public String posId;
  public String posSide;
  public String thetaBS;
  public String thetaPA;
  public String tradeId;
  public String uTime;
  public String upl;
  public String uplRatio;
  public String vegaBS;
  public String vegaPA;

  public BigDecimal getAvgPx() {
    return Util.parseString(avgPx, BigDecimal.ZERO);
  }

  public BigDecimal getMarkPx() {
    return Util.parseString(markPx, BigDecimal.ZERO);
  }

  public BigDecimal getMmr() {
    return Util.parseString(mmr, BigDecimal.ZERO);
  }

  public BigDecimal getPos() {
    return Util.parseString(pos, BigDecimal.ZERO);
  }

  public BigDecimal getAvailablePos() {
    return Util.parseString(availPos, BigDecimal.ZERO);
  }
}
