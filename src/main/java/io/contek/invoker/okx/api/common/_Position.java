package io.contek.invoker.okx.api.common;

import javax.annotation.concurrent.NotThreadSafe;

/**
 * A position as returned by the private {@code positions} WebSocket channel and by
 * {@code GET /api/v5/account/positions}.
 *
 * <p>All values are the raw strings returned by the exchange, so an absent or empty value is
 * preserved distinctly from an actual zero.
 *
 * <p>{@link #fundingFee} is an <em>accumulated</em> funding fee for the position, not a single
 * funding payment; do not assume a one-to-one mapping to a funding event. Per the OKX docs the
 * lifetime/reset semantics of this accumulator are not stated for {@code fundingFee} (unlike
 * {@link #fee}, which "resets to 0 when the position is fully closed"). {@link #realizedPnl} is
 * defined by OKX as {@code pnl + fee + fundingFee + liqPenalty + settledPnl}, so a downstream
 * consumer must difference the accumulation itself to obtain per-period payments.
 */
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

  public String baseBal;
  public String quoteBal;
  public String baseBorrowed;
  public String baseInterest;
  public String quoteBorrowed;
  public String quoteInterest;
  public String bizRefId;
  public String bizRefType;
  public String bePx;
  public String idxPx;
  public String hedgedPos;
  public String pendingCloseOrdLiabVal;
  public String nonSettleAvgPx;
  public String spotInUseAmt;
  public String spotInUseCcy;
  public String clSpotInUseAmt;
  public String maxSpotInUseAmt;
  public String uplLastPx;
  public String uplRatioLastPx;
  public String pnl;
  public String fee;
  public String fundingFee;
  public String liqPenalty;
  public String realizedPnl;
  public String settledPnl;

  public Double getAvgPx() {
    return Util.parseString(avgPx, 0.0);
  }

  public Double getUpl() {
    return Util.parseString(upl, 0.0);
  }

  public Double getMarkPx() {
    return Util.parseString(markPx, 0.0);
  }

  public Double getMmr() {
    return Util.parseString(mmr, 0.0);
  }

  public Double getPos() {
    return Util.parseString(pos, 0.0);
  }

  public Double getAvailablePos() {
    return Util.parseString(availPos, 0.0);
  }
}
