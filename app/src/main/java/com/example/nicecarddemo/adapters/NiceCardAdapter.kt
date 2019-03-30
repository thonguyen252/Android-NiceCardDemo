package com.example.nicecarddemo.adapters

import android.view.ViewGroup
import com.example.nicecarddemo.R
import com.example.nicecarddemo.entities.NiceCard
import com.example.nicecarddemo.entities.NiceCardWrapper

/**
 * Created by Nguyen on 3/27/2019.
 */
class NiceCardAdapter : BaseRecyclerViewAdapter<NiceCard, NiceCardViewHolder>() {

    override fun getLayoutResourceId(): Int {
        return R.layout.item_nice_card
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NiceCardViewHolder {
        return NiceCardViewHolder(getView(parent))
    }

    fun onCardChanged(card: NiceCardWrapper) {
//        notifyItemChanged(setItem(card.card, card.position))
        setItem(card.card, card.position)
        notifyDataSetChanged()
    }
}