package me.syari.ss.core.time.event

import java.time.DayOfWeek

/**
 * 日が変わった時(00:00)に発生するイベントです
 */
class NextDayEvent(dayOfWeek: DayOfWeek) : NextHourEvent(dayOfWeek, 0)