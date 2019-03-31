package com.example.nicecarddemo.ui.customviews

import android.content.Context
import android.util.AttributeSet
import com.example.nicecarddemo.R
import com.example.nicecarddemo.entities.NiceCard
import kotlinx.android.synthetic.main.view_nice_card.view.*

/**
 * Created by Nguyen on 3/31/2019.
 */
class NiceCardView : BaseCustomView {

    private var niceCard: NiceCard? = null

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun getLayoutResourceId(): Int {
        return R.layout.view_nice_card
    }

    override fun onViewReady() {
        showCard()
    }

    fun setCard(card: NiceCard?) {
        niceCard = card
        showCard()
    }

    private fun showCard() {
        niceCard?.let {
            cvCard.setCardBackgroundColor(it.color)
            tvCardItemValue.text = it.value.toString()
            tvCardItemId.text = (it.id + 1).toString()
        }

    }
}