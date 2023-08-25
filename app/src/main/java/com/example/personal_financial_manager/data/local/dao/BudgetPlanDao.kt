package com.example.personal_financial_manager.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.personal_financial_manager.data.local.entity.BudgetPlanEntity
import com.example.personal_financial_manager.data.local.entity.TotalBudgetEntity

@Dao
interface BudgetPlanDao {

    @Insert
    suspend fun insertBudget(budgetPlanEntity: BudgetPlanEntity)

    @Query("Select Sum(Amount) From budgetplanentity where BudgetMainFk = :budgetMainFk")
    suspend fun getSumOfBudgetPlanAmount(budgetMainFk: Int): Long?
}