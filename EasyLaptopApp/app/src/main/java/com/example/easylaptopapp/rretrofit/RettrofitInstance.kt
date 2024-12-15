package com.example.easylaptopapp.rretrofit

import com.example.easylaptopapp.retrofit.LaptopAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RettrofitInstance {

    val api: MealAPI by lazy {
        Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MealAPI::class.java)

    }
}