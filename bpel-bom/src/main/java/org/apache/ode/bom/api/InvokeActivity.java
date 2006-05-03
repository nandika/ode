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
 * BOM representation of a BPEL <code>&lt;invoke&gt;</code> activity.
 */
public interface InvokeActivity extends Activity, Communication, ScopeLikeConstruct {
  /**
   * Set the input variable.
   *
   * @param variable name of input variable
   */
  void setInputVar(String variable);

  /**
   * Get the input variable.
   *
   * @return name of input variable
   */
  String getInputVar();

  /**
   * Set the output variable.
   *
   * @param variable output variable name
   */
  void setOutputVar(String variable);

  /**
   * The output variable.
   *
   * @return output variable name
   */
  String getOutputVar();


}
