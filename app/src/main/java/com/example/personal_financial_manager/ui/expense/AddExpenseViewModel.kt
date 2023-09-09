package com.example.personal_financial_manager.ui.expense

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.personal_financial_manager.data.local.entity.Expense
import com.example.personal_financial_manager.usecase.expenses.ExpensesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddExpenseViewModel @Inject constructor(private val useCase: ExpensesUseCase) : ViewModel() {

    private val _expenseState = MutableStateFlow<ExpenseUiState?>(null)
    val expenseState: StateFlow<ExpenseUiState?> = _expenseState

    fun addExpense() {
        viewModelScope.launch(Dispatchers.IO) {
            _expenseState.value?.let {
                useCase.insertExpense(it.mapToExpense())
            }
        }
    }
}

data class ExpenseUiState(
    val title: String,
    val amount: Long,
    val date: Long,
    val description: String,
    val category: String,
)

fun ExpenseUiState.mapToExpense(): Expense {
    return Expense(
        title = title,
        amount = amount,
        date = date,
        description = description,
        category = category
    )
}