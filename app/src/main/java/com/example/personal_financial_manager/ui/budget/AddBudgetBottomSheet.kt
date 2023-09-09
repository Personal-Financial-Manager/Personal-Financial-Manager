package com.example.personal_financial_manager.ui.budget

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.example.personal_financial_manager.databinding.BottomSheetAddBudgetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.chip.Chip


class AddBudgetBottomSheet : BottomSheetDialogFragment() {

    private var _binding: BottomSheetAddBudgetBinding? = null

    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: AddBudgetBottomSheetViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = BottomSheetAddBudgetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addCategories()
        addCategories()
        addCategories()
        addCategories()
    }

    fun addCategories() {
        val chip = Chip(requireContext())
        chip.setChipBackgroundColorResource(R.color.darker_gray)
        chip.isCloseIconVisible = true
        chip.chipIcon = ContextCompat.getDrawable(requireContext(), R.drawable.arrow_up_float)
        binding.chgIcon.addView(chip)
    }
}