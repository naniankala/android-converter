package com.example.unitconverter

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.unitconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var currentCategory: String = ""
    private val converter = Converter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val categories = resources.getStringArray(R.array.categories_array)
        val categoryAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categories)
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.categorySpinner.adapter = categoryAdapter

        binding.categorySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                currentCategory = parent.getItemAtPosition(position) as String
                updateSpinners(currentCategory)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        binding.convertButton.setOnClickListener { convert() }
    }

    private fun updateSpinners(category: String) {
        val unitsArrayId = resources.getIdentifier("${category.lowercase()}_units", "array", packageName)
        if (unitsArrayId != 0) {
            val units = resources.getStringArray(unitsArrayId)
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, units)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.fromSpinner.adapter = adapter
            binding.toSpinner.adapter = adapter
        } else {
            Toast.makeText(this, "Units not found for category: $category", Toast.LENGTH_SHORT).show()
        }
    }

    private fun convert() {
        val fromUnit = binding.fromSpinner.selectedItem?.toString()
        val toUnit = binding.toSpinner.selectedItem?.toString()
        val inputValueText = binding.inputValue.text?.toString()

        if (!inputValueText.isNullOrEmpty() && fromUnit != null && toUnit != null) {
            val inputValue = inputValueText.toDouble()
            val result = converter.convert(currentCategory, fromUnit, toUnit, inputValue)
            binding.resultValue.text = result.toString()
        } else {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
        }
    }
}
