package com.arnab.newsapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.arnab.newsapp.database.NewsAppDatabase
import com.arnab.newsapp.database.model.ArticlesDBModel
import com.arnab.newsapp.database.repository.NewsAppDBRepository
import com.arnab.newsapp.model.NewsData
import com.arnab.newsapp.network.NewsApi
import kotlinx.coroutines.launch

class NewsViewModel(application: Application) : AndroidViewModel(application) {
    private val _newsData = MutableLiveData<NewsData>()
    val newsData = _newsData

    private val _allNews = MutableLiveData<List<ArticlesDBModel>>()
    val allNews = _allNews
    private val repository: NewsAppDBRepository

    init {
        val dao = NewsAppDatabase.getDatabase(application).newsAppDBDao()
        repository = NewsAppDBRepository(dao)

        getData()
        getDataFromDB()
    }

    private fun getDataFromDB() {
        viewModelScope.launch {
            _allNews.postValue(repository.getArticles())
        }
    }

    private fun getData() {
        /*viewModelScope.launch {
            repository.deleteAllArticles()
        }*/
        getAllNews()
    }

    private fun getAllNews() {
        getHeadlinesNews()
        getBusinessNews()
        getEntertainmentNews()
        getGeneralNews()
        getHealthNews()
        getScienceNews()
        getSportsNews()
        getTechnologyNews()
    }

    private fun getTechnologyNews() {
        viewModelScope.launch {
            try {
                val data: NewsData = NewsApi.retrofitService.getTechnologyNews()
                _newsData.value = data
                _newsData.value!!.articles.forEach {
                    repository.insertArticle(
                        ArticlesDBModel(
                            0,
                            it.author!!,
                            it.content!!,
                            "technology",
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

    private fun getSportsNews() {
        viewModelScope.launch {
            try {
                val data: NewsData = NewsApi.retrofitService.getSportsNews()
                _newsData.value = data
                _newsData.value!!.articles.forEach {
                    repository.insertArticle(
                        ArticlesDBModel(
                            0,
                            it.author!!,
                            it.content!!,
                            "sports",
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

    private fun getScienceNews() {
        viewModelScope.launch {
            try {
                val data: NewsData = NewsApi.retrofitService.getScienceNews()
                _newsData.value = data
                _newsData.value!!.articles.forEach {
                    repository.insertArticle(
                        ArticlesDBModel(
                            0,
                            it.author!!,
                            it.content!!,
                            "science",
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

    private fun getHealthNews() {
        viewModelScope.launch {
            try {
                val data: NewsData = NewsApi.retrofitService.getHealthNews()
                _newsData.value = data
                _newsData.value!!.articles.forEach {
                    repository.insertArticle(
                        ArticlesDBModel(
                            0,
                            it.author!!,
                            it.content!!,
                            "health",
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

    private fun getGeneralNews() {
        viewModelScope.launch {
            try {
                val data: NewsData = NewsApi.retrofitService.getGeneralNews()
                _newsData.value = data
                _newsData.value!!.articles.forEach {
                    repository.insertArticle(
                        ArticlesDBModel(
                            0,
                            it.author!!,
                            it.content!!,
                            "general",
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

    private fun getEntertainmentNews() {
        viewModelScope.launch {
            try {
                val data: NewsData = NewsApi.retrofitService.getEntertainmentNews()
                _newsData.value = data
                _newsData.value!!.articles.forEach {
                    repository.insertArticle(
                        ArticlesDBModel(
                            0,
                            it.author!!,
                            it.content!!,
                            "entertainment",
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

    private fun getBusinessNews() {
        viewModelScope.launch {
            try {
                val data: NewsData = NewsApi.retrofitService.getBusinessNews()
                _newsData.value = data
                _newsData.value!!.articles.forEach {
                    repository.insertArticle(
                        ArticlesDBModel(
                            0,
                            it.author!!,
                            it.content!!,
                            "business",
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

    private fun getHeadlinesNews() {
        viewModelScope.launch {
            try {
                val data: NewsData = NewsApi.retrofitService.getHeadlinesNews()
                _newsData.value = data
                _newsData.value!!.articles.forEach {
                    repository.insertArticle(
                        ArticlesDBModel(
                            0,
                            it.author!!,
                            it.content!!,
                            "headlines",
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