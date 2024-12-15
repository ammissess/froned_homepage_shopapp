package com.example.easylaptopapp.myretrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstancee {

    companion object{
        val mainURL = "https://674ac00871933a4e88535817.mockapi.io/api/"
        fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(mainURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}