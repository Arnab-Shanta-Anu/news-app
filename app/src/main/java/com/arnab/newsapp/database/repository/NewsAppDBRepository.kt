package com.arnab.newsapp.database.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.room.Delete
import com.arnab.newsapp.database.dao.NewsAppDBDao
import com.arnab.newsapp.database.model.ArticlesDBModel
import com.arnab.newsapp.model.Article
import kotlinx.coroutines.flow.Flow

class NewsAppDBRepository(private val newsAppDBDao: NewsAppDBDao) {

    suspend fun getArticles(): List<ArticlesDBModel>{
        Log.d("DB", "getArticles: getting all articles ${newsAppDBDao.getArticles()}")
        return newsAppDBDao.getArticles()
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