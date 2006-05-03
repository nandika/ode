/*
 * Copyright 2006 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.ode.sax.fsa.bpel_1_1;

import org.apache.ode.bom.api.CompensationHandler;
import org.apache.ode.bom.impl.nodes.CompensationHandlerImpl;
import org.apache.ode.sax.fsa.ParseContext;
import org.apache.ode.sax.fsa.ParseException;
import org.apache.ode.sax.fsa.State;
import org.apache.ode.sax.fsa.StateFactory;
import org.apache.ode.sax.evt.StartElement;

class Bpel11CompensationHandlerState extends BaseBpelState {

  private static final StateFactory _factory = new Factory();
  private CompensationHandlerImpl _c;
  
  Bpel11CompensationHandlerState(StartElement se, ParseContext pc) throws ParseException {
    super(pc);
    _c = new CompensationHandlerImpl();
    _c.setNamespaceContext(se.getNamespaceContext());
    _c.setLineNo(se.getLocation().getLineNumber());
  }
  
  public void handleChildCompleted(State pn) throws ParseException {
    if (pn instanceof ActivityStateI) {
      _c.setActivity(((ActivityStateI)pn).getActivity());
    } else {
      super.handleChildCompleted(pn);
    }
  }
  
  public CompensationHandler getCompensationHandler() {
    return _c;
  }

  /**
   * @see org.apache.ode.sax.fsa.State#getFactory()
   */
  public StateFactory getFactory() {
    return _factory;
  }

  /**
   * @see org.apache.ode.sax.fsa.State#getType()
   */
  public int getType() {
    return BPEL11_COMPENSATIONHANDLER;
  }
  
  static class Factory implements StateFactory {
    
    public State newInstance(StartElement se, ParseContext pc) throws ParseException {
      return new Bpel11CompensationHandlerState(se,pc);
    }
  }
}
