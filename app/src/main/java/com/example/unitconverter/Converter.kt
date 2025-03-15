package com.example.unitconverter

class Converter {

    private val lengthConversionRates = mapOf(
        "Kilometre" to 1000.0,
        "Metre" to 1.0,
        "Centimetre" to 0.01,
        "Millimetre" to 0.001
    )

    private val massConversionRates = mapOf(
        "Kilogram" to 1.0,
        "Gram" to 0.001
    )

    private val temperatureConversionRates = mapOf(
        "Degree Celsius" to { x: Double -> x },
        "Fahrenheit" to { x: Double -> (x - 32) * 5 / 9 },
        "Kelvin" to { x: Double -> x - 273.15 }
    )

    fun convert(category: String, fromUnit: String, toUnit: String, value: Double): Double {
        return when (category) {
            "Length" -> {
                val result = value * (lengthConversionRates[toUnit]!! / lengthConversionRates[fromUnit]!!)
                println("DEBUG: Length conversion ($value $fromUnit to $toUnit) = $result")
                result
            }
            "Mass" -> {
                val result = value * (massConversionRates[toUnit]!! / massConversionRates[fromUnit]!!)
                println("DEBUG: Mass conversion ($value $fromUnit to $toUnit) = $result")
                result
            }
            "Temperature" -> {
                val toCelsius = temperatureConversionRates[fromUnit]!!
                val fromCelsius = temperatureConversionRates[toUnit]!!
                val result = fromCelsius(toCelsius(value))
                println("DEBUG: Temperature conversion ($value $fromUnit to $toUnit) = $result")
                result
            }
            else -> throw IllegalArgumentException("Unknown category: $category")
        }
    }
}
