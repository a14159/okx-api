package io.contek.invoker.okx.api.common;

import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class _EquityBalance {

  public Double availBal; // Available balance of the currency
  public String availEq; // Available equity of the currency
  public String borrowFroz;
  public Double cashBal; // Cash balance
  public String ccy; // Currency
  public String crossLiab; // Cross liabilities of the currency
  public Double disEq; // Discount equity of the currency in USD.
  public Double eq; // Equity of the currency
  public Double eqUsd; // Equity in USD of the currency
  public Double frozenBal; // Frozen balance of the currency
  public String interest; // Accrued interest of the currency
  public Double isoEq; // Isolated margin equity of the currency
  public String isoLiab; // Isolated liabilities of the currency
  public String isoUpl; // Isolated unrealized profit and loss of the currency
  public String liab; // Liabilities of the currency
  public String maxLoan; // Max loan of the currency
  public String mgnRatio; // Margin ratio of the currency
  public String notionalLever; // Leverage of the currency Applicable to Single-currency margin
  public Double ordFrozen; // Margin frozen for open orders
  public String twap; // Risk indicator of auto liability repayment Divided into 5 levels, from 1 to 5, the larger the number, the more likely the auto repayment will be triggered.
  public long uTime;
  public String upl; // The sum of the unrealized profit & loss of all margin and derivatives positions of the currency.
  public String uplLiab; // Liabilities due to Unrealized loss of the currency
  public String stgyEq; // Strategy equity
  public String spotInUseAmt; // Spot in use amount

  public Double getLiab() {
    return Util.parseString(liab, 0.0);
  }
}
