package luyao.rsser.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import luyao.rsser.model.bean.Article
import luyao.rsser.model.bean.Rss
import luyao.rsser.model.dao.ArticleDao
import luyao.rsser.model.dao.RssDao
import luyao.rsser.util.DATABASE_NAME

/**
 * Created by luyao
 * on 2020/2/27 9:10
 */
@Database(entities = [Rss::class, Article::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun rssDao(): RssDao
    abstract fun articleDao(): ArticleDao

    companion object {

        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME).build()
        }
    }
}