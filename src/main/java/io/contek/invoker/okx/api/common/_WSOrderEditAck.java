package io.contek.invoker.okx.api.common;

import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class _WSOrderEditAck {

  public String clOrdId;
  public String ordId;
  public String tag; // place order, amend order
  public String reqId; // cancel order
  public String sCode;
  public String sMsg;
}
