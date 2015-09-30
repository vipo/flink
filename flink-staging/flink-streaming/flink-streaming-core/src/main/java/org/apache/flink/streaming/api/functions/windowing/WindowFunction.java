/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.flink.streaming.api.functions.windowing;

import org.apache.flink.api.common.functions.Function;
import org.apache.flink.streaming.api.windowing.windows.Window;
import org.apache.flink.util.Collector;

import java.io.Serializable;

/**
 * Base interface for functions that are evaluated over non-keyed windows.
 *
 * @param <IN> The type of the input value.
 * @param <OUT> The type of the output value.
 */
public interface WindowFunction<IN, OUT,  W extends Window> extends Function, Serializable {

	/**
	 * 
	 * @param values
	 * @param out
	 * 
	 * @throws Exception The function may throw exceptions to fail the program and trigger recovery. 
	 */
	void evaluate(W window, Iterable<IN> values, Collector<OUT> out) throws Exception;
}