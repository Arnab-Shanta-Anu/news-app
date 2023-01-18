package com.arnab.newsapp.network

import com.arnab.newsapp.model.NewsData
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://newsapi.org/v2/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface NewsApiService {
    @GET("everything?q=*&apiKey=cd821a3bef634e8593e60a5f5024ba79")
    suspend fun getData() : NewsData
}
object NewsApi {
    val retrofitService: NewsApiService by lazy { retrofit.create(NewsApiService::class.java) }
}