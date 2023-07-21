package com.example.personal_financial_manager.usecase.expenses

import com.example.personal_financial_manager.data.ExpensesRepository
import com.example.personal_financial_manager.data.local.entity.Expense
import javax.inject.Inject

class ExpensesUseCase @Inject constructor(private val repository: ExpensesRepository) {

    fun fetchExpenses(): List<Expense>{
        return repository.fetchExpenses()
    }
}