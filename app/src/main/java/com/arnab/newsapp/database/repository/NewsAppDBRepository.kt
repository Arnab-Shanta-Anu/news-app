package com.arnab.newsapp.database.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.room.Delete
import com.arnab.newsapp.database.dao.NewsAppDBDao
import com.arnab.newsapp.database.model.ArticlesDBModel
import com.arnab.newsapp.model.Article

class NewsAppDBRepository(private val newsAppDBDao: NewsAppDBDao) {
    val articles: LiveData<List<ArticlesDBModel>> = newsAppDBDao.getArticles()

    //actions for articles table
    init {
        Log.d("DB", "articles: ${articles.value}")
    }
    suspend fun insertArticle(article: ArticlesDBModel) {
        newsAppDBDao.insertArticle(article)
    }

    suspend fun deleteAllArticles() {
        newsAppDBDao.deleteAllArticles()
    }

    suspend fun addToFavorite(article: ArticlesDBModel){
        newsAppDBDao.addToFavorite(article)
    }

    suspend fun deleteFromFavorite(article: ArticlesDBModel){
        newsAppDBDao.deleteFromFavorite(article)
    }
}