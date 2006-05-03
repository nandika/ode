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
package org.apache.ode.bom.api;

/**
 * Representation of a BPEL termination handler.
 */
public interface TerminationHandler extends BpelObject {


  /**
   * Get the termination activity. This is the
   * activity that gets activated if the termination handler
   * is activated.
   *
   * @return termination activity.
   */
  Activity getActivity();


  /**
   * Set the terrmination activity. This is the
   * activity that gets activated if the termination handler
   * is activated.
   *
   * @param terminationActivity
   */
  void setActivity(Activity terminationActivity);

}
