package luyao.rsser.main

import android.util.Log
import androidx.lifecycle.ViewModelProvider
import luyao.mvvm.core.base.BaseVMActivity
import luyao.rsser.R
import luyao.rsser.model.OkHttpClient
import luyao.rsser.model.bean.Article
import luyao.rsser.model.bean.Rss
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Request
import okhttp3.Response
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.IOException
import java.io.StringReader


class MainActivity : BaseVMActivity<MainViewModel>(false) {

    override fun getLayoutResId(): Int = R.layout.activity_main

    override fun initVM(): MainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

    override fun initView() {

    }

    override fun initData() {
        val okHttp = OkHttpClient()
        val call = okHttp.client.newCall(Request.Builder().url("https://luyao.tech/feed.xml").build())
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("xxx", e.message ?:"")
            }

            override fun onResponse(call: Call, response: Response) {
                val result = response.body?.string()
                parseXml(result?:"")
//                Log.e("xxx",result?:"null")
            }
        })
    }

    private fun parseXml(xmlString: String){
        if (xmlString.isEmpty()) return
        val xmlParserFactory = XmlPullParserFactory.newInstance()
        val xmlParser = xmlParserFactory.newPullParser()
        xmlParser.setInput(StringReader(xmlString))

        var hasReadItem = false

        var title:String = ""
        var link:String = ""
        var description:String = ""
        var language:String = ""

        var articleTitle: String = ""
        var articleLink: String = ""
        var articleContent: String = ""
        var articlePubDate: String = ""

        val articleList = arrayListOf<Article>()

        var eventType = xmlParser.eventType
        while (eventType != XmlPullParser.END_DOCUMENT){
            val name = xmlParser.name
            hasReadItem = name == "item"
            when(eventType){
                XmlPullParser.START_TAG ->{
                   if (!hasReadItem){
                       when(name){
                           "title" -> title = xmlParser.text
                           "link" -> link = xmlParser.text
                           "description" -> description = xmlParser.text
                           "language" -> language = xmlParser.text
                       }
                   }else {
                       when(name){
                           "title" -> articleTitle = xmlParser.text
                           "link" -> articleLink = xmlParser.text
                           "content:encoded" -> articleContent = xmlParser.text
                           "pubDate" -> articlePubDate = xmlParser.text
                       }
                   }

                }
                XmlPullParser.END_TAG -> {
                    Log.e("xxx", "$name end")
                    if (name == "item")
                        articleList.add(Article(articleTitle,articleLink,articleContent,articlePubDate))

                }
            }
            eventType = xmlParser.next()
        }

        val rss = Rss(title, link, description, language, articleList)
        Log.e("xxx",rss.toString())
    }

    override fun startObserve() {
    }


}
