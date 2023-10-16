package com.example.shoppingapp
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("products") //endpoint written inside GET('')
    fun getProductData() : Call<MyData>

}