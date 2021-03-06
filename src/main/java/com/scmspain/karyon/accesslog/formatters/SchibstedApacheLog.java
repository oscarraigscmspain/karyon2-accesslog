package com.scmspain.karyon.accesslog.formatters;

import com.google.inject.Inject;
import com.scmspain.karyon.accesslog.AccessLog;

public class SchibstedApacheLog implements AccessLogFormatter {

  private CombinedApacheLog combinedApacheLogFormatter;

  @Inject
  SchibstedApacheLog(CombinedApacheLog combinedApacheLogFormatter) {
    this.combinedApacheLogFormatter = combinedApacheLogFormatter;
  }

  @Override
  public String format(AccessLog logLine) {
    return String.format(
      "%s %d %d",
      combinedApacheLogFormatter.format(logLine),
      logLine.responseSize(),
      logLine.timeTaken()
    );
  }

}
