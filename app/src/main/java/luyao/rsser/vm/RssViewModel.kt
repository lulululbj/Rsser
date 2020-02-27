package luyao.rsser.vm

import android.content.Context
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import luyao.mvvm.core.base.BaseViewModel
import luyao.rsser.App
import luyao.rsser.model.AppDatabase
import luyao.rsser.model.bean.RssArticle
import luyao.rsser.model.dao.ArticleDao
import luyao.rsser.model.dao.RssDao
import luyao.rsser.repo.RssRepository

/**
 * Created by luyao
 * on 2020/2/27 9:25
 */
class RssViewModel() : BaseViewModel() {

    private val repo: RssRepository
    private val rssDao: RssDao = AppDatabase.getInstance(App.CONTEXT).rssDao()
    private val articleDao: ArticleDao = AppDatabase.getInstance(App.CONTEXT).articleDao()

    init {
        repo = RssRepository(rssDao, articleDao)
    }

    val rssList = repo.getRssList()

    fun addRss(rssArticle: RssArticle) {
        viewModelScope.launch {
            repo.addRss(rssArticle)
        }
    }
}