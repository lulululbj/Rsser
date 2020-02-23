package luyao.rsser.main

import androidx.lifecycle.ViewModelProvider
import luyao.mvvm.core.base.BaseVMActivity
import luyao.rsser.R


class MainActivity : BaseVMActivity<MainViewModel>(false) {

    override fun getLayoutResId(): Int = R.layout.activity_main

    override fun initVM(): MainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

    override fun initView() {

    }

    override fun initData() {
    }

    override fun startObserve() {
    }


}
