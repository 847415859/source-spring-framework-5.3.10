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

package org.springframework.core.type;

import org.springframework.lang.Nullable;

/**
 * Interface that defines abstract metadata of a specific class,
 * in a form that does not require that class to be loaded yet.
 *
 * @author Juergen Hoeller
 * @since 2.5
 * @see StandardClassMetadata
 * @see org.springframework.core.type.classreading.MetadataReader#getClassMetadata()
 * @see AnnotationMetadata
 */
public interface ClassMetadata {

	/**
	 * 返回类目（注意返回的是最原始的 classname）
	 */
	String getClassName();

	/**
	 * 是否是接口
	 */
	boolean isInterface();

	/**
	 * 是否是注解
	 * @since 4.1
	 */
	boolean isAnnotation();

	/**
	 * 是否是抽象的
	 */
	boolean isAbstract();

	/**
	 * 是否允许创建，是接口且不是抽象类  这里就返回true了
	 */
	default boolean isConcrete() {
		return !(isInterface() || isAbstract());
	}

	/**
	 * Return whether the underlying class is marked as 'final'.
	 */
	boolean isFinal();

	/**
	 * Determine whether the underlying class is independent, i.e. whether
	 * it is a top-level class or a nested class (static inner class) that
	 * can be constructed independently from an enclosing class.
	 *
	 * 是否是独立的(能够创建对象的)  比如是Class、或者内部类、静态内部类，（加载内部类的前提是需要先加载外部类）
	 * 到底是顶级类还是嵌套类(静态内部类)，可以独立于外部类构造
	 */
	boolean isIndependent();

	/**
	 * 是否有内部类之类的东东
	 */
	default boolean hasEnclosingClass() {
		return (getEnclosingClassName() != null);
	}

	/**
	 * 返回底层类的内部类的名称,
	 */
	@Nullable
	String getEnclosingClassName();

	/**
	 * 是否有父类
	 */
	default boolean hasSuperClass() {
		return (getSuperClassName() != null);
	}

	/**
	 * 获取父类
	 */
	@Nullable
	String getSuperClassName();

	/**
	 * 会把实现的所有接口名称都返回  具体依赖于Class#getSuperclass
	 */
	String[] getInterfaceNames();

	/**
	 * 基于：Class#getDeclaredClasses  返回类中定义的公共、私有、保护的内部类
	 * @since 3.1
	 */
	String[] getMemberClassNames();

}
