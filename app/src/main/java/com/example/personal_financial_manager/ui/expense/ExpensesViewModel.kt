package com.example.personal_financial_manager.ui.expense

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.personal_financial_manager.usecase.expenses.ExpensesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExpensesViewModel @Inject constructor(private val useCase: ExpensesUseCase) : ViewModel() {
    // todo: delete this.
    fun test() {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.fetchExpenses()
        }
    }
}