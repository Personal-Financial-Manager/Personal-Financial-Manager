package com.example.personal_financial_manager.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.personal_financial_manager.R
import com.example.personal_financial_manager.databinding.FragmentHomeContainerBinding

class HomeContainerFragment : Fragment() {

    private var _binding: FragmentHomeContainerBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeContainerViewModel by viewModels()

    companion object {
        fun newInstance() = HomeContainerFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_container, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}