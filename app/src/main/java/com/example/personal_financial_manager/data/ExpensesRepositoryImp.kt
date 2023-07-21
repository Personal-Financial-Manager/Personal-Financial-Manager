package com.example.personal_financial_manager.data

import com.example.personal_financial_manager.data.local.entity.Expense
import javax.inject.Inject

class ExpensesRepositoryImp @Inject constructor(): ExpensesRepository {

    override fun getExpenses(): List<Expense> {
        return listOf()
    }
}