/*
 * Copyright 2017 Crown Copyright
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package uk.gov.gchq.koryphe.util;

import static uk.gov.gchq.koryphe.util.DateUtil.DAYS_TO_MILLISECONDS;
import static uk.gov.gchq.koryphe.util.DateUtil.HOURS_TO_MILLISECONDS;
import static uk.gov.gchq.koryphe.util.DateUtil.MINUTES_TO_MILLISECONDS;
import static uk.gov.gchq.koryphe.util.DateUtil.SECONDS_TO_MILLISECONDS;

/**
 * A {@code TimeUnit} is an enum that defines a period of time. There is a
 * method to convert a time to milliseconds using the time unit.
 */
public enum TimeUnit {
    DAY(DAYS_TO_MILLISECONDS),
    HOUR(HOURS_TO_MILLISECONDS),
    MINUTE(MINUTES_TO_MILLISECONDS),
    SECOND(SECONDS_TO_MILLISECONDS),
    MILLISECOND(1L);

    private final long conversionFactor;

    TimeUnit(final long conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    /**
     * Converts a unit of time to milliseconds. If the time unit or time is null then null is returned.
     *
     * @param timeUnit the time unit
     * @param time     the time
     * @return the time in milliseconds
     */
    public static Long asMilliSeconds(final TimeUnit timeUnit, final Long time) {
        return (null != timeUnit ? timeUnit : DAY).asMilliSeconds(time);
    }

    /**
     * Converts a unit of time to milliseconds. If the time is null then null is returned.
     *
     * @param time the time
     * @return the time in milliseconds
     */
    public Long asMilliSeconds(final Long time) {
        return null != time ? time * conversionFactor : null;
    }
}