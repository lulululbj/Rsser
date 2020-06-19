package luyao.rsser.vm

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import luyao.mvvm.core.base.BaseViewModel
import luyao.mvvm.core.ext.isUrl

class AddRssViewModel : BaseViewModel() {

    val inputUrl = ObservableField("")
    val enabled = ObservableBoolean(false)


    val checkInput: (String) -> Unit = {
        inputUrl.get()?.let {
            enabled.set(it.isUrl())
        }
    }


}