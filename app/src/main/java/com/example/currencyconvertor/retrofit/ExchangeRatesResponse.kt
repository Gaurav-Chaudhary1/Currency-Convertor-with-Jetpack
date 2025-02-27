package com.example.currencyconvertor.retrofit

data class ExchangeRatesResponse(
    val result: String,
    val base_code: String,
    val conversion_rates: Map<String, Double>
)
