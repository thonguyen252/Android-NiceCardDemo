package com.example.nicecarddemo.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Nguyen on 3/27/2019.
 */
abstract class BaseRecyclerViewViewHolder<T>(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun bindView(item: T)
}