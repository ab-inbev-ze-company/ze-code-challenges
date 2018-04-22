package br.com.rads.drunkenmaster.common

import org.junit.Test
import org.junit.Assert.assertEquals

class FloatExtensionsTest {

    @Test
    fun convertToMoneyWithValidValue() {
        assertEquals("$ 12,22", 12.22f.toMoney())
    }

    @Test
    fun convertToMoneyWithZeroValue() {
        assertEquals("$ - ", 0.0f.toMoney())
    }

    @Test
    fun convertToMoneyWithLessThanZeroValue() {
        assertEquals("$ - ", (-1.0f).toMoney())
    }
}