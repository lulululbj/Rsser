package luyao.rsser.util

import luyao.rsser.model.bean.Article
import luyao.rsser.model.bean.Rss
import luyao.rsser.model.bean.RssArticle
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.StringReader

/**
 * Created by luyao
 * on 2020/2/25 9:45
 */
object RssUtil {

    private val ns: String? = null

    /**
     * 解析 xml 字符串
     */
    fun readFeed(xmlString: String): RssArticle? {
        val xmlParserFactory = XmlPullParserFactory.newInstance()
        val parser = xmlParserFactory.newPullParser()
        parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false)
        parser.setInput(StringReader(xmlString))
        parser.nextTag()
        return readRss(parser)
    }

    private fun readRss(parser: XmlPullParser): RssArticle? {
        parser.require(XmlPullParser.START_TAG, ns, "rss")
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.eventType != XmlPullParser.START_TAG)
                continue
            if (parser.name == "channel") {
                return readChannel(parser)
            } else {
                skip(parser)
            }
        }
        return null
    }

    private fun readChannel(parser: XmlPullParser): RssArticle {

        var title = ""
        var link = ""
        var description = ""
        var language = ""
        val articleList = arrayListOf<Article>()

        parser.require(XmlPullParser.START_TAG, ns, "channel")
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.eventType != XmlPullParser.START_TAG)
                continue
            when (parser.name) {
                "title" -> title = readTitle(parser)
                "link" -> link = readNode(parser, "link")
                "description" -> description = readNode(parser, "description")
                "language" -> language = readNode(parser, "language")
                "item" -> articleList.add(readItem(parser, link))
                else -> skip(parser)
            }
        }

        val rss = Rss(link.hash(Hash.SHA1),link,title,description,language)

        return RssArticle(rss, articleList)
    }

    // 这里的 link 是 rss 订阅地址
    private fun readItem(parser: XmlPullParser, link: String): Article {
        var articleTitle = ""
        var articleLink = ""
        var articleContent = ""
        var articlePubDate = ""

        parser.require(XmlPullParser.START_TAG, ns, "item")
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.eventType != XmlPullParser.START_TAG)
                continue
            when (parser.name) {
                "title" -> articleTitle = readTitle(parser)
                "link" -> articleLink = readNode(parser, "link")
                "content:encoded" -> articleContent = readNode(parser, "content:encoded")
                "pubDate" -> articlePubDate = readNode(parser, "pubDate")
                else -> skip(parser)
            }
        }
        return Article(link.hash(Hash.SHA1), articleTitle, articleLink, articleContent, articlePubDate)
    }

    private fun readTitle(parser: XmlPullParser): String {
        parser.require(XmlPullParser.START_TAG, ns, "title")
        val title = readText(parser)
        parser.require(XmlPullParser.END_TAG, ns, "title")
        return title
    }

    private fun readNode(parser: XmlPullParser, node: String): String {
        parser.require(XmlPullParser.START_TAG, ns, node)
        val value = readText(parser)
        parser.require(XmlPullParser.END_TAG, ns, node)
        return value
    }

    private fun readText(parser: XmlPullParser): String {
        var result = ""
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.text
            parser.nextTag()
        }
        return result
    }

    private fun skip(parser: XmlPullParser) {
        if (parser.eventType != XmlPullParser.START_TAG) {
            throw IllegalStateException()
        }
        var depth = 1
        while (depth != 0) {
            when (parser.next()) {
                XmlPullParser.END_TAG -> depth--
                XmlPullParser.START_TAG -> depth++
            }
        }
    }


}