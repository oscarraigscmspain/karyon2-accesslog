package com.scmspain.karyon.accesslog.dto;

import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpVersion;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AccessLogTest {
  private String httpVersion;
  private String method;
  private String uri;

  private String clientIp;
  private String userAgent;

  private AccessLog log;

  @Test
  public void testItShouldBeBuiltRequestInformation() throws Exception {
    givenARequest();
    whenAccessLogIsCreated();
    thenLogShouldContainRequestInformation();
  }

  @Test
  public void testItShouldBeBuiltWithUserInformation() throws Exception {
    givenARequestWithUserInformation();
    whenAccessLogIsCreatedWithUserInfo();
    thenLogShouldContainUserInformation();
  }

  private void givenARequest() {
    httpVersion = HttpVersion.HTTP_1_0.toString();
    method = HttpMethod.GET.toString();
    uri = "/status";
  }

  private void givenARequestWithUserInformation() {
    givenARequest();
    clientIp = "127.0.0.1";
    userAgent = "Curl";
  }

  private void whenAccessLogIsCreated() {
    log = new AccessLog(httpVersion, method, uri);
  }

  private void whenAccessLogIsCreatedWithUserInfo() {
    log = new AccessLog(httpVersion, method, uri, clientIp, userAgent);
  }

  private void thenLogShouldContainRequestInformation() {
    assertThat(log.httpVersion(), is(httpVersion));
    assertThat(log.method(), is(method));
    assertThat(log.uri(), is(uri));
  }

  private void thenLogShouldContainUserInformation() {
    assertThat(log.clientIp(), is(clientIp));
    assertThat(log.userAgent(), is(userAgent));
  }
}