package com.example.personal_financial_manager.data

import com.example.personal_financial_manager.data.local.entity.Expense

interface ExpensesRepository {
    suspend fun fetchExpenses(): List<Expense>
}