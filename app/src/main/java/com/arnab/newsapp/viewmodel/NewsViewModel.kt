package com.arnab.newsapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arnab.newsapp.model.Article
import com.arnab.newsapp.model.NewsData
import com.arnab.newsapp.network.NewsApi
import kotlinx.coroutines.launch

class NewsViewModel(): ViewModel() {
    private val _newsData = MutableLiveData<NewsData>()
    val newsData = _newsData

    init {
        getData()
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