package com.androidnerds.doordash.storefeed.presentation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androidnerds.doordash.R

class StoreFeedFragment : Fragment() {

    companion object {
        fun newInstance() = StoreFeedFragment()
    }

    private lateinit var viewModel: StoreFeedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.store_feed_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(StoreFeedViewModel::class.java)
        // TODO: Use the ViewModel
    }

}