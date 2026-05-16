package com.myapp.financetracker.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CurrencyResponse(
    @SerializedName("result") val result: String,
    @SerializedName("base_code") val baseCode: String,
    @SerializedName("conversion_rates") val conversionRates: Map<String, Double>
)
