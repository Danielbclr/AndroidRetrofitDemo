package com.example.retrofitdemo.interfaces

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/api/scope/singleton")
    fun getSingleton(): Call<String>

    @GET("/api/scope/prototype")
    fun getPrototype(): Call<String>

    @GET("/api/scope/request")
    fun getRequest(): Call<String>

    @GET("/api/scope/session")
    fun getSession(): Call<String>

    @GET("/api/scope/application")
    fun getApplication(): Call<String>
}
