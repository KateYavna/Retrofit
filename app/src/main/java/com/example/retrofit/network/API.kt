package com.example.retrofit.network

import retrofit2.Call
import retrofit2.http.GET

interface API {
    @GET("v1/bpi/currentprice.json")
    fun getCurrentPrice(): Call<ResponseMain>

}
