package luyao.mvvm.core.view

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by luyao
 * on 2020/6/10 14:54
 */
class SpaceItemDecoration(
    private val top: Int = 0,
    private val left: Int = 0,
    private val bottom: Int = 0,
    private val right: Int = 0
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        if (top > 0) outRect.top = top
        if (left > 0) outRect.left = left
        if (bottom > 0) outRect.bottom = bottom
        if (right > 0) outRect.right = right
    }


}