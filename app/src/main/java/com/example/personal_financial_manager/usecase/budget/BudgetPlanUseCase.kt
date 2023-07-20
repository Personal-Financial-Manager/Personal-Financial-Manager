package com.example.personal_financial_manager.usecase.budget

import com.example.personal_financial_manager.data.BudgetPlanRepository
import javax.inject.Inject

class BudgetPlanUseCase @Inject constructor(private val budgetPlanRepository: BudgetPlanRepository) {
    suspend fun getSumOfBudgetPlanAmount(totalBudgetId: Int): Long {
        return budgetPlanRepository.getSumOfBudgetPlanAmount(totalBudgetId)
    }
}