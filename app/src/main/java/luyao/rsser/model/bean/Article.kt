package luyao.rsser.model.bean

import androidx.room.*

@Entity(
    tableName = "article",
    foreignKeys = [ForeignKey(
        entity = Rss::class,
        parentColumns = ["id"],
        childColumns = ["rssId"]
    )],
    indices = [Index("rssId")]
)
data class Article(
    @ColumnInfo(name = "rss_id")
    val rssId: String,
    val title: String,
    @PrimaryKey
    val link: String,
    val content: String,
    val pubDate: String
)