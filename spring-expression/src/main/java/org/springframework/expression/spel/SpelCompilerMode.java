/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.expression.spel;

/**
 * Captures the possible configuration settings for a compiler that can be
 * used when evaluating expressions.
 * 捕获编译器的可能配置设置，这些设置可在计算表达式时使用。
 * @author Andy Clement
 * @since 4.1
 */
public enum SpelCompilerMode {

	/**
	 * The compiler is switched off; this is the default.
	 * 编译器关闭；这是默认设置。
	 */
	OFF,

	/**
	 * In immediate mode, expressions are compiled as soon as possible (usually after 1 interpreted run).
	 * If a compiled expression fails it will throw an exception to the caller.
	 * 在立即模式下，表达式会尽快编译（通常在1次解释运行之后）。如果编译的表达式失败，它将向调用方抛出异常。
	 */
	IMMEDIATE,

	/**
	 * In mixed mode, expression evaluation silently switches between interpreted and compiled over time.
	 * After a number of runs the expression gets compiled. If it later fails (possibly due to inferred
	 * type information changing) then that will be caught internally and the system switches back to
	 * interpreted mode. It may subsequently compile it again later.
	 * 在混合模式中，表达式求值会随着时间的推移在解释和编译之间无声地切换。经过多次运行后，将编译表达式。
	 * 如果它后来失败（可能是由于推断的类型信息发生变化），那么它将在内部被捕获，
	 * 系统将切换回解释模式。它随后可能会再次编译它。
	 */
	MIXED

}
