package com.example.nicecarddemo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.subjects.PublishSubject
import java.util.*

/**
 * Created by Nguyen on 3/27/2019.
 */
abstract class BaseRecyclerViewAdapter<T, V : BaseRecyclerViewViewHolder<T>>() : RecyclerView.Adapter<V>() {

    private var items: ArrayList<T> = arrayListOf()

    val itemClickObservable = PublishSubject.create<Int>()

    constructor(items: List<T>) : this() {
        this.items = items as ArrayList<T>
    }

    fun addItem(item: T) {
        items.add(item)
    }

    fun setItem(item: List<T>) {
        items.addAll(item)
    }

    fun setItem(item: T, position: Int): Int {
        if (position >= 0 && position < items.size) {
            items[position] = item
            return position
        }
        return -1
    }

    fun getItem(position: Int) : T {
        return items[position]
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: V, position: Int) {
        holder.bindView(items[position])
        holder.itemView.setOnClickListener {
            itemClickObservable.onNext(position)
        }
    }

    protected fun getView(parent: ViewGroup): View {
        return getLayoutInflater(parent).inflate(getLayoutResourceId(), parent, false)
    }

    protected fun getLayoutInflater(parentView: ViewGroup): LayoutInflater {
        return LayoutInflater.from(parentView.context)
    }

    protected abstract fun getLayoutResourceId(): Int

}