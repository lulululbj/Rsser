package luyao.rsser.vm

import android.util.Log
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import luyao.mvvm.core.base.BaseViewModel
import luyao.mvvm.core.ext.isUrl

class AddRssViewModel : BaseViewModel() {

    val inputUrl = ObservableField("")
    val enabled = MutableLiveData(false)


    val checkInput: (String) -> Unit = {
        inputUrl.get()?.let { url ->

            enabled.value = url.isUrl()
            Log.e("rss",url)
            Log.e("rss",url.length.toString())
            Log.e("rss",url.isUrl().toString())
            Log.e("rss",enabled.value.toString())
        }
    }


}