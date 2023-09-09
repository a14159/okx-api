package io.contek.invoker.okx.api.common;

import javax.annotation.concurrent.NotThreadSafe;
import java.math.BigDecimal;
import java.util.List;

@NotThreadSafe
public class _AccountBalance {

  public BigDecimal adjEq; // Adjusted / Effective equity in USD
  public BigDecimal imr; // Initial margin requirement in USD
  public BigDecimal isoEq; // Isolated margin equity in USD
  public String mgnRatio; // Margin ratio in USD
  public BigDecimal mmr; // Maintenance margin requirement in USD
  public BigDecimal notionalUsd; // Notional value of positions in USD
  public String ordFroz; // Cross margin frozen for pending orders in USD
  public BigDecimal totalEq; // The total amount of equity in USD
  public long uTime; // Update time of account information, millisecond format of Unix timestamp, e.g. 1597026383085
  public List<_EquityBalance> details;
}
