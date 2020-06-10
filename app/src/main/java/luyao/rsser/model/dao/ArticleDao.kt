package luyao.rsser.model.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import luyao.rsser.model.bean.Article

/**
 * Created by luyao
 * on 2020/2/26 16:10
 */
@Dao
interface ArticleDao {

//    @Query("SELECT * FROM article WHERE rss_id = :rssId")
//    suspend fun getArticlesByRss(rssId: String): LiveData<List<Article>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addArticles(articles: List<Article>)

    @Delete
    suspend fun deleteArticles(articles: List<Article>)
}