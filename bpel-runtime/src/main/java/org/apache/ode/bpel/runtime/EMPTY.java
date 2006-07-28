/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.ode.bpel.runtime;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * JacobRunnable that performs the work of the <code>empty</code> activity.
 */
class EMPTY extends ACTIVITY {
	private static final long serialVersionUID = 1L;
	private static final Log __log = LogFactory.getLog(EMPTY.class);

  public EMPTY(ActivityInfo self, ScopeFrame frame, LinkFrame linkFrame) {
    super(self, frame, linkFrame);
  }

  public final void self() {
    if (__log.isDebugEnabled()) {
      __log.debug("<empty name=" + _self.o + ">");
    }

    _self.parent.completed(null, CompensationHandler.emptySet());
  }
}
