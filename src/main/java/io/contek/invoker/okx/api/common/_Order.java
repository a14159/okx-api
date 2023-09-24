package io.contek.invoker.okx.api.common;

import javax.annotation.concurrent.NotThreadSafe;
import java.math.BigDecimal;

@NotThreadSafe
public class _Order {

  public BigDecimal accFillSz;
  public String amendResult;
  public BigDecimal avgPx;
  public long cTime;
  public String category;
  public String ccy;
  public String clOrdId;
  public String code;
  public String execType;
  public String fee;
  public String feeCcy;
  public BigDecimal fillFee;
  public String fillFeeCcy;
  public String fillNotionalUsd;
  public String fillPx;
  public BigDecimal fillSz;
  public String fillTime;
  public String instId;
  public String instType;
  public String lever;
  public long ordId;
  public String ordType;
  public String pnl;
  public String posSide;
  public String px;
  public String rebate;
  public String rebateCcy;
  public String reduceOnly;
  public String reqId;
  public String side;
  public String slOrdPx;
  public String slTriggerPx;
  public String slTriggerPxType;
  public String state;
  public BigDecimal sz;
  public String tag;
  public String tdMode;
  public String tgtCcy;
  public String source;
  public String tpOrdPx;
  public String tpTriggerPx;
  public String tpTriggerPxType;
  public String tradeId;
  public long uTime;

  public BigDecimal getPx() {
    if (px == null || px.isEmpty())
      return BigDecimal.ZERO;
    return new BigDecimal(px);
  }

  public BigDecimal getFillPx() {
    if (fillPx == null || fillPx.isEmpty())
      return BigDecimal.ZERO;
    return new BigDecimal(fillPx);
  }

  public long getFillTime() {
    if (fillTime == null || fillTime.isEmpty())
      return 0;
    return Long.parseLong(fillTime);
  }

  public long getTradeId() {
    if (tradeId == null || tradeId.isEmpty())
      return 0;
    return Long.parseLong(tradeId);
  }

  @Override
  public String toString() {
    return "_Order{" +
            "instType='" + instType + '\'' +
            ", instId='" + instId + '\'' +
            ", ordType='" + ordType + '\'' +
            ", side='" + side + '\'' +
            ", state='" + state + '\'' +
            ", size=" + sz +
            ", price='" + px + '\'' +
            ", fillPx='" + fillPx + '\'' +
            ", fillSz=" + fillSz +
            ", accFillSz=" + accFillSz +
            ", avgPx=" + avgPx +
            ", tgtCcy=" + tgtCcy +
            ", ccy='" + ccy + '\'' +
            ", clOrdId='" + clOrdId + '\'' +
            ", code='" + code + '\'' +
            ", execType='" + execType + '\'' +
            ", fee='" + fee + '\'' +
            ", feeCcy='" + feeCcy + '\'' +
            ", lever='" + lever + '\'' +
            ", ordId=" + ordId +
            ", posSide='" + posSide + '\'' +
            ", reduceOnly='" + reduceOnly + '\'' +
            ", tdMode='" + tdMode + '\'' +
            ", tradeId='" + tradeId + '\'' +
            '}';
  }
}
