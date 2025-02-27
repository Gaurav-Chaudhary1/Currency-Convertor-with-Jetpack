package com.example.currencyconvertor.retrofit

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyconvertor.retrofit.RetrofitInstance
import kotlinx.coroutines.launch

class CurrencyConverterViewModel : ViewModel() {
    var exchangeRate by mutableStateOf(1.0)
    var convertedAmount by mutableStateOf("")
    private val apiKey = "1e93e39a9c57601a74e3d0e7" // Replace with your actual API key

    fun convertCurrency(from: String, to: String, amount: Double) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getExchangeRates(apiKey, from)
                val rate = response.conversion_rates[to] ?: 1.0
                exchangeRate = rate
                convertedAmount = (amount * rate).toString()
            } catch (e: Exception) {
                convertedAmount = "Something went wrong!, please try again later."
                Log.e("CurrencyConverterViewModel", "Error fetching data ${e.message}")
            }
        }
    }
}
