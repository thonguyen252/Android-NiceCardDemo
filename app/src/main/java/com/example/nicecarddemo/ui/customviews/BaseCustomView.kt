package com.example.nicecarddemo.ui.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout

/**
 * Created by Nguyen on 3/31/2019.
 */
abstract class BaseCustomView : FrameLayout {

    constructor(context: Context) : super(context) {
        initView()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initView()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initView()
    }

    private fun initView() {
        addView(createView(context))
    }

    private fun createView(context: Context?): View {
        return LayoutInflater.from(context).inflate(getLayoutResourceId(), this, false)
    }

    abstract fun getLayoutResourceId(): Int

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        onViewReady()
    }

    abstract fun onViewReady()
}