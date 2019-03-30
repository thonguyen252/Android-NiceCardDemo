package com.example.nicecarddemo.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * Created by Nguyen on 3/27/2019.
 *
 * This BaseFragment will contain the common functions which can be shared in all fragments.
 * All of the fragments in the app should be extended from this class
 */
abstract class BaseFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutResourceId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViewModel()
        initializeView(savedInstanceState)
    }

    protected abstract fun getLayoutResourceId(): Int

    protected abstract fun initializeViewModel()

    protected abstract fun initializeView(savedInstanceState: Bundle?)

}