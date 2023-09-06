package com.example.personal_financial_manager.ui.expense

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.personal_financial_manager.R
import com.example.personal_financial_manager.databinding.BottomSheetAddExpenseBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddExpenseBottomSheetFragment : BottomSheetDialogFragment() {

    private var _binding: BottomSheetAddExpenseBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AddExpenseViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.bottom_sheet_add_expense, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

interface OnExpenseAddedListener {
    fun onExpenseAdded()
}