package io.contek.invoker.okx.api.common;

import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class _Order {

  public Double accFillSz;
  public String amendResult;
  public String avgPx;
  public long cTime;
  public String category;
  public String ccy;
  public String clOrdId;
  public String code;
  public String execType;
  public String fee;
  public String feeCcy;
  public Double fillFee;
  public String fillFeeCcy;
  public String fillNotionalUsd;
  public String fillPx;
  public Double fillSz;
  public String fillTime;
  public String instId;
  public String instType;
  public String lever;
  public String ordId;
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
  public Double sz;
  public String tag;
  public String tdMode;
  public String tgtCcy;
  public String source;
  public String tpOrdPx;
  public String tpTriggerPx;
  public String tpTriggerPxType;
  public String tradeId;
  public long uTime;
  public long traceNano = System.nanoTime();

  public Double getPx() {
    return Util.parseString(px, 0.0);
  }

  public Double getFillPx() {
    return Util.parseString(fillPx, 0.0);
  }

  public Double getAvgPx() {
    return Util.parseString(avgPx, 0.0);
  }

  public long getFillTime() {
    return Util.parseString(fillTime, 0);
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
