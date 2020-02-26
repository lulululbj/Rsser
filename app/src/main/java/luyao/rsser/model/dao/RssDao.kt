package luyao.rsser.model.dao

import androidx.lifecycle.LiveData
import androidx.room.Query
import androidx.room.Transaction
import luyao.rsser.model.bean.RssArticle

/**
 * Created by luyao
 * on 2020/2/26 16:16
 */
interface RssDao {

//    @Transaction
//    @Query("SELECT * FROM plants WHERE id IN (SELECT DISTINCT(plant_id) FROM garden_plantings)")
//    fun getPlantedGardens(): LiveData<List<PlantAndGardenPlantings>>

    @Transaction
    @Query("SELECT * FROM article WHERE rss_id IN (SELECT id FROM rss)")
    suspend fun getRssArticle() : LiveData<List<RssArticle>>

}