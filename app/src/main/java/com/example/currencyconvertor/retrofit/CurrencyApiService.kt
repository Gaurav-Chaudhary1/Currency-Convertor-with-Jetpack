package com.example.currencyconvertor.retrofit

import retrofit2.http.GET
import retrofit2.http.Path

interface CurrencyApiService {
    @GET("v6/{apiKey}/latest/{base}")
    suspend fun getExchangeRates(
        @Path("apiKey") apiKey: String,  // API Key
        @Path("base") base: String       // Base currency (e.g., USD)
    ): ExchangeRatesResponse
}
