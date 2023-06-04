package com.example.personal_financial_manager.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.personal_financial_manager.R

class HomeContainerFragment : Fragment() {

    companion object {
        fun newInstance() = HomeContainerFragment()
    }

    private val viewModel: HomeContainerViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_home_container, container, false)
    }
}