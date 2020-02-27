package luyao.rsser.model.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import luyao.rsser.model.bean.Rss
import luyao.rsser.model.bean.RssArticle
import retrofit2.http.DELETE

/**
 * Created by luyao
 * on 2020/2/26 16:16
 */
@Dao
interface RssDao {

//    @Transaction
//    @Query("SELECT * FROM plants WHERE id IN (SELECT DISTINCT(plant_id) FROM garden_plantings)")
//    fun getPlantedGardens(): LiveData<List<PlantAndGardenPlantings>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addRss(rss: Rss)

    @Delete
    suspend fun removeRss(rss: Rss)

    @Transaction
    @Query("SELECT * FROM article WHERE rss_id IN (SELECT id FROM rss)")
    fun getRssArticle(): LiveData<List<RssArticle>>

}