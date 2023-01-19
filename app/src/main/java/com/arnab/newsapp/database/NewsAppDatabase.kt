package com.arnab.newsapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.arnab.newsapp.database.dao.NewsAppDBDao
import com.arnab.newsapp.database.model.ArticlesDBModel
import com.arnab.newsapp.database.model.FavortiesDBModel

@Database(entities = [ArticlesDBModel::class, FavortiesDBModel::class], version = 1, exportSchema = false)
abstract class NewsAppDatabase : RoomDatabase() {

    abstract fun newsAppDBDao(): NewsAppDBDao

    companion object {
        @Volatile
        private var INSTANCE: NewsAppDatabase? = null
        fun getDatabase(context: Context): NewsAppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NewsAppDatabase::class.java,
                    "news_app_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}