package luyao.rsser.ui

import androidx.fragment.app.viewModels
import luyao.mvvm.core.base.BaseVMFragment
import luyao.rsser.BR
import luyao.rsser.R
import luyao.rsser.model.bean.Title
import luyao.rsser.vm.AddRssViewModel

class AddRssFragment : BaseVMFragment() {

    private val mViewModel by viewModels<AddRssViewModel>()

    override fun getLayoutResId() = R.layout.fragment_add_rss

    override fun initView() {
        mBinding.run {
            setVariable(BR.title, Title(R.string.add_rss,R.drawable.arrow_back){ onBackPressed() })
        }
    }

    override fun initData() {
    }

    override fun startObserve() {
    }
}