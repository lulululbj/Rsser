package luyao.mvvm.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * Created by luyao
 * on 2019/5/31 16:06
 */
open class BaseViewModel : ViewModel() {


    fun launchOnUI(block: suspend CoroutineScope.() -> Unit) {

        viewModelScope.launch { block() }

    }

}