/*
 * Copyright 2002-2016 the original author or authors.
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

package org.springframework.core.convert.converter;

/**
 * For registering converters with a type conversion system.
 *
 * @author Keith Donald
 * @author Juergen Hoeller
 * @since 3.0
 */
public interface ConverterRegistry {

	/**
	 * 向此注册表添加一个普通转换器。可转换源/目标类型对源自转换器的参数化类型。
	 *
	 * Add a plain converter to this registry.
	 * The convertible source/target type pair is derived from the Converter's parameterized types.
	 * @throws IllegalArgumentException if the parameterized types could not be resolved
	 */
	void addConverter(Converter<?, ?> converter);

	/**
	 * 向此注册表添加一个普通转换器。可转换的源/目标类型对是显式指定的。
	 * 允许将 Converter 重用于多个不同的对，而无需为每对创建 Converter 类
	 *
	 * Add a plain converter to this registry.
	 * The convertible source/target type pair is specified explicitly.
	 * <p>Allows for a Converter to be reused for multiple distinct pairs without
	 * having to create a Converter class for each pair.
	 * @since 3.1
	 */
	<S, T> void addConverter(Class<S> sourceType, Class<T> targetType, Converter<? super S, ? extends T> converter);

	/**
	 * 将通用转换器添加到此注册表
	 *
	 * Add a generic converter to this registry.
	 */
	void addConverter(GenericConverter converter);

	/**
	 * 将远程转换器工厂添加到此注册表中。可转换的源/目标类型对派生自 ConverterFactory 的参数化类型。
	 *
	 * Add a ranged converter factory to this registry.
	 * The convertible source/target type pair is derived from the ConverterFactory's parameterized types.
	 * @throws IllegalArgumentException if the parameterized types could not be resolved
	 */
	void addConverterFactory(ConverterFactory<?, ?> factory);

	/**
	 * 删除从sourceType到targetType所有转换器
	 *
	 * Remove any converters from {@code sourceType} to {@code targetType}.
	 * @param sourceType the source type
	 * @param targetType the target type
	 */
	void removeConvertible(Class<?> sourceType, Class<?> targetType);

}
