package com.example.unitconverter.__tests__

import com.example.unitconverter.Converter
import org.junit.Assert.assertEquals
import org.junit.Test

class ConverterTest {

    private val converter = Converter()

    @Test
    fun testLengthConversion() {
        val result = converter.convert("Length", "Metre", "Kilometre", 1000.0)
        println("DEBUG: 1000 Metres to Kilometres = $result (Expected: 1.0)")
        assertEquals(1.0, result, 0.01)
    }

    @Test
    fun testMassConversion() {
        val result = converter.convert("Mass", "Gram", "Kilogram", 1000.0)
        println("DEBUG: 1000 Grams to Kilograms = $result (Expected: 1.0)")
        assertEquals(1.0, result, 0.01)
    }

    @Test
    fun testTemperatureConversion() {
        val result = converter.convert("Temperature", "Fahrenheit", "Degree Celsius", 32.0)
        println("DEBUG: 32 Fahrenheit to Celsius = $result (Expected: 0.0)")
        assertEquals(0.0, result, 0.01)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testInvalidCategory() {
        converter.convert("Unknown", "UnitA", "UnitB", 1.0)
    }
}
