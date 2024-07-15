package com.example.continentcountryinfo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CountryDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_detail)

        val countryNameTextView: TextView = findViewById(R.id.text_country_name)
        val countryAreaTextView: TextView = findViewById(R.id.text_country_area)
        val countryCurrencyTextView: TextView = findViewById(R.id.text_country_currency)
        val countryCapitalTextView: TextView = findViewById(R.id.text_country_capital)
        val countryPopulationTextView: TextView = findViewById(R.id.text_country_population)

        val countryInfo = intent.getStringExtra("COUNTRY_INFO")?.split("\n") ?: listOf("Information not available")

        countryNameTextView.text = countryInfo.getOrNull(0) ?: "Name: Unknown"
        countryAreaTextView.text = countryInfo.getOrNull(1) ?: "Area: Unknown"
        countryCurrencyTextView.text = countryInfo.getOrNull(2) ?: "Currency: Unknown"
        countryCapitalTextView.text = countryInfo.getOrNull(3) ?: "Capital: Unknown"
        countryPopulationTextView.text = countryInfo.getOrNull(4) ?: "Population: Unknown"
    }
}
