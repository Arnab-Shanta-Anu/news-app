package com.arnab.newsapp.network

import com.arnab.newsapp.model.NewsData
import com.arnab.newsapp.util.Constants
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
    @GET("top-headlines?country=us&apiKey=${Constants.API_KEY}")
    suspend fun getHeadlinesNews() : NewsData

    @GET("top-headlines?country=us&category=business&apiKey=${Constants.API_KEY}")
    suspend fun getBusinessNews() : NewsData

    @GET("top-headlines?country=us&category=entertainment&apiKey=${Constants.API_KEY}")
    suspend fun getEntertainementNews() : NewsData

    @GET("top-headlines?country=us&category=general&apiKey=${Constants.API_KEY}")
    suspend fun getGeneralNews() : NewsData

    @GET("top-headlines?country=us&category=health&apiKey=${Constants.API_KEY}")
    suspend fun getHealthNews() : NewsData

    @GET("top-headlines?country=us&category=science&apiKey=${Constants.API_KEY}")
    suspend fun getScienceNews() : NewsData

    @GET("top-headlines?country=us&category=sports&apiKey=${Constants.API_KEY}")
    suspend fun getSportsNews() : NewsData

    @GET("top-headlines?country=us&category=technology&apiKey=${Constants.API_KEY}")
    suspend fun getTechnologyNews() : NewsData
}
object NewsApi {
    val retrofitService: NewsApiService by lazy { retrofit.create(NewsApiService::class.java) }
}