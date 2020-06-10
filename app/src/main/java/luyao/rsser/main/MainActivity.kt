package luyao.rsser.main

import android.util.Log
import luyao.mvvm.core.base.BaseActivity
import luyao.rsser.R
import luyao.rsser.model.OkHttpClient
import luyao.rsser.util.RssUtil
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Request
import okhttp3.Response
import java.io.IOException


class MainActivity : BaseActivity() {

    override fun getLayoutResId(): Int = R.layout.activity_main


    override fun initView() {

    }

    override fun initData() {
        val okHttp = OkHttpClient()
        val call =
            okHttp.client.newCall(Request.Builder().url("https://www.zhihu.com/rss").build())
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("xxx", e.message ?: "")
            }

            override fun onResponse(call: Call, response: Response) {
                val result = response.body?.string()
                val rssArticle = RssUtil.readFeed(result ?: "")
                Log.e("xxx", rssArticle.toString())

            }
        })
    }
}
