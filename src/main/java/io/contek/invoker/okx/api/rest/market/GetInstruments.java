package io.contek.invoker.okx.api.rest.market;

import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.rest.RestParams;
import io.contek.invoker.okx.api.common._Instrument;
import io.contek.invoker.okx.api.rest.common.ResponseWrapper;

import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

import static io.contek.invoker.okx.api.common.constants.InstrumentTypeKeys.*;
import static java.util.Objects.requireNonNull;
import static java.util.Objects.requireNonNullElse;

@NotThreadSafe
public final class GetInstruments extends MarketRestRequest<GetInstruments.Response> {

  private String instType;
  private String instFamily;
  private String uly;
  private String instId;

  GetInstruments(IActor actor, RestContext context) {
    super(actor, context);
  }

  public GetInstruments setInstType(String instType) {
    this.instType = instType;
    return this;
  }

  public GetInstruments setInstFamily(String instFamily) {
    this.instFamily = instFamily;
    return this;
  }

  public GetInstruments setUly(@Nullable String uly) {
    this.uly = uly;
    return this;
  }

  public GetInstruments setInstId(@Nullable String instId) {
    this.instId = instId;
    return this;
  }

  @Override
  protected String getEndpointPath() {
    return "/api/v5/public/instruments";
  }

  @Override
  protected RestParams getParams() {
    RestParams.Builder builder = RestParams.newBuilder();

    requireNonNull(instType);
    builder.add("instType", instType);

    switch (instType) {
      case _OPTION:
        requireNonNullElse(uly, instFamily);
      case _FUTURES:
      case _SWAP:
        if (uly != null)
          builder.add("uly", uly);
        if (instFamily != null)
            builder.add("instFamily", instFamily);
        break;
      default:
    }

    if (instId != null) {
      builder.add("instId", instId);
    }

    return builder.build();
  }

  @Override
  protected Class<Response> getResponseType() {
    return Response.class;
  }

  @NotThreadSafe
  public static final class Response extends ResponseWrapper<_Instrument> {}
}
