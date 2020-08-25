package luyao.rsser.ui

import androidx.fragment.app.viewModels
import luyao.mvvm.core.base.BaseVMFragment
import luyao.rsser.BR
import luyao.rsser.R
import luyao.rsser.databinding.FragmentAddRssBinding
import luyao.rsser.model.bean.Title
import luyao.rsser.vm.AddRssViewModel

class AddRssFragment : BaseVMFragment<FragmentAddRssBinding>(R.layout.fragment_add_rss) {

    private val mViewModel by viewModels<AddRssViewModel>()

    override fun initView() {
        binding.run {
            setTitle( Title(R.string.add_rss, R.drawable.arrow_back) { })
            viewModel = mViewModel
        }
    }

    override fun initData() {
    }

    override fun startObserve() {
    }
}