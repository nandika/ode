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

import org.apache.ode.bom.api.FaultHandler;
import org.apache.ode.bom.impl.nodes.FaultHandlerImpl;
import org.apache.ode.sax.fsa.ParseContext;
import org.apache.ode.sax.fsa.ParseException;
import org.apache.ode.sax.fsa.State;
import org.apache.ode.sax.fsa.StateFactory;
import org.apache.ode.sax.evt.StartElement;

class Bpel11FaultHandlersState extends BaseBpelState {

  private static final StateFactory _factory = new Factory();
  private FaultHandlerImpl _f;
   
  private Bpel11FaultHandlersState(StartElement se, ParseContext pc) throws ParseException {
    super(pc);
    _f = new FaultHandlerImpl();
    _f.setNamespaceContext(se.getNamespaceContext());
    _f.setLineNo(se.getLocation().getLineNumber());
  }
  
  public FaultHandler getFaultHandler() {
    return _f;
  }
  
  /**
   * @see org.apache.ode.sax.fsa.State#handleChildCompleted(org.apache.ode.sax.fsa.State)
   */
  public void handleChildCompleted(State pn) throws ParseException {
    switch (pn.getType()) {
    case BPEL11_CATCH:
    case BPEL11_CATCHALL:
      _f.addCatch(((Bpel11CatchAllState)pn).getCatch());
      break;
    default:
      super.handleChildCompleted(pn);
    }
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
    return BPEL11_FAULTHANDLERS;
  }
  
  static class Factory implements StateFactory {
    
    public State newInstance(StartElement se, ParseContext pc) throws ParseException {
      return new Bpel11FaultHandlersState(se, null);
    }
  }
}
