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
package io.atomix.catalyst.util.hash;

/**
 * String hasher.
 *
 * @author <a href="http://github.com/kuujo>Jordan Halterman</a>
 */
public class StringHasher implements Hasher {

  @Override
  public int hash32(byte[] bytes) {
    int h = 0;
    int length = bytes.length;
    for (int i = 0; i < length; i++) {
      h = 31 * h + bytes[i];
    }
    return h;
  }

  @Override
  public long hash64(byte[] bytes) {
    long h = 1125899906842597L;
    int length = bytes.length;
    for (int i = 0; i < length; i++) {
      h = 31 * h + bytes[i];
    }
    return h;
  }

  @Override
  public int hashCode() {
    return 15485867;
  }

}
