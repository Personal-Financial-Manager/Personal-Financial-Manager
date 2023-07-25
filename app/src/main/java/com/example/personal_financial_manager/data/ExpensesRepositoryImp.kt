package com.example.personal_financial_manager.data

import com.example.personal_financial_manager.data.local.db.FinancialDatabase
import com.example.personal_financial_manager.data.local.entity.Expense
import javax.inject.Inject

class ExpensesRepositoryImp @Inject constructor(val database: FinancialDatabase) : ExpensesRepository {

    override suspend fun fetchExpenses(): List<Expense> {
        return database.expenseDao().getAllExpenses()
    }
}