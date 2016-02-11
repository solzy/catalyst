/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */
package io.atomix.catalyst.transport;

import io.atomix.catalyst.util.PropertiesReader;

import java.util.Properties;

/**
 * Netty transport properties.
 *
 * @author <a href="http://github.com/kuujo>Jordan Halterman</a>
 */
public final class NettyProperties {
  public static final String THREADS = "threads";
  public static final String CONNECT_TIMEOUT = "connectTimeout";
  public static final String SEND_BUFFER_SIZE = "sendBufferSize";
  public static final String RECEIVE_BUFFER_SIZE = "receiveBufferSize";
  public static final String REUSE_ADDRESS = "reuseAddress";
  public static final String TCP_KEEP_ALIVE = "tcpKeepAlive";
  public static final String TCP_NO_DELAY = "tcpNoDelay";
  public static final String ACCEPT_BACKLOG = "acceptBacklog";

  public static final String SSL_ENABLED = "ssl.enabled";
  public static final String SSL_PROTOCOL = "ssl.protocol";
  public static final String SSL_TRUSTSTORE_PATH = "ssl.truststore.path";
  public static final String SSL_TRUSTSTORE_PASSWORD = "ssl.truststore.password";
  public static final String SSL_KEYSTORE_PATH = "ssl.keystore.path";
  public static final String SSL_KEYSTORE_PASSWORD = "ssl.keystore.password";
  public static final String SSL_KEYSTORE_KEY_PASSWORD = "ssl.keystore.keypassword";

  private static final int DEFAULT_THREADS = Runtime.getRuntime().availableProcessors();
  private static final int DEFAULT_CONNECT_TIMEOUT = 5000;
  private static final int DEFAULT_SEND_BUFFER_SIZE = -1;
  private static final int DEFAULT_RECEIVE_BUFFER_SIZE = -1;
  private static final boolean DEFAULT_REUSE_ADDRESS = true;
  private static final boolean DEFAULT_TCP_KEEP_ALIVE = true;
  private static final boolean DEFAULT_TCP_NO_DELAY = false;
  private static final int DEFAULT_ACCEPT_BACKLOG = 1024;

  private static final boolean DEFAULT_SSL_ENABLED = false;
  private static final String DEFAULT_SSL_PROTOCOL = "TLSv1.2";

  private final PropertiesReader reader;

  public NettyProperties(Properties properties) {
    this.reader = new PropertiesReader(properties);
  }

  /**
   * The number of event loop threads.
   */
  public int threads() {
    int threads = reader.getInteger(THREADS, DEFAULT_THREADS);
    if (threads == -1) {
      return Runtime.getRuntime().availableProcessors();
    }
    return threads;
  }

  /**
   * The connect timeout in milliseconds.
   */
  public int connectTimeout() {
    return reader.getInteger(CONNECT_TIMEOUT, DEFAULT_CONNECT_TIMEOUT);
  }

  /**
   * The TCP send buffer size.
   */
  public int sendBufferSize() {
    return reader.getInteger(SEND_BUFFER_SIZE, DEFAULT_SEND_BUFFER_SIZE);
  }

  /**
   * The TCP receive buffer size.
   */
  public int receiveBufferSize() {
    return reader.getInteger(RECEIVE_BUFFER_SIZE, DEFAULT_RECEIVE_BUFFER_SIZE);
  }

  /**
   * The SO_REUSEADDR option.
   */
  public boolean reuseAddress() {
    return reader.getBoolean(REUSE_ADDRESS, DEFAULT_REUSE_ADDRESS);
  }

  /**
   * The SO_KEEPALIVE option.
   */
  public boolean tcpKeepAlive() {
    return reader.getBoolean(TCP_KEEP_ALIVE, DEFAULT_TCP_KEEP_ALIVE);
  }

  /**
   * The TCP_NODELAY option.
   */
  public boolean tcpNoDelay() {
    return reader.getBoolean(TCP_NO_DELAY, DEFAULT_TCP_NO_DELAY);
  }

  /**
   * The TCP accept backlog.
   */
  public int acceptBacklog() {
    return reader.getInteger(ACCEPT_BACKLOG, DEFAULT_ACCEPT_BACKLOG);
  }

  /**
   * The SSL enable.
   */
  public boolean sslEnabled() {
    return reader.getBoolean(SSL_ENABLED, DEFAULT_SSL_ENABLED);
  }

  /**
   * The SSL Protocol.
   */
  public String sslProtocol() {
    return reader.getString(SSL_PROTOCOL, DEFAULT_SSL_PROTOCOL);
  }

  /**
   * The SSL truststore path.
   */
  public String sslTruststorePath() {
    return reader.getString(SSL_TRUSTSTORE_PATH, null);
  }

  /**
   * The SSL truststore password.
   */
  public String sslTruststorePassword() {
    return reader.getString(SSL_TRUSTSTORE_PASSWORD, null);
  }

  /**
   * The SSL keystore path.
   */
  public String sslKeystorePath() {
    return reader.getString(SSL_KEYSTORE_PATH);
  }

  /**
   * The SSL keystore password.
   */
  public String sslKeystorePassword() {
    return reader.getString(SSL_KEYSTORE_PASSWORD, null);
  }

  /**
   * The SSL keystore key password.
   */
  public String sslKeystoreKeyPassword() {
    return reader.getString(SSL_KEYSTORE_KEY_PASSWORD, null);
  }

}
