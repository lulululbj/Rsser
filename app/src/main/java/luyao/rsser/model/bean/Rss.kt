package luyao.rsser.model.bean

data class Rss(val title:String,
               val link:String,
               val description:String,
               val language:String,
               val articleList:List<Article>)