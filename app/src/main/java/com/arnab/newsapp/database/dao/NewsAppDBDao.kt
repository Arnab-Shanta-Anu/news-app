package com.arnab.newsapp.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.arnab.newsapp.database.model.ArticlesDBModel

@Dao
interface NewsAppDBDao {
    //actions for article table
    @Insert
    suspend fun insertArticle(article: ArticlesDBModel)

    @Query("SELECT * FROM article")
    fun getArticles(): LiveData<List<ArticlesDBModel>>

    @Query("DELETE FROM article WHERE favorite=0")
    suspend fun deleteAllArticles()

    @Update
    suspend fun addToFavorite(article: ArticlesDBModel)

    @Delete
    suspend fun deleteFromFavorite(article: ArticlesDBModel)
}