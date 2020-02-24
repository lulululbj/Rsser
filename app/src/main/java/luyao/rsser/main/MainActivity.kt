package luyao.rsser.main

import android.util.Log
import androidx.lifecycle.ViewModelProvider
import luyao.mvvm.core.base.BaseVMActivity
import luyao.rsser.R
import luyao.rsser.model.OkHttpClient
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Request
import okhttp3.Response
import java.io.IOException


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
                Log.e("xxx",result?:"null")
            }
        })
    }

    override fun startObserve() {
    }


}
