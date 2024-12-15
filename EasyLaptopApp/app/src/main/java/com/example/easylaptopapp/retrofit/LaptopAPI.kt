package com.example.easylaptopapp.retrofit

import com.example.easylaptopapp.pojo.MealsByCategoryList
import com.example.easylaptopapp.pojo.laptop_listItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface LaptopAPI {

    @GET("/productts")
    fun getRandomLaptop():Call<laptop_listItem>

    @GET("filter.php")
    fun getPopularItems(@Query("c") categoryName:String) : Call<MealsByCategoryList>

}