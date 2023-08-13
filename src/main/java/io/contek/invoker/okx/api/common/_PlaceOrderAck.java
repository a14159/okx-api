package io.contek.invoker.okx.api.common;

import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class _PlaceOrderAck {

  public String clOrdId;
  public String ordId;
  public String tag;
  public long sCode;
  public String sMsg;
}
