package luyao.rsser.ui

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import luyao.mvvm.core.base.BaseVMFragment
import luyao.rsser.R
import luyao.rsser.databinding.FragmentMainBinding
import luyao.rsser.model.bean.Title
import luyao.rsser.vm.RssViewModel

/**
 * Created by luyao
 * on 2020/6/10 15:42
 */
class MainFragment : BaseVMFragment<FragmentMainBinding>(R.layout.fragment_main) {

    private val mViewModel by viewModels<RssViewModel>()


    override fun initView() {
        binding.setTitle(Title(R.string.rsser, R.drawable.arrow_back) {})
        initMenu()
    }

    private fun initMenu() {
        binding.title.mToolbar.run {
            inflateMenu(R.menu.main_menu)
            setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.action_add -> {
                        showAddRssDialog()
                    }
                }
                true
            }
        }
    }

    override fun initData() {
    }


    override fun startObserve() {
    }

    private fun showAddRssDialog() {
//        activity?.let {
//            MaterialDialog(it).show {
//                title(R.string.add_rss)
//                input(
//                    hintRes = R.string.please_input_url,
//                    allowEmpty = false,
//                    inputType = InputType.TYPE_TEXT_VARIATION_URI
//                ) { dialog, text ->
//
//                }
//                positiveButton(R.string.add)
//                negativeButton(R.string.cancel)
//            }
//        }
        findNavController().navigate(R.id.action_main_to_add_rss)
    }
}