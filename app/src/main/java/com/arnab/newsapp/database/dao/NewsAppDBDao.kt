package com.arnab.newsapp.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.arnab.newsapp.model.Article

@Dao
interface NewsAppDBDao {
    //actions for articles table
    @Insert
    suspend fun insertArticle(article: Article)
    @Query("SELECT * FROM article")
    suspend fun getArticles(): List<Article>
    @Query("DELETE FROM article")
    suspend fun deleteAllArticles()

    //actions for favorite table
    @Insert
    suspend fun insertToFavorite(article: Article)
    @Query("SELECT * FROM favorite")
    suspend fun getFavorites(): List<Article>
    @Query("DELETE FROM favorite")
    suspend fun deleteFavorites()
    @Delete
    suspend fun deleteFromFavorite(article: Article)
}