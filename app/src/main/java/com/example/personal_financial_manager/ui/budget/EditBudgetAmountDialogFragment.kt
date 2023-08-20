package com.example.personal_financial_manager.ui.budget

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.example.personal_financial_manager.R
import com.example.personal_financial_manager.databinding.DialogFragmentEditBudgetBinding
import javax.annotation.Nullable


class EditBudgetAmountDialogFragment : DialogFragment() {

    private var _binding: DialogFragmentEditBudgetBinding? = null
    private val binding get() = _binding!!

    private var mListener: OnBudgetAmountUpdate? = null
    private var amount = 0

    companion object {
        private const val KEY_BUDGET_AMOUNT = "KEY_BUDGET_AMOUNT"

        fun newInstance(amount: Int): EditBudgetAmountDialogFragment {
            val bundle = Bundle()
            bundle.putInt(KEY_BUDGET_AMOUNT, amount)
            val attentionDialog = EditBudgetAmountDialogFragment()
            attentionDialog.arguments = bundle
            return attentionDialog
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getBundleInfo()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mListener = try {
            parentFragment as OnBudgetAmountUpdate?
        } catch (e: ClassCastException) {
            e.printStackTrace()
            null
        }
    }

    private fun getBundleInfo() {
        arguments?.let {
            amount = it.getInt(KEY_BUDGET_AMOUNT, 0)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?,
    ): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.dialog_fragment_edit_budget, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnConfirm.setOnClickListener {
            if (!binding.etTotalBudgetAmount.text.isNullOrEmpty() && binding.etTotalBudgetAmount.text.toString()
                    .toInt() != amount)
                mListener?.getUpdatedBudgetAmount(binding.etTotalBudgetAmount.text.toString()
                    .toInt())
            dismiss()
        }
    }

    interface OnBudgetAmountUpdate {
        fun getUpdatedBudgetAmount(amount: Int)
    }
}