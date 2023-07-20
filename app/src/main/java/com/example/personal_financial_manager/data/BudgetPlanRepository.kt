package com.example.personal_financial_manager.data

import com.example.personal_financial_manager.data.local.dao.BudgetPlanDao
import javax.inject.Inject

class BudgetPlanRepository @Inject constructor(private val budgetPlanDao: BudgetPlanDao) {

    suspend fun getSumOfBudgetPlanAmount(totalBudgetId: Int):Long {
        return budgetPlanDao.getSumOfBudgetPlanAmount(totalBudgetId)
    }
}