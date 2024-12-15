package com.example.easylaptopapp.myretrofit

import retrofit2.Response
import retrofit2.http.GET

interface ProductService {

    @GET("/productts")
    suspend fun getProducts(): Response<albums>


}