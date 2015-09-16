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
 * limitations under the License.
 */
package net.kuujo.catalyst.serializer.lang;

import net.kuujo.catalyst.buffer.BufferInput;
import net.kuujo.catalyst.buffer.BufferOutput;
import net.kuujo.catalyst.serializer.Serializer;
import net.kuujo.catalyst.serializer.TypeSerializer;

/**
 * Boolean serializer.
 *
 * @author <a href="http://github.com/kuujo">Jordan Halterman</a>
 */
public class BooleanSerializer implements TypeSerializer<Boolean> {

  @Override
  public void write(Boolean object, BufferOutput buffer, Serializer serializer) {
    buffer.writeBoolean(object);
  }

  @Override
  public Boolean read(Class<Boolean> type, BufferInput buffer, Serializer serializer) {
    return buffer.readBoolean();
  }

}