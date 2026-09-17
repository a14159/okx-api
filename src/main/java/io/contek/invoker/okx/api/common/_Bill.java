package io.contek.invoker.okx.api.common;

import javax.annotation.concurrent.NotThreadSafe;

/**
 * A single trading-account bill as returned by {@code GET /api/v5/account/bills} and
 * {@code GET /api/v5/account/bills-archive}.
 *
 * <p>All numeric values are kept as the raw strings returned by the exchange so that an absent or
 * empty value is preserved distinctly from an actual zero. Use the OKX "Get bill types"
 * ({@code GET /api/v5/account/subtypes}) mapping to interpret {@link #type} / {@link #subType}.
 *
 * <p>Perpetual funding: {@code subType} {@code "173"} is funding fee expense and {@code "174"} is
 * funding fee income. For funding bills the signed funding amount is carried by {@link #pnl}; the
 * OKX docs explicitly state "You may refer to pnl for the fee payment" for subType 173. Do not use
 * {@link #balChg} (cash balance change) or {@link #posBalChg} as the funding amount without
 * reconciling the documented semantics.
 */
@NotThreadSafe
public class _Bill {

  public String instType;
  public String billId;
  public String type;
  public String subType;
  public String ts;
  public String balChg;
  public String posBalChg;
  public String bal;
  public String posBal;
  public String sz;
  public String px;
  public String ccy;
  public String pnl;
  public String fee;
  public String earnAmt;
  public String earnApr;
  public String mgnMode;
  public String instId;
  public String ordId;
  public String execType;
  public String from;
  public String to;
  public String notes;
  public String interest;
  public String tag;
  public String fillTime;
  public String tradeId;
  public String clOrdId;
  public String fillIdxPx;
  public String fillMarkPx;
  public String fillPxVol;
  public String fillPxUsd;
  public String fillMarkVol;
  public String fillFwdPx;
  public long traceNano = System.nanoTime();
}
