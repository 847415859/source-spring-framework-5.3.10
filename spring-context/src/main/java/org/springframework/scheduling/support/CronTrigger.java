/*
 * Copyright 2002-2015 the original author or authors.
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

package org.springframework.scheduling.support;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.lang.Nullable;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.util.Assert;

/**
 * {@link Trigger} implementation for cron expressions.
 * Wraps a {@link CronExpression}.
 *
 * @author Juergen Hoeller
 * @author Arjen Poutsma
 * @since 3.0
 * @see CronExpression
 */
public class CronTrigger implements Trigger {

	// Corn 表达式解析
	private final CronExpression expression;
	// 时区
	private final ZoneId zoneId;


	/**
	 * Build a {@code CronTrigger} from the pattern provided in the default time zone.
	 * @param expression a space-separated list of time fields, following cron
	 * expression conventions
	 */
	public CronTrigger(String expression) {
		this(expression, ZoneId.systemDefault());
	}

	/**
	 * Build a {@code CronTrigger} from the pattern provided in the given time zone.
	 * @param expression a space-separated list of time fields, following cron
	 * expression conventions
	 * @param timeZone a time zone in which the trigger times will be generated
	 */
	public CronTrigger(String expression, TimeZone timeZone) {
		this(expression, timeZone.toZoneId());
	}

	/**
	 * Build a {@code CronTrigger} from the pattern provided in the given time zone.
	 * @param expression a space-separated list of time fields, following cron
	 * expression conventions
	 * @param zoneId a time zone in which the trigger times will be generated
	 * @since 5.3
	 * @see CronExpression#parse(String)
	 */
	public CronTrigger(String expression, ZoneId zoneId) {
		Assert.hasLength(expression, "Expression must not be empty");
		Assert.notNull(zoneId, "ZoneId must not be null");

		this.expression = CronExpression.parse(expression);
		this.zoneId = zoneId;
	}


	/**
	 * Return the cron pattern that this trigger has been built with.
	 */
	public String getExpression() {
		return this.expression.toString();
	}


	/**
	 * 根据给定的触发器上下文确定下一次执行时间。
	 * Determine the next execution time according to the given trigger context.
	 * <p>Next execution times are calculated based on the
	 * {@linkplain TriggerContext#lastCompletionTime completion time} of the
	 * previous execution; therefore, overlapping executions won't occur.
	 */
	@Override
	public Date nextExecutionTime(TriggerContext triggerContext) {
		// 获取上一次执行完成时间
		Date date = triggerContext.lastCompletionTime();
		if (date != null) {
			// 获取上一次执行时间
			Date scheduled = triggerContext.lastScheduledExecutionTime();
			if (scheduled != null && date.before(scheduled)) {
				// 之前的任务显然执行得太早
				// 那么，让我们简单地使用上次计算的执行时间，以防止在同一秒内意外重新启动。
				date = scheduled;
			}
		}
		else {
			date = new Date();
		}
		ZonedDateTime dateTime = ZonedDateTime.ofInstant(date.toInstant(), this.zoneId);
		// 获取下一次执行时间
		ZonedDateTime next = this.expression.next(dateTime);
		return next != null ? Date.from(next.toInstant()) : null;
	}


	@Override
	public boolean equals(@Nullable Object other) {
		return (this == other || (other instanceof CronTrigger &&
				this.expression.equals(((CronTrigger) other).expression)));
	}

	@Override
	public int hashCode() {
		return this.expression.hashCode();
	}

	@Override
	public String toString() {
		return this.expression.toString();
	}

}
