package com.example.easylaptopapp.rretrofit

import com.example.easylaptopapp.pojo.CategoryList
import com.example.easylaptopapp.pojo.MealsByCategoryList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MealAPI {

    @GET("filter.php")
    fun getPopularItems(@Query("c") categoryName:String) : Call<MealsByCategoryList>

    @GET("categories.php")
    fun getCategories() : Call<CategoryList>
}