/*
 * Copyright 2011 JBoss, a divison Red Hat, Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jboss.errai.ioc.rebind.ioc.codegen.literal;

import org.jboss.errai.ioc.rebind.ioc.codegen.Context;
import org.jboss.errai.ioc.rebind.ioc.codegen.Statement;
import org.jboss.errai.ioc.rebind.ioc.codegen.meta.MetaClass;
import org.jboss.errai.ioc.rebind.ioc.codegen.meta.MetaClassFactory;

/**
 * @author Mike Brock <cbrock@redhat.com>
 */
public abstract class LiteralValue<T> implements Statement {
  private T value;

  public abstract String getCanonicalString(Context context);

  protected LiteralValue(T value) {
    this.value = value;
  }

  public T getValue() {
    return value;
  }

  public String generate(Context context) {
    return getCanonicalString(context);
  }

  public MetaClass getType() {
    if(value==null) return MetaClassFactory.get(Object.class);
    
    return Class.class.isAssignableFrom(value.getClass())
        ? MetaClassFactory.get((Class<?>) value) : MetaClassFactory.get(value.getClass());
  }

  @Override
  public int hashCode() {
    return (value == null) ? 0 : value.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    LiteralValue<?> other = (LiteralValue<?>) obj;
    if (value == null) {
      if (other.value != null)
        return false;
    }
    else if (!value.equals(other.value))
      return false;
    return true;
  }
}