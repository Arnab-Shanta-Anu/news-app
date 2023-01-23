package com.arnab.newsapp.database.dao

import androidx.room.*
import com.arnab.newsapp.database.model.ArticlesDBModel

@Dao
interface NewsAppDBDao {
    //actions for article table
    @Insert
    suspend fun insertArticle(article: ArticlesDBModel)

    @Query("SELECT * FROM article")
    suspend fun getAllArticles(): List<ArticlesDBModel>

    @Query("SELECT * FROM article WHERE category=:category")
    suspend fun getArticlesByCategory(category: String): List<ArticlesDBModel>

    @Query("DELETE FROM article WHERE favorite=0")
    suspend fun deleteAllArticles()

    @Update
    suspend fun addToFavorite(article: ArticlesDBModel)

    @Delete
    suspend fun deleteFromFavorite(article: ArticlesDBModel)
}