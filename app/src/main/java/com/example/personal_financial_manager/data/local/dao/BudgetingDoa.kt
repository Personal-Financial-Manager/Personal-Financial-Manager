package com.example.personal_financial_manager.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.personal_financial_manager.data.local.entity.Budgeting

@Dao
interface BudgetingDoa {

    @Insert
    suspend fun insertBudget(budgeting: Budgeting)
}