/*
 * Copyright 2002-2017 the original author or authors.
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

package org.springframework.beans.factory.config;

import org.springframework.beans.BeansException;
import org.springframework.lang.Nullable;

/**
 * Strategy interface for resolving a value through evaluating it
 * as an expression, if applicable.
 *
 * <p>A raw {@link org.springframework.beans.factory.BeanFactory} does not
 * contain a default implementation of this strategy. However,
 * {@link org.springframework.context.ApplicationContext} implementations
 * will provide expression support out of the box.
 *
 * @author Juergen Hoeller
 * @since 3.0
 */
public interface BeanExpressionResolver {

	/**
	 * 如果适用，将给定值作为表达式进行评估；否则按原样返回值。
	 * @param value 原始值
	 * @param evalContext 评估上下文
	 * @return the resolved value (potentially the given value as-is)
	 * @throws BeansException if evaluation failed
	 */
	@Nullable
	Object evaluate(@Nullable String value, BeanExpressionContext evalContext) throws BeansException;

}
