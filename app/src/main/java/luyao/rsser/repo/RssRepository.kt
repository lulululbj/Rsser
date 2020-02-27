package luyao.rsser.repo

import androidx.lifecycle.LiveData
import luyao.rsser.model.bean.RssArticle
import luyao.rsser.model.dao.ArticleDao
import luyao.rsser.model.dao.RssDao

/**
 * Created by luyao
 * on 2020/2/27 9:18
 */
class RssRepository  (
    private val rssDao: RssDao,
    private val articleDao: ArticleDao
) {

    suspend fun addRss(rssArticle: RssArticle) {
        rssDao.addRss(rssArticle.rss)
        articleDao.addArticles(rssArticle.articleList)
    }

    suspend fun deleteRss(rssArticle: RssArticle) {
        rssDao.removeRss(rssArticle.rss)
    }

    fun getRssList(): LiveData<List<RssArticle>> = rssDao.getRssArticle()
}