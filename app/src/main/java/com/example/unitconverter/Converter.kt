package com.example.unitconverter

class Converter {

    private val lengthConversionRates = mapOf(
        "Kilometre" to 1000.0,
        "Metre" to 1.0,
        "Centimetre" to 0.01,
        "Millimetre" to 0.001,
        "Micrometre" to 1e-6,
        "Nanometre" to 1e-9,
        "Mile" to 1609.34,
        "Yard" to 0.9144,
        "Foot" to 0.3048,
        "Inch" to 0.0254,
        "Nautical mile" to 1852.0
    )

    private val areaConversionRates = mapOf(
        "Square kilometre" to 1e6,
        "Square metre" to 1.0,
        "Square mile" to 2.59e6,
        "Square yard" to 0.836127,
        "Square foot" to 0.092903,
        "Square inch" to 0.00064516,
        "Hectare" to 10000.0,
        "Acre" to 4046.86
    )

    private val massConversionRates = mapOf(
        "Tonne" to 1e6,
        "Kilogram" to 1e3,
        "Gram" to 1.0,
        "Milligram" to 1e-3,
        "Microgram" to 1e-6,
        "Imperial ton" to 1.016e6,
        "US ton" to 9.072e5,
        "Stone" to 6.35e3,
        "Pound" to 453.592,
        "Ounce" to 28.3495
    )

    private val dataTransferRateConversionRates = mapOf(
        "Bit per second" to 1.0,
        "Kilobit per second" to 1e3,
        "Kilobyte per second" to 8e3,
        "Kibibit per second" to 1024.0,
        "Megabit per second" to 1e6,
        "Megabyte per second" to 8e6,
        "Mebibit per second" to 1048576.0,
        "Gigabit per second" to 1e9,
        "Gigabyte per second" to 8e9,
        "Gibibit per second" to 1.073741824e9,
        "Terabit per second" to 1e12,
        "Terabyte per second" to 8e12,
        "Tebibit per second" to 1.099511627776e12
    )

    private val digitalStorageConversionRates = mapOf(
        "Bit" to 1.0,
        "Kilobit" to 1e3,
        "Kibibit" to 1024.0,
        "Megabit" to 1e6,
        "Mebibit" to 1048576.0,
        "Gigabit" to 1e9,
        "Gibibit" to 1.073741824e9,
        "Terabit" to 1e12,
        "Tebibit" to 1.099511627776e12,
        "Petabit" to 1e15,
        "Pebibit" to 1.125899906842624e15,
        "Byte" to 8.0,
        "Kilobyte" to 8e3,
        "Kibibyte" to 8192.0,
        "Megabyte" to 8e6,
        "Mebibyte" to 8388608.0,
        "Gigabyte" to 8e9,
        "Gibibyte" to 8.589934592e9,
        "Terabyte" to 8e12,
        "Tebibyte" to 8.796093022208e12,
        "Petabyte" to 8e15,
        "Pebibyte" to 9.007199254740992e15
    )

    private val energyConversionRates = mapOf(
        "Joule" to 1.0,
        "Kilojoule" to 1e3,
        "Gram calorie" to 4.184,
        "Kilocalorie" to 4184.0,
        "Watt hour" to 3600.0,
        "Kilowatt-hour" to 3.6e6,
        "Electronvolt" to 1.60218e-19,
        "British thermal unit" to 1055.06,
        "US therm" to 1.055e8,
        "Foot-pound" to 1.35582
    )

    private val frequencyConversionRates = mapOf(
        "Hertz" to 1.0,
        "Kilohertz" to 1e3,
        "Megahertz" to 1e6,
        "Gigahertz" to 1e9
    )

    private val fuelEconomyConversionRates = mapOf(
        "Mile per US gallon" to 1.0,
        "Mile per gallon" to 1.20095,
        "Kilometer per liter" to 2.35215,
        "Litre per 100 kilometres" to 235.215
    )

    private val planeAngleConversionRates = mapOf(
        "Arcsecond" to 4.84814e-6,
        "Degree" to 0.0174533,
        "Gradian" to 0.01570796,
        "Milliradian" to 0.001,
        "Minute of arc" to 0.000290888,
        "Radian" to 1.0
    )

    private val pressureConversionRates = mapOf(
        "Bar" to 1e5,
        "Pascal" to 1.0,
        "Pound per square inch" to 6894.76,
        "Standard atmosphere" to 101325.0,
        "Torr" to 133.322
    )

    private val speedConversionRates = mapOf(
        "Mile per hour" to 0.44704,
        "Foot per second" to 0.3048,
        "Metre per second" to 1.0,
        "Kilometre per hour" to 0.277778,
        "Knot" to 0.514444
    )

    private val temperatureConversionRates = mapOf(
        "Degree Celsius" to { x: Double -> x },
        "Fahrenheit" to { x: Double -> (x - 32) * 5 / 9 },
        "Kelvin" to { x: Double -> x - 273.15 }
    )

    private val timeConversionRates = mapOf(
        "Nanosecond" to 1e-9,
        "Microsecond" to 1e-6,
        "Millisecond" to 1e-3,
        "Second" to 1.0,
        "Minute" to 60.0,
        "Hour" to 3600.0,
        "Day" to 86400.0,
        "Week" to 604800.0,
        "Month" to 2.628e6,
        "Calendar year" to 3.154e7,
        "Decade" to 3.154e8,
        "Century" to 3.154e9
    )

    private val volumeConversionRates = mapOf(
        "US liquid gallon" to 3.78541,
        "US liquid quart" to 0.946353,
        "US liquid pint" to 0.473176,
        "US legal cup" to 0.24,
        "US fluid ounce" to 0.0295735,
        "US tablespoon" to 0.0147868,
        "US teaspoon" to 0.00492892,
        "Cubic meter" to 1.0,
        "Liter" to 0.001,
        "Milliliter" to 1e-6,
        "Imperial gallon" to 4.54609,
        "Imperial quart" to 1.13652,
        "Imperial pint" to 0.568261,
        "Imperial cup" to 0.284131,
        "Imperial fluid ounce" to 0.0284131,
        "Imperial tablespoon" to 0.0177582,
        "Imperial teaspoon" to 0.00591939,
        "Cubic foot" to 0.0283168,
        "Cubic inch" to 1.63871e-5
    )

    fun convert(category: String, fromUnit: String, toUnit: String, value: Double): Double {
        val conversionRate = when (category) {
            "Length" -> lengthConversionRates[toUnit]!! / lengthConversionRates[fromUnit]!!
            "Area" -> areaConversionRates[toUnit]!! / areaConversionRates[fromUnit]!!
            "Mass" -> massConversionRates[toUnit]!! / massConversionRates[fromUnit]!!
            "Data Transfer Rate" -> dataTransferRateConversionRates[toUnit]!! / dataTransferRateConversionRates[fromUnit]!!
            "Digital Storage" -> digitalStorageConversionRates[toUnit]!! / digitalStorageConversionRates[fromUnit]!!
            "Energy" -> energyConversionRates[toUnit]!! / energyConversionRates[fromUnit]!!
            "Frequency" -> frequencyConversionRates[toUnit]!! / frequencyConversionRates[fromUnit]!!
            "Fuel Economy" -> fuelEconomyConversionRates[toUnit]!! / fuelEconomyConversionRates[fromUnit]!!
            "Plane Angle" -> planeAngleConversionRates[toUnit]!! / planeAngleConversionRates[fromUnit]!!
            "Pressure" -> pressureConversionRates[toUnit]!! / pressureConversionRates[fromUnit]!!
            "Speed" -> speedConversionRates[toUnit]!! / speedConversionRates[fromUnit]!!
            "Time" -> timeConversionRates[toUnit]!! / timeConversionRates[fromUnit]!!
            "Volume" -> volumeConversionRates[toUnit]!! / volumeConversionRates[fromUnit]!!
            "Temperature" -> {
                val toCelsius = temperatureConversionRates[fromUnit]!!
                val fromCelsius = temperatureConversionRates[toUnit]!!
                return fromCelsius(toCelsius(value))
            }
            else -> throw IllegalArgumentException("Unknown category: $category")
        }
        return value * conversionRate
    }
}
