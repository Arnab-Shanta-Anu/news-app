package com.arnab.newsapp.database.repository

import com.arnab.newsapp.database.dao.NewsAppDBDao
import com.arnab.newsapp.database.model.ArticlesDBModel

class NewsAppDBRepository(private val newsAppDBDao: NewsAppDBDao) {

    suspend fun getArticles(): List<ArticlesDBModel>{
        return newsAppDBDao.getAllArticles()
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