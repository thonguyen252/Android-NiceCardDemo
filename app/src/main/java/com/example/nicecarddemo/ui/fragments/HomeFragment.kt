package com.example.nicecarddemo.ui.fragments

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nicecarddemo.R
import com.example.nicecarddemo.adapters.NiceCardAdapter
import com.example.nicecarddemo.entities.NiceCard
import com.example.nicecarddemo.entities.NiceCardWrapper
import com.example.nicecarddemo.utils.RecyclerViewUtil
import com.example.nicecarddemo.viewmodel.NiceCardViewModel
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by Nguyen on 3/27/2019.
 */
class HomeFragment : BaseFragment() {

    private val niceCardAdapter = NiceCardAdapter()
    private var niceCardViewModel: NiceCardViewModel? = null

    override fun getLayoutResourceId(): Int {
        return R.layout.fragment_home
    }

    override fun initializeViewModel() {
        niceCardViewModel = ViewModelProviders.of(this).get(NiceCardViewModel::class.java).apply {

            // Get all cards from fake repository
            getNiceCards().observe(this@HomeFragment, Observer {
                showAllCards(it)
            })

            // When the value of the selected card is changed
            getNiceCardChanged().observe(this@HomeFragment, Observer {
                onCardChanged(it)
            })

            // When a card in the recycler_view is selected
            getNiceCardSelected().observe(this@HomeFragment, Observer {
                showSelectedCard(it.card)
            })
        }
    }

    override fun initializeView(savedInstanceState: Bundle?) {
        rcvNiceCards.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            addItemDecoration(RecyclerViewUtil.getBaseHorizontalDecorator(context))
            adapter = niceCardAdapter
        }

        niceCardAdapter.itemClickObservable.subscribe {
            niceCardViewModel?.onCardSelected(niceCardAdapter.getItem(it), it)
        }

        cvNiceCard.setOnClickListener {
            niceCardViewModel?.onNiceCardClicked()
        }
    }

    /**
     * Show the a list of NiceCard to the horizontal recycler_view
     */
    private fun showAllCards(cards: List<NiceCard>) {
        niceCardAdapter.apply {
            setItem(cards)
            notifyDataSetChanged()
        }
    }

    /**
     * Show the selected card when user selects a card
     */
    private fun showSelectedCard(card: NiceCard) {
        cvNiceCard.setCardBackgroundColor(card.color)
        tvNiceCardId.text = (card.id + 1).toString()
        tvNiceCardValue.text = card.value.toString()
    }

    /**
     * Update the card's value when user touches on a selected card
     */
    private fun onCardChanged(card: NiceCardWrapper) {
        niceCardAdapter.onCardChanged(card)
        showSelectedCard(card.card)
    }

}