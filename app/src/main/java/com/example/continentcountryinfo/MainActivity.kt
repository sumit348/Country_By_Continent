package com.example.continentcountryinfo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var spinnerContinents: Spinner
    private lateinit var buttonShowCountries: Button
    private lateinit var listViewCountries: ListView

    private val continents = arrayOf("Africa", "Asia", "Europe", "North America", "South America", "Australia", "Antarctica")
    private val countries = mapOf(
        "Africa" to arrayOf("Nigeria", "Ethiopia", "Egypt", "South Africa", "Kenya"),
        "Asia" to arrayOf("China", "India", "Japan", "South Korea", "Indonesia"),
        "Europe" to arrayOf("Germany", "France", "United Kingdom", "Italy", "Spain"),
        "North America" to arrayOf("United States", "Canada", "Mexico", "Cuba", "Haiti"),
        "South America" to arrayOf("Brazil", "Argentina", "Colombia", "Chile", "Peru"),
        "Australia" to arrayOf("Australia", "New Zealand", "Fiji", "Papua New Guinea", "Vanuatu"),
        "Antarctica" to arrayOf("No countries")
    )

    private val countryInfo = mapOf(
        "Nigeria" to "Nigeria\nArea: 923,768 km²\nCurrency: Naira\nCapital: Abuja\nPopulation: 206 million",
        "Ethiopia" to "Ethiopia\nArea: 1,104,300 km²\nCurrency: Birr\nCapital: Addis Ababa\nPopulation: 114 million",
        "Egypt" to "Egypt\nArea: 1,010,408 km²\nCurrency: Pound\nCapital: Cairo\nPopulation: 102 million",
        "South Africa" to "South Africa\nArea: 1,221,037 km²\nCurrency: Rand\nCapital: Pretoria\nPopulation: 60 million",
        "Kenya" to "Kenya\nArea: 580,367 km²\nCurrency: Shilling\nCapital: Nairobi\nPopulation: 54 million",
        "China" to "China\nArea: 9,596,961 km²\nCurrency: Yuan\nCapital: Beijing\nPopulation: 1.4 billion",
        "India" to "India\nArea: 3,287,263 km²\nCurrency: Rupee\nCapital: New Delhi\nPopulation: 1.3 billion",
        "Japan" to "Japan\nArea: 377,975 km²\nCurrency: Yen\nCapital: Tokyo\nPopulation: 126 million",
        "South Korea" to "South Korea\nArea: 100,210 km²\nCurrency: Won\nCapital: Seoul\nPopulation: 52 million",
        "Indonesia" to "Indonesia\nArea: 1,904,569 km²\nCurrency: Rupiah\nCapital: Jakarta\nPopulation: 273 million",
        "Germany" to "Germany\nArea: 357,022 km²\nCurrency: Euro\nCapital: Berlin\nPopulation: 83 million",
        "France" to "France\nArea: 551,695 km²\nCurrency: Euro\nCapital: Paris\nPopulation: 67 million",
        "United Kingdom" to "United Kingdom\nArea: 243,610 km²\nCurrency: Pound\nCapital: London\nPopulation: 66 million",
        "Italy" to "Italy\nArea: 301,340 km²\nCurrency: Euro\nCapital: Rome\nPopulation: 60 million",
        "Spain" to "Spain\nArea: 505,992 km²\nCurrency: Euro\nCapital: Madrid\nPopulation: 47 million",
        "United States" to "United States\nArea: 9,833,520 km²\nCurrency: Dollar\nCapital: Washington D.C.\nPopulation: 331 million",
        "Canada" to "Canada\nArea: 9,984,670 km²\nCurrency: Dollar\nCapital: Ottawa\nPopulation: 38 million",
        "Mexico" to "Mexico\nArea: 1,964,375 km²\nCurrency: Peso\nCapital: Mexico City\nPopulation: 128 million",
        "Cuba" to "Cuba\nArea: 109,884 km²\nCurrency: Peso\nCapital: Havana\nPopulation: 11 million",
        "Haiti" to "Haiti\nArea: 27,750 km²\nCurrency: Gourde\nCapital: Port-au-Prince\nPopulation: 11 million",
        "Brazil" to "Brazil\nArea: 8,515,767 km²\nCurrency: Real\nCapital: Brasília\nPopulation: 213 million",
        "Argentina" to "Argentina\nArea: 2,780,400 km²\nCurrency: Peso\nCapital: Buenos Aires\nPopulation: 45 million",
        "Colombia" to "Colombia\nArea: 1,141,748 km²\nCurrency: Peso\nCapital: Bogotá\nPopulation: 50 million",
        "Chile" to "Chile\nArea: 756,102 km²\nCurrency: Peso\nCapital: Santiago\nPopulation: 19 million",
        "Peru" to "Peru\nArea: 1,285,216 km²\nCurrency: Sol\nCapital: Lima\nPopulation: 33 million",
        "Australia" to "Australia\nArea: 7,692,024 km²\nCurrency: Dollar\nCapital: Canberra\nPopulation: 25 million",
        "New Zealand" to "New Zealand\nArea: 268,021 km²\nCurrency: Dollar\nCapital: Wellington\nPopulation: 5 million",
        "Fiji" to "Fiji\nArea: 18,274 km²\nCurrency: Dollar\nCapital: Suva\nPopulation: 896,000",
        "Papua New Guinea" to "Papua New Guinea\nArea: 462,840 km²\nCurrency: Kina\nCapital: Port Moresby\nPopulation: 9 million",
        "Vanuatu" to "Vanuatu\nArea: 12,189 km²\nCurrency: Vatu\nCapital: Port Vila\nPopulation: 308,000"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinnerContinents = findViewById(R.id.spinner_continents)
        buttonShowCountries = findViewById(R.id.button_show_countries)
        listViewCountries = findViewById(R.id.list_countries)

        val continentsAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, continents)
        continentsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerContinents.adapter = continentsAdapter

        buttonShowCountries.setOnClickListener {
            val selectedContinent = spinnerContinents.selectedItem as String
            val selectedCountries = countries[selectedContinent] ?: emptyArray()
            val countriesAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, selectedCountries)
            listViewCountries.adapter = countriesAdapter
            listViewCountries.visibility = View.VISIBLE
        }

        listViewCountries.setOnItemClickListener { _, _, position, _ ->
            val selectedCountry = listViewCountries.getItemAtPosition(position) as String
            val countryInfo = countryInfo[selectedCountry] ?: "Information not available"
            val intent = Intent(this, CountryDetailActivity::class.java)
            intent.putExtra("COUNTRY_INFO", countryInfo)
            startActivity(intent)
        }
    }
}
