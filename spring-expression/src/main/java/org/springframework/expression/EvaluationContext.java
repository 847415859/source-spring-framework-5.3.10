/*
 * Copyright 2002-2018 the original author or authors.
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

package org.springframework.expression;

import java.util.List;

import org.springframework.lang.Nullable;

/**
 * Expressions are executed in an evaluation context. It is in this context that
 * references are resolved when encountered during expression evaluation.
 * 表达式是在求值上下文中执行的。正是在这种情况下，在表达式求值过程中遇到引用时才解析引用。
 * <p>There is a default implementation of this EvaluationContext interface:
 * {@link org.springframework.expression.spel.support.StandardEvaluationContext}
 * which can be extended, rather than having to implement everything manually.
 *
 * @author Andy Clement
 * @author Juergen Hoeller
 * @since 3.0
 */
public interface EvaluationContext {

	/**
	 * Return the default root context object against which unqualified
	 * properties/methods/etc should be resolved. This can be overridden
	 * when evaluating an expression.
	 *
	 * 返回默认的根上下文对象，应针对该对象解析不合格的属性/方法等。在计算表达式时可以覆盖此项。
	 */
	TypedValue getRootObject();

	/**
	 * Return a list of accessors that will be asked in turn to read/write a property.
	 * 返回一个访问者列表，这些访问者将依次被要求读取/写入属性。
	 */
	List<PropertyAccessor> getPropertyAccessors();

	/**
	 * Return a list of resolvers that will be asked in turn to locate a constructor.
	 * 返回一个解析器列表，这些解析器将依次被要求定位构造函数
	 */
	List<ConstructorResolver> getConstructorResolvers();

	/**
	 * Return a list of resolvers that will be asked in turn to locate a method.
	 * 返回解析程序的列表，这些解析程序将依次被要求定位方法
	 */
	List<MethodResolver> getMethodResolvers();

	/**
	 * Return a bean resolver that can look up beans by name.
	 * 返回一个bean解析器，该解析器可以按名称查找bean。
	 */
	@Nullable
	BeanResolver getBeanResolver();

	/**
	 * Return a type locator that can be used to find types, either by short or
	 * fully qualified name.
	 * 返回一个类型定位器，该定位器可用于按短名称或完全限定名称查找类型。
	 */
	TypeLocator getTypeLocator();

	/**
	 * Return a type converter that can convert (or coerce) a value from one type to another.
	 * 返回一个类型转换器，该转换器可以将值从一种类型转换（或强制）为另一种类型
	 */
	TypeConverter getTypeConverter();

	/**
	 * Return a type comparator for comparing pairs of objects for equality.
	 * 返回一个类型比较器，用于比较对象对是否相等
	 */
	TypeComparator getTypeComparator();

	/**
	 * Return an operator overloader that may support mathematical operations
	 * between more than the standard set of types.
	 * 返回一个运算符重载器，该重载器可能支持多个标准类型集之间的数学运算
	 */
	OperatorOverloader getOperatorOverloader();

	/**
	 * Set a named variable within this evaluation context to a specified value.
	 * 将此计算上下文中的命名变量设置为指定值。
	 * @param name the name of the variable to set
	 * @param value the value to be placed in the variable
	 */
	void setVariable(String name, @Nullable Object value);

	/**
	 * Look up a named variable within this evaluation context.
	 * @param name variable to lookup
	 * @return the value of the variable, or {@code null} if not found
	 */
	@Nullable
	Object lookupVariable(String name);

}
