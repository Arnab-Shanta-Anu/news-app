package com.arnab.newsapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.arnab.newsapp.database.NewsAppDatabase
import com.arnab.newsapp.database.model.ArticlesDBModel
import com.arnab.newsapp.database.repository.NewsAppDBRepository
import com.arnab.newsapp.model.NewsData
import com.arnab.newsapp.network.NewsApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel(application: Application) : AndroidViewModel(application) {
    private val _newsData = MutableLiveData<NewsData>()
    val newsData = _newsData

    val allNews = MutableLiveData<List<ArticlesDBModel>>()
    val repository: NewsAppDBRepository

    init {
        val dao = NewsAppDatabase.getDatabase(application).newsAppDBDao()
        repository = NewsAppDBRepository(dao)

        if (!checkIfAvailableInDB()) {
            getData()
        }
    }

    private fun checkIfAvailableInDB(): Boolean {
        var available = false
        viewModelScope.launch {
            val data: LiveData<List<ArticlesDBModel>> = repository.articles
            Log.d("DB", "checkIfAvailableInDB: data: ${data.value}")
            if(data.value != null) {
                Log.d("DB", "checkIfAvailableInDB: Fetching data from db data: ${data.value}")
                available = true
                allNews.value = data.value
            }
        }
        Log.d("DB", "checkIfAvailableInDB: available:$available")
        return available
    }

    private fun getData() {
        viewModelScope.launch {
            try {
                val data: NewsData = NewsApi.retrofitService.getData()
                _newsData.value = data
                _newsData.value!!.articles.forEach {
                    repository.insertArticle(
                        ArticlesDBModel(
                            0,
                            it.author!!,
                            it.content!!,
                            "abc",
                            0,
                            it.description!!,
                            it.publishedAt!!,
                            it.title!!,
                            it.url!!,
                            it.urlToImage!!
                        )
                    )
                }
            } catch (e: Exception) {
                Log.e("TEST", "getNews: $e")
            }
        }
    }
}