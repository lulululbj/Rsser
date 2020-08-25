package luyao.rsser.vm

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.flow.flow
import luyao.mvvm.core.base.BaseViewModel
import luyao.mvvm.core.ext.isUrl
import luyao.rsser.App
import luyao.rsser.model.AppDatabase
import luyao.rsser.model.bean.RssArticle
import luyao.rsser.model.dao.ArticleDao
import luyao.rsser.model.dao.RssDao
import luyao.rsser.repo.RssRepository

class AddRssViewModel : BaseViewModel() {

    val inputUrl = ObservableField("")
    val enabled = MutableLiveData(false)
    private val repo: RssRepository
    private val rssDao: RssDao = AppDatabase.getInstance(App.CONTEXT).rssDao()
    private val articleDao: ArticleDao = AppDatabase.getInstance(App.CONTEXT).articleDao()

    init {
        repo = RssRepository(rssDao, articleDao)
    }

    val checkInput: (String) -> Unit = {
        inputUrl.get()?.let { url ->

            enabled.value = url.isUrl()
            Log.e("rss", url)
            Log.e("rss", url.length.toString())
            Log.e("rss", url.isUrl().toString())
            Log.e("rss", enabled.value.toString())
        }
    }

    val addRssAction = {
        val url = inputUrl.get() ?: ""
        flow<RssArticle> {

        }
    }


}