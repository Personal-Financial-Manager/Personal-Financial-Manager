package com.example.personal_financial_manager.data

import com.example.personal_financial_manager.data.local.db.FinancialDatabase
import com.example.personal_financial_manager.data.local.entity.Expense
import javax.inject.Inject

class ExpensesRepositoryImp @Inject constructor(database: FinancialDatabase) : ExpensesRepository {
    private val expensesDao = database.expenseDao()

    override suspend fun fetchExpenses(): List<Expense> {
        return expensesDao.fetchExpenses()
    }

    override suspend fun insertExpense(expense: Expense): Long {
        return expensesDao.insertExpenses(expense)
    }

    override suspend fun updateExpense(expense: Expense): Long {
        return expensesDao.updateExpense(expense)
    }

    override suspend fun deleteExpense(expense: Expense): Long {
        return expensesDao.deleteExpense(expense)
    }

    override suspend fun deleteAllExpense(): Long {
        return expensesDao.deleteAllExpenses()
    }
}