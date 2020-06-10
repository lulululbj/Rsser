package luyao.rsser.ui

import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.title_layout.*
import luyao.mvvm.core.base.BaseVMFragment
import luyao.rsser.model.bean.Title
import luyao.rsser.R
import luyao.rsser.vm.RssViewModel
import luyao.rsser.BR

/**
 * Created by luyao
 * on 2020/6/10 15:42
 */
class MainFragment : BaseVMFragment<RssViewModel>() {

    override fun getLayoutResId() = R.layout.fragment_main

    override fun initVM() = ViewModelProvider(this)[RssViewModel::class.java]

    override fun initView() {
        mBinding.run {
            setVariable(BR.title, Title(R.string.rsser, R.drawable.ic_menu) { }) }
        initMenu()
    }

    private fun initMenu(){
        mToolbar.run {
            inflateMenu(R.menu.main_menu)
            setOnMenuItemClickListener { item ->
                when(item.itemId){

                }
            }
        }
    }

    override fun initData() {
    }


    override fun startObserve() {
    }
}