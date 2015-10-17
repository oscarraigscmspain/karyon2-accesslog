package com.scmspain.karyon.accesslog.module;

import com.google.gson.GsonBuilder;
import com.google.inject.AbstractModule;
import com.scmspain.karyon.accesslog.formatters.AccessLogFormatter;
import com.scmspain.karyon.accesslog.formatters.JsonLog;

public class AccessLogModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(GsonBuilder.class).asEagerSingleton();
  }
}
