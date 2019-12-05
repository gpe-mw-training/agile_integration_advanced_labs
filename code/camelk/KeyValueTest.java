/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.camel.builder.RouteBuilder;

public class KeyValueTest extends RouteBuilder {
  @Override
  public void configure() throws Exception {
                from("timer:tick")
                    .setBody(constant("Hello"))
                    .setHeader("KeyValueTestAction", constant("PUT"))
                    .setHeader("KeyValueTestKey", constant("1"))
                    .toF("keyvaluetest-cache://%s", "test")
                    .log("Result of Action ${header.KeyValueTestAction} with key ${header.KeyValueTestKey} is: ${body}")
                    .setBody(constant(null))
                    .setHeader("KeyValueTestAction", constant("GET"))
                    .setHeader("KeyValueTestKey", constant("1"))
                    .toF("keyvaluetest-cache://%s", "test")
                    .log("Result of Action ${header.KeyValueTestAction} with key ${header.KeyValueTestKey} is: ${body}")
                    .setBody(constant(null))
                    .setHeader("KeyValueTestAction", constant("INVALIDATE"))
                    .setHeader("KeyValueTestKey", constant("1"))
                    .log("Invalidating entry with key ${header.KeyValueTestKey}")
                    .toF("keyvaluetest-cache://%s", "test")
                    .setHeader("KeyValueTestAction", constant("GET"))
                    .setHeader("KeyValueTestKey", constant("1"))
                    .toF("keyvaluetest-cache://%s", "test")
                    .log("The Action ${header.KeyValueTestAction} with key ${header.KeyValueTestKey} has result? ${header.KeyValueTestActionHasResult}");
  }
}
