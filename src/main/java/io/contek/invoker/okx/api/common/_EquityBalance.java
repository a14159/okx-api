package io.contek.invoker.okx.api.common;

import javax.annotation.concurrent.NotThreadSafe;
import java.math.BigDecimal;

@NotThreadSafe
public class _EquityBalance {

  public BigDecimal availBal; // Available balance of the currency
  public BigDecimal availEq; // Available equity of the currency
  public String borrowFroz;
  public BigDecimal cashBal; // Cash balance
  public String ccy; // Currency
  public String crossLiab; // Cross liabilities of the currency
  public BigDecimal disEq; // Discount equity of the currency in USD.
  public BigDecimal eq; // Equity of the currency
  public BigDecimal eqUsd; // Equity in USD of the currency
  public BigDecimal frozenBal; // Frozen balance of the currency
  public String interest; // Accrued interest of the currency
  public BigDecimal isoEq; // Isolated margin equity of the currency
  public String isoLiab; // Isolated liabilities of the currency
  public BigDecimal isoUpl; // Isolated unrealized profit and loss of the currency
  public String liab; // Liabilities of the currency
  public String maxLoan; // Max loan of the currency
  public String mgnRatio; // Margin ratio of the currency
  public String notionalLever; // Leverage of the currency Applicable to Single-currency margin
  public BigDecimal ordFrozen; // Margin frozen for open orders
  public BigDecimal twap; // Risk indicator of auto liability repayment Divided into 5 levels, from 1 to 5, the larger the number, the more likely the auto repayment will be triggered.
  public long uTime;
  public BigDecimal upl; // The sum of the unrealized profit & loss of all margin and derivatives positions of the currency.
  public String uplLiab; // Liabilities due to Unrealized loss of the currency
  public BigDecimal stgyEq; // Strategy equity
  public String spotInUseAmt; // Spot in use amount

  public BigDecimal getLiab() {
    return Util.parseString(liab, BigDecimal.ZERO);
  }
}
