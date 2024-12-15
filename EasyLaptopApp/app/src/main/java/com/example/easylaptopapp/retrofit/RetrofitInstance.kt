package com.example.easylaptopapp.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

   val api:LaptopAPI by lazy {
       Retrofit.Builder()
           .baseUrl("https://674ac00871933a4e88535817.mockapi.io/api/")
           .addConverterFactory(GsonConverterFactory.create())
           .build()
           .create(LaptopAPI::class.java)

   }



}