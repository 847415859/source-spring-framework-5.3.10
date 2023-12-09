/*
 * Copyright 2002-2012 the original author or authors.
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

package org.springframework.beans.factory;

import org.springframework.lang.Nullable;

/**
 * 实现此接口，则表明是是一个有层次的BeanFactory, eg:父子容器
 *
 * Sub-interface implemented by bean factories that can be part
 * of a hierarchy.
 *
 * <p>The corresponding {@code setParentBeanFactory} method for bean
 * factories that allow setting the parent in a configurable
 * fashion can be found in the ConfigurableBeanFactory interface.
 *
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @since 07.07.2003
 * @see org.springframework.beans.factory.config.ConfigurableBeanFactory#setParentBeanFactory
 */
public interface HierarchicalBeanFactory extends BeanFactory {

 	/**
	 * 返回父BeanFactory
	 */
	@Nullable
	BeanFactory getParentBeanFactory();

	/**
	 * 当前 BeanFactory 是否包含给定名称的 bean，忽略祖先上下文中定义的 bean
	 * @param name 需要查询 Bean的名称
	 * @return 是否包含
	 * @see BeanFactory#containsBean
	 */
	boolean containsLocalBean(String name);

}
