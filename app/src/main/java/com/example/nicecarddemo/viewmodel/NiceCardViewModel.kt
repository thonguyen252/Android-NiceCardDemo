package com.example.nicecarddemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nicecarddemo.entities.NiceCard
import com.example.nicecarddemo.entities.NiceCardWrapper
import com.example.nicecarddemo.repositories.NiceCardRepository

/**
 * Created by Nguyen on 3/27/2019.
 */
class NiceCardViewModel : ViewModel() {

    private var selectedCard: NiceCardWrapper? = null
    private val selectedCardLiveData = MutableLiveData<NiceCardWrapper>()

    /**
     * Get all cards from repository
     */
    fun getNiceCards() = NiceCardRepository.getInstance().getNiceCards()

    /**
     * Get the card which was changed
     */
    fun getNiceCardChanged() = NiceCardRepository.getInstance().getNiceCardUpdated()

    /**
     * Get the card which user selected
     */
    fun getNiceCardSelected() = selectedCardLiveData as LiveData<NiceCardWrapper>

    /**
     * This function is called when user selects a card from the list
     */
    fun onCardSelected(card: NiceCard, position: Int) {
        selectedCardLiveData.value = NiceCardWrapper(card, position).also {
            selectedCard = it
        }
    }

    /**
     * This function is called when user click on the selecting card
     */
    fun onNiceCardClicked() {
        selectedCard?.let {
            NiceCardRepository.getInstance().onCardClicked(it)
        }
    }
}