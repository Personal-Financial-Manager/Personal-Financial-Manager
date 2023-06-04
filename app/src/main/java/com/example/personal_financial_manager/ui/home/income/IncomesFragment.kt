package com.example.personal_financial_manager.ui.home.income

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.personal_financial_manager.R
import com.example.personal_financial_manager.databinding.FragmentIncomesBinding

class IncomesFragment : Fragment() {

    private var _binding: FragmentIncomesBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = IncomesFragment()
    }

    private val viewModel: IncomesViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_incomes, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }
}