package luyao.rsser.model.bean

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "rss")
data class Rss(
    @PrimaryKey
    val id: String,
    val title: String,
    val link: String,
    val description: String,
    val language: String

)