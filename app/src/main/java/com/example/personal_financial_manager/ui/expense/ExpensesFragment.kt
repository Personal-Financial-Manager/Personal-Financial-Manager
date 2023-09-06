package com.example.personal_financial_manager.ui.expense

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.personal_financial_manager.R
import com.example.personal_financial_manager.databinding.FragmentExpensesBinding
import com.example.personal_financial_manager.ui.TAG
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExpensesFragment : Fragment() {

    private var _binding: FragmentExpensesBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = ExpensesFragment()
    }

    private val viewModel: ExpensesViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_expenses, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initOnClickListeners()
    }

    private fun initOnClickListeners() {
        binding.fabExpenses.setOnClickListener {
            Toast.makeText(requireContext(), "Test", Toast.LENGTH_SHORT).show()
            AddExpenseBottomSheetFragment().show(childFragmentManager, TAG)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}