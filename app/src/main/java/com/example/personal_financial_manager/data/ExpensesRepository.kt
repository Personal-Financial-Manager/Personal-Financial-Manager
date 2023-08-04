package com.example.personal_financial_manager.data

import com.example.personal_financial_manager.data.local.entity.Expense

interface ExpensesRepository {
    suspend fun fetchExpenses(): List<Expense>
    suspend fun insertExpense(expense: Expense): Long
    suspend fun updateExpense(expense: Expense): Int
    suspend fun deleteExpense(expense: Expense): Int
    suspend fun deleteAllExpense(): Int
}