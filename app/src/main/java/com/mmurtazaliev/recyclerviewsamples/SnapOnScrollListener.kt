package com.mmurtazaliev.recyclerviewsamples

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.mmurtazaliev.recyclerviewsamples.utils.OnSnapPositionChangeListener

class SnapOnScrollListener(
    private val snapHelper: SnapHelper,
    private var onSnapPositionChangeListener: OnSnapPositionChangeListener? = null
) : RecyclerView.OnScrollListener() {

    private var snapPosition = RecyclerView.NO_POSITION
    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        maybeNotifySnapPositionChange(recyclerView)
    }

    private fun maybeNotifySnapPositionChange(recyclerView: RecyclerView) {
        val snapPosition = snapHelper.getSnapPosition(recyclerView)
        val snapPositionOnChanged = this.snapPosition != snapPosition
        if (snapPositionOnChanged) {
            onSnapPositionChangeListener?.onSnapPositionChange(snapPosition)
            this.snapPosition = snapPosition
        }
    }
}