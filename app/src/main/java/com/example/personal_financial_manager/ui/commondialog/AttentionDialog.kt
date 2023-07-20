package com.example.personal_financial_manager.ui.commondialog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.example.personal_financial_manager.R
import com.example.personal_financial_manager.databinding.DialogFragmentAttentionBinding
import javax.annotation.Nullable


class AttentionDialog : DialogFragment() {

    private var _binding: DialogFragmentAttentionBinding? = null
    private val binding get() = _binding!!

    private var mListener: DialogListener? = null
    private var description = ""
    private var title = ""

    companion object {
        private const val KEY_TITLE = "KEY_TITLE"
        private const val KEY_DESCRIPTION = "KEY_DESCRIPTION"

        fun newInstance(title: String, description: String): AttentionDialog {
            val bundle = Bundle()
            bundle.putString(KEY_TITLE, title)
            bundle.putString(KEY_DESCRIPTION, description)
            val attentionDialog = AttentionDialog()
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
            parentFragment as DialogListener?
        } catch (e: ClassCastException) {
            e.printStackTrace()
            null
        }
    }

    private fun getBundleInfo() {
        arguments?.let {
            title = it.getString(KEY_TITLE, "")
            description = it.getString(KEY_DESCRIPTION, "")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?,
    ): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.dialog_fragment_attention, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvTitle.text = title
        binding.tvDescription.text = description
        binding.btnConfirm.setOnClickListener {
            mListener?.onConfirmDialog()
            dismiss()
        }
    }

    interface DialogListener {
        fun onConfirmDialog()
    }
}