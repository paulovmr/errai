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
package org.jboss.errai.security.client.local;

import javax.enterprise.context.ApplicationScoped;

import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.nav.client.local.PageShowing;
import org.jboss.errai.ui.nav.client.local.api.SecurityError;

import com.google.gwt.user.client.ui.SimplePanel;

@Page(role = SecurityError.class)
@ApplicationScoped
public class TestSecurityErrorPage extends SimplePanel {
  
  private int pageLoadCounter = 0;

  public int getPageLoadCounter() {
    return pageLoadCounter;
  }

  @PageShowing
  public void incrementCounter() {
    pageLoadCounter += 1;
  }

}
