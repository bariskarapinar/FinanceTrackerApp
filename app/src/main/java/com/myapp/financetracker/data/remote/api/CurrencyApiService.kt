package com.myapp.financetracker.data.remote.api

import com.myapp.financetracker.data.remote.dto.CurrencyResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface CurrencyApiService {
    @GET("v6/{apiKey}/latest/{baseCurrency}")
    suspend fun getLatestRates(
        @Path("apiKey") apiKey: String,
        @Path("baseCurrency") baseCurrency: String
    ): CurrencyResponse

    companion object {
        const val BASE_URL = "https://v6.exchangerate-api.com/"
    }
}
