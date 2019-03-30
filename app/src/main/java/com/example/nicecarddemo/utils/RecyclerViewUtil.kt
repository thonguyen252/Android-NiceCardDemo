package com.example.nicecarddemo.utils

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.nicecarddemo.R

/**
 * Created by Nguyen on 3/27/2019.
 */
object RecyclerViewUtil {

    fun getBaseHorizontalDecorator(context: Context?): DividerItemDecoration {
        val decorator = DividerItemDecoration(context, RecyclerView.HORIZONTAL)
        context?.run {
            ContextCompat.getDrawable(this, R.drawable.item_nice_card_decorator)?.let { drawable ->
                decorator.setDrawable(drawable)
            }
        }
        return decorator
    }
}