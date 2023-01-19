package com.arnab.newsapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arnab.newsapp.MainApplication
import com.arnab.newsapp.database.NewsAppDatabase
import com.arnab.newsapp.database.repository.NewsAppDBRepository
import com.arnab.newsapp.model.Article
import com.arnab.newsapp.model.NewsData
import com.arnab.newsapp.network.NewsApi
import kotlinx.coroutines.launch

class NewsViewModel() : ViewModel() {
    private val _newsData = MutableLiveData<NewsData>()
    val newsData = _newsData

    val repository: NewsAppDBRepository

    init {
        val dao = NewsAppDatabase.getDatabase(MainApplication.appContext).newsAppDBDao()
        repository = NewsAppDBRepository(dao)

        checkIfAvailableInDB()
        getData()
    }

    private fun checkIfAvailableInDB(): Boolean {
        var available = false
        viewModelScope.launch {
           val data = repository.getArticles()
            if(data != null){
                available = true
                //_newsData.value = data
            }
        }

        return available
    }

    private fun getData() {
        viewModelScope.launch {
            try {
                val data: NewsData = NewsApi.retrofitService.getData()
                _newsData.value = data
            } catch (e: Exception) {
                Log.e("TEST", "getNews: $e")
            }
        }
    }
}