package com.arnab.newsapp.database.repository

import com.arnab.newsapp.database.dao.NewsAppDBDao
import com.arnab.newsapp.model.Article

class NewsAppDBRepository(private val newsAppDBDao: NewsAppDBDao) {
    //actions for articles table
    suspend fun insertArticle(article: Article) {
        newsAppDBDao.insertArticle(article)
    }
    suspend fun getArticles(): List<Article> {
        return newsAppDBDao.getArticles()
    }
    suspend fun deleteAllArticles() {
        newsAppDBDao.deleteAllArticles()
    }

    //actions for favorite table
    suspend fun insertToFavorite(article: Article) {
        newsAppDBDao.insertToFavorite(article)
    }
    suspend fun getFavorites(): List<Article> {
        return newsAppDBDao.getFavorites()
    }
    suspend fun deleteFavorites() {
        newsAppDBDao.deleteFavorites()
    }
    suspend fun deleteFromFavorite(article: Article) {
        newsAppDBDao.deleteFromFavorite(article)
    }
}