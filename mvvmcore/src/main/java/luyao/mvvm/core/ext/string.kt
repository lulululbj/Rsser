package luyao.mvvm.core.ext

import java.util.regex.Pattern

/**
 * 常用正则
 * Created by luyao
 * on 2020/6/17 10:41
 */

const val URL_PATTERN = "http(s)?://[^\\s]*"

fun String.isUrl() = Pattern.matches(URL_PATTERN,this)

fun main() {
    val url = "https://www.baidu.com"
    println(url.isUrl())
}