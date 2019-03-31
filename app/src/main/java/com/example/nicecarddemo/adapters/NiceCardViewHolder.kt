package com.example.nicecarddemo.adapters

import android.view.View
import com.example.nicecarddemo.entities.NiceCard
import kotlinx.android.synthetic.main.item_nice_card.view.*

/**
 * Created by Nguyen on 3/27/2019.
 */
class NiceCardViewHolder(view: View) : BaseRecyclerViewViewHolder<NiceCard>(view) {

    override fun bindView(item: NiceCard) {
        itemView.cvNiceCard.setCard(item)
    }
}