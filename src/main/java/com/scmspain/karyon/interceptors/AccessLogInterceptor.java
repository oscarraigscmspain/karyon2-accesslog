package com.scmspain.karyon.interceptors;

import io.netty.buffer.ByteBuf;
import io.reactivex.netty.protocol.http.server.HttpServerRequest;
import io.reactivex.netty.protocol.http.server.HttpServerResponse;
import netflix.karyon.transport.interceptor.DuplexInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.Observable;

public class AccessLogInterceptor
    implements DuplexInterceptor<HttpServerRequest<ByteBuf>, HttpServerResponse<ByteBuf>> {

  private static final Logger LOGGER = LoggerFactory.getLogger(AccessLogInterceptor.class);

  @Override
  public Observable<Void> in(
      HttpServerRequest<ByteBuf> request,
      HttpServerResponse<ByteBuf> response
  ) {
    return Observable.empty();
  }

  @Override
  public Observable<Void> out(HttpServerResponse<ByteBuf> response) {
    return Observable.empty();
  }
}
