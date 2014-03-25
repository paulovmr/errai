/**
 * JBoss, Home of Professional Open Source
 * Copyright 2014, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.errai.security.client.local.res;

import org.jboss.errai.bus.client.api.BusErrorCallback;
import org.jboss.errai.bus.client.api.messaging.Message;
import org.jboss.errai.security.shared.exception.SecurityException;

public class ErrorCountingCallback extends BusErrorCallback {
  private final Counter counter;
  private final Class<? extends SecurityException> throwType;

  public ErrorCountingCallback(final Counter counter, final Class<? extends SecurityException> throwType) {
    this.counter = counter;
    this.throwType = throwType;
  }

  @Override
  public boolean error(Message message, Throwable throwable) {
    if (throwable.getClass().equals(throwType)) {
      counter.increment();
      return false;
    }
    else {
      return true;
    }
  }
}