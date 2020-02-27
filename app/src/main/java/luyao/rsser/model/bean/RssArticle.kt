package luyao.rsser.model.bean

import androidx.room.Embedded
import androidx.room.Relation

/**
 * Created by luyao
 * on 2020/2/26 15:58
 */
data class RssArticle(
    @Embedded
    val rss:Rss,

    @Relation(parentColumn = "id",entityColumn = "rss_id")
    val articleList : List<Article> = emptyList()
)