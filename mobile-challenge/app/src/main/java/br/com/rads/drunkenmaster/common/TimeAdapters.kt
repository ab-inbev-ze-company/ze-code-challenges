package br.com.rads.drunkenmaster.common

import com.apollographql.apollo.CustomTypeAdapter
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object TimeAdapters {

    fun dateTimeAdapter() = customTypeAdapter("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    fun timeAdapter() = customTypeAdapter("HH:mm:ss")

    private fun customTypeAdapter(format: String): CustomTypeAdapter<Date> {
        return object : CustomTypeAdapter<Date> {
            val ISO8601_DATE_FORMAT = SimpleDateFormat(format, Locale.getDefault())
            override fun decode(value: String): Date {
                try {
                    return ISO8601_DATE_FORMAT.parse(value)
                } catch (e: ParseException) {
                    throw RuntimeException(e)
                }
            }

            override fun encode(value: Date): String {
                return ISO8601_DATE_FORMAT.format(value)
            }
        }
    }

}