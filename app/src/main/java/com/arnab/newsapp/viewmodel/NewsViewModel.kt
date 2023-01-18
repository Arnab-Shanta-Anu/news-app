package com.arnab.newsapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arnab.newsapp.model.Article
import com.arnab.newsapp.model.News
import com.arnab.newsapp.network.NewsApi
import kotlinx.coroutines.launch

class NewsViewModel(): ViewModel() {
    private val _status = MutableLiveData<List<Article>>()

    val status: LiveData<List<Article>> = _status
    init {
        Log.d("TEST", ": inside init block")
        getNews()
    }

    private fun getNews() {
        viewModelScope.launch {
            try {
                val listResult: News = NewsApi.retrofitService.getData()
                Log.d("TEST", "getNews: ${listResult.articles.size} News retrieved")
                _status.value = listResult.articles
            } catch (e: Exception) {

            }
        }
    }
}