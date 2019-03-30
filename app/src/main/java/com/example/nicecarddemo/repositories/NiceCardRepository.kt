package com.example.nicecarddemo.repositories

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nicecarddemo.entities.NiceCard
import com.example.nicecarddemo.entities.NiceCardWrapper

/**
 * This repository is supposed to work with RestAPI or with database
 * For now it just store and initialize fake data
 */
class NiceCardRepository {

    private val cardList = mutableListOf<NiceCard>()
    private val cards = MutableLiveData<List<NiceCard>>()
    private val updatedCard = MutableLiveData<NiceCardWrapper>()

    companion object {
        private var instance: NiceCardRepository? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: NiceCardRepository().also { instance = it }
        }

        private const val FAKE_MAX_CARD_NUMBER = 100
        private const val MAX_CARD_VALUE = 1000
        private val COLORS = listOf(
                Color.BLUE, Color.YELLOW, Color.RED, Color.GREEN, Color.CYAN, Color.MAGENTA, Color.LTGRAY, Color.DKGRAY
        )
    }

    init {
        // Initialize fake date
        for (i in 0 until FAKE_MAX_CARD_NUMBER) {
            cardList.add(NiceCard(i, COLORS[i % COLORS.size], 0))
        }
        cards.value = cardList
    }

    fun getNiceCards() = cards as LiveData<List<NiceCard>>

    fun getNiceCardUpdated() = updatedCard as LiveData<NiceCardWrapper>

    fun onCardClicked(card: NiceCardWrapper) {

        // Supposed to call API or update database here
        if (card.card.value < MAX_CARD_VALUE) {
            card.card.value++

            /*
            In this demo, the card object is exactly the card in the cardList. So this step looks redundant.
            But in reality, after calling API, we need to store the new value to the cardList.
             */
            cardList[card.position].value = card.card.value
            updatedCard.value = card
        }
    }
}