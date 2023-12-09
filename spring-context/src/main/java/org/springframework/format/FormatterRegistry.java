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

package org.springframework.format;

import java.lang.annotation.Annotation;

import org.springframework.core.convert.converter.ConverterRegistry;

/**
 * A registry of field formatting logic.
 *
 * @author Keith Donald
 * @author Juergen Hoeller
 * @since 3.0
 */
public interface FormatterRegistry extends ConverterRegistry {

	/**
	 * 添加打印机来打印特定类型的字段。字段类型由参数化的 Printer 实例隐含
	 *
	 * Adds a Printer to print fields of a specific type.
	 * The field type is implied by the parameterized Printer instance.
	 * @param printer the printer to add
	 * @since 5.2
	 * @see #addFormatter(Formatter)
	 */
	void addPrinter(Printer<?> printer);

	/**
	 * 添加解析器来解析特定类型的字段。字段类型由参数化的 Parser 实例隐含。
	 *
	 * Adds a Parser to parse fields of a specific type.
	 * The field type is implied by the parameterized Parser instance.
	 * @param parser the parser to add
	 * @since 5.2
	 * @see #addFormatter(Formatter)
	 */
	void addParser(Parser<?> parser);

	/**
	 * 添加格式化程序以格式化特定类型的字段。字段类型由参数化 Formatter 实例隐含
	 *
	 * Adds a Formatter to format fields of a specific type.
	 * The field type is implied by the parameterized Formatter instance.
	 * @param formatter the formatter to add
	 * @since 3.1
	 * @see #addFormatterForFieldType(Class, Formatter)
	 */
	void addFormatter(Formatter<?> formatter);

	/**
	 * 添加格式化程序以格式化给定类型的字段。
	 * 在打印时，如果声明了格式化程序的类型 T 并且fieldType不可分配给 T，则在委托formatter打印字段值之前将尝试强制转换为 T。
	 * 在解析时，如果formatter程序返回的已解析对象不可分配给运行时字段类型，则在返回已解析字段值之前将尝试强制该字段类型。
	 *
	 * Adds a Formatter to format fields of the given type.
	 * <p>On print, if the Formatter's type T is declared and {@code fieldType} is not assignable to T,
	 * a coercion to T will be attempted before delegating to {@code formatter} to print a field value.
	 * On parse, if the parsed object returned by {@code formatter} is not assignable to the runtime field type,
	 * a coercion to the field type will be attempted before returning the parsed field value.
	 * @param fieldType the field type to format
	 * @param formatter the formatter to add
	 */
	void addFormatterForFieldType(Class<?> fieldType, Formatter<?> formatter);

	/**
	 * 添加打印机/解析器对以格式化特定类型的字段。格式化程序将委托指定的printer进行打印，并委托指定的parser进行解析。
	 * 在打印时，如果声明了打印机的类型 T 并且fieldType不可分配给 T，则在委托printer打印字段值之前将尝试强制转换为 T。
	 * 在解析时，如果解析器返回的对象不可分配给运行时字段类型，则在返回解析的字段值之前将尝试强制该字段类型。
	 *
	 * Adds a Printer/Parser pair to format fields of a specific type.
	 * The formatter will delegate to the specified {@code printer} for printing
	 * and the specified {@code parser} for parsing.
	 * <p>On print, if the Printer's type T is declared and {@code fieldType} is not assignable to T,
	 * a coercion to T will be attempted before delegating to {@code printer} to print a field value.
	 * On parse, if the object returned by the Parser is not assignable to the runtime field type,
	 * a coercion to the field type will be attempted before returning the parsed field value.
	 * @param fieldType the field type to format
	 * @param printer the printing part of the formatter
	 * @param parser the parsing part of the formatter
	 */
	void addFormatterForFieldType(Class<?> fieldType, Printer<?> printer, Parser<?> parser);

	/**
	 * 添加格式化程序以格式化带有特定格式注释的字段。
	 *
	 * Adds a Formatter to format fields annotated with a specific format annotation.
	 * @param annotationFormatterFactory the annotation formatter factory to add
	 */
	void addFormatterForFieldAnnotation(AnnotationFormatterFactory<? extends Annotation> annotationFormatterFactory);

}
