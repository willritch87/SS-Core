package me.syari.ss.core.time.event

import java.time.DayOfWeek

/**
 * 時間が変わった時(XX:00)に発生するイベントです
 */
open class NextHourEvent(dayOfWeek: DayOfWeek, hour: Int) : NextMinuteEvent(dayOfWeek, hour, 0)