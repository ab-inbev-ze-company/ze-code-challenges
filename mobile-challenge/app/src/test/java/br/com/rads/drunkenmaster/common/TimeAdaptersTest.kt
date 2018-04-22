package br.com.rads.drunkenmaster.common

import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*

class TimeAdaptersTest {

    private val DATE = Date(647049600000)
    private val DATE_ENCODED = "1990-07-03T21:00:00.000-0300"
    private val TIME_DATE = Date(86400000)
    private val TIME_ENCODED = "21:00:00"

    @Test
    fun dateTimeEncoding() {
        val encodedDate = TimeAdapters.dateTimeAdapter().encode(DATE)
        assertEquals(DATE_ENCODED, encodedDate)
    }

    @Test
    fun dateTimeDecoding() {
        val encodedDate = TimeAdapters.dateTimeAdapter().decode(DATE_ENCODED)
        assertEquals(DATE.time, encodedDate.time)
    }

    @Test(expected = RuntimeException::class)
    fun dateTimeDecodeExceptionBeingThrown() {
        TimeAdapters.dateTimeAdapter().decode("broken")
    }

    @Test
    fun timeEncoding() {
        val encodedTime = TimeAdapters.timeAdapter().encode(TIME_DATE)
        assertEquals(TIME_ENCODED, encodedTime)
    }

    @Test
    fun timeDecoding() {
        val encodedTime = TimeAdapters.timeAdapter().decode(TIME_ENCODED)
        assertEquals(TIME_DATE.time, encodedTime.time)
    }

    @Test(expected = RuntimeException::class)
    fun timeDecodeExceptionBeingThrown() {
        TimeAdapters.timeAdapter().decode("broken")
    }
}