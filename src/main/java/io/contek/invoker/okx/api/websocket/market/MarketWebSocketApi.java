package io.contek.invoker.okx.api.websocket.market;

import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.websocket.WebSocketCall;
import io.contek.invoker.commons.websocket.WebSocketContext;
import io.contek.invoker.okx.api.websocket.WebSocketApi;
import io.contek.invoker.security.ICredential;

import javax.annotation.concurrent.ThreadSafe;
import java.util.HashMap;
import java.util.Map;

@ThreadSafe
public final class MarketWebSocketApi extends WebSocketApi {

  private final WebSocketContext context;

  private final String name;

  private final Map<OrderBookChannel.Id, OrderBookChannel> orderBookChannels = new HashMap<>();
  private final Map<TickersChannel.Id, TickersChannel> tickerChannels = new HashMap<>();
  private final Map<TradesChannel.Id, TradesChannel> tradesChannels = new HashMap<>();
  private final Map<MarkPriceChannel.Id, MarkPriceChannel> markPriceChannels = new HashMap<>();
  private final Map<IndexTickersChannel.Id, IndexTickersChannel> indexTickersChannels =
      new HashMap<>();

  public MarketWebSocketApi(String name, IActor actor, WebSocketContext context) {
    super(name, actor); // "name" here is used by the live keeper thread to log/report events
    this.name = name;
    this.context = context;
  }

  public OrderBookChannel getOrderBookChannel(String instId, int depth, boolean l2, boolean tbt) {
    synchronized (orderBookChannels) {
      return orderBookChannels.computeIfAbsent(
          OrderBookChannel.Id.of(instId, depth, l2, tbt),
          k -> {
            OrderBookChannel result = new OrderBookChannel(k);
            attach(result);
            return result;
          });
    }
  }

  public TickersChannel getTickerChannel(String instId) {
    synchronized (tickerChannels) {
      return tickerChannels.computeIfAbsent(
          TickersChannel.Id.of(instId),
          k -> {
            TickersChannel result = new TickersChannel(k);
            attach(result);
            return result;
          });
    }
  }

  public TradesChannel getTradesChannel(String instId) {
    synchronized (tradesChannels) {
      return tradesChannels.computeIfAbsent(
          TradesChannel.Id.of(instId),
          k -> {
            TradesChannel result = new TradesChannel(k);
            attach(result);
            return result;
          });
    }
  }

  public MarkPriceChannel getMarkPriceChannel(String instId) {
    synchronized (markPriceChannels) {
      return markPriceChannels.computeIfAbsent(
          MarkPriceChannel.Id.of(instId),
          k -> {
            MarkPriceChannel result = new MarkPriceChannel(k);
            attach(result);
            return result;
          });
    }
  }

  public IndexTickersChannel getIndexTickersChannel(String instId) {
    synchronized (indexTickersChannels) {
      return indexTickersChannels.computeIfAbsent(
          IndexTickersChannel.Id.of(instId),
          k -> {
            IndexTickersChannel result = new IndexTickersChannel(k);
            attach(result);
            return result;
          });
    }
  }

  @Override
  protected WebSocketCall createCall(ICredential credential) {
    if (!"TEST".equals(name))
        return WebSocketCall.fromUrl(context.getBaseUrl() + "/ws/v5/public");
    else
        return WebSocketCall.fromUrl(context.getBaseUrl() + "/ws/v5/public?brokerId=9999");
  }
}
