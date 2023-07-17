package com.example.personal_financial_manager.ui.expense

import androidx.lifecycle.ViewModel
import com.example.personal_financial_manager.usecase.expenses.ExpensesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ExpensesViewModel @Inject constructor(private val useCase: ExpensesUseCase) : ViewModel() {

}