package luyao.rsser

import android.app.Application
import android.content.Context
import kotlin.properties.Delegates

/**
 * Created by luyao
 * on 2020/2/27 9:35
 */
class App :Application(){

    companion object {
         var CONTEXT : Context by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        CONTEXT = this
    }
}