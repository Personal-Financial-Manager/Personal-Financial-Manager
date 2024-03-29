package com.example.personal_financial_manager.ui.budget

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.personal_financial_manager.R
import com.example.personal_financial_manager.data.enum.MoneyUnit
import com.example.personal_financial_manager.databinding.FragmentBudgetListBinding
import com.example.personal_financial_manager.ui.commondialog.AttentionDialog
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class BudgetListFragment : Fragment() {

    private var _binding: FragmentBudgetListBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = BudgetListFragment()
    }

    private val viewModel: BudgetListViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_budget_list, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListener()
        setTotalBudgetActionDone()
        observePageDetail()
        observeBudgetValidation()
        setupMonth()
    }

    private fun observeBudgetValidation() {
        viewModel.budgetValidationUiState.observe(viewLifecycleOwner) {
            if (it.errorDescription != null && it.errorTitle != null) {
                val editNameDialogFragment: AttentionDialog =
                    AttentionDialog.newInstance(it.errorTitle, it.errorDescription)
                editNameDialogFragment.show(parentFragmentManager, "dialogFragmentAttention")
            }
        }
    }

    private fun setTotalBudgetActionDone() {
        binding.etTotalBudgetAmount.setOnEditorActionListener { textView, _, _ ->
            viewModel.updateTotalBudgetAmount(textView.text.toString())
            true
        }
    }

    private fun observePageDetail() {
        viewModel.budgetUiState.observe(viewLifecycleOwner) {
            maybeNoBudgetPlanInPage(it.showEmptyPageText)
            maybeNoTotalBudget(it.totalBudgetAmount, it.moneyUnit)
            setupMonth()
        }
    }

    private fun maybeNoTotalBudget(totalBudgetAmount: Long, moneyUnit: MoneyUnit) {
        if (totalBudgetAmount != 0L) {
            binding.etTotalBudgetAmount.setText(getTotalBudgetAmountText(totalBudgetAmount, moneyUnit))
        } else {
            binding.tlTotalBudgetAmount.hint = getString(R.string.enter_total_budget_hint)
        }
    }

    private fun getTotalBudgetAmountText(totalBudgetAmount: Long, moneyUnit: MoneyUnit): String {
        val amountWithCommaSeparator =
            String.format(getString(R.string.money_separator), totalBudgetAmount, getString(moneyUnit.value))
        return HtmlCompat.fromHtml(amountWithCommaSeparator, HtmlCompat.FROM_HTML_MODE_COMPACT).toString()
    }

    private fun maybeNoBudgetPlanInPage(showEmptyPageText: Int?) {
        showEmptyPageText?.let {
            binding.tvNoBudgetPlan.isVisible = true
            binding.btnBudgetingHistory.isVisible = false
            binding.tvBudgetMonth.isVisible = false
            binding.rvExpensesList.isVisible = false
        }
    }

    private fun setupMonth() {
        binding.tvBudgetMonth
    }

    private fun setOnClickListener() {
        binding.fabAddBudgetPlan.setOnClickListener { }
        binding.btnBudgetingHistory.setOnClickListener { }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}