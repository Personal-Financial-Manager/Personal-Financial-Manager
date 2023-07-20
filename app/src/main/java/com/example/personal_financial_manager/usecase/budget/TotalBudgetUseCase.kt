package com.example.personal_financial_manager.usecase.budget

import com.example.personal_financial_manager.data.TotalBudgetRepository
import com.example.personal_financial_manager.data.model.TotalBudget
import com.example.personal_financial_manager.data.model.mapToTotalBudget
import javax.inject.Inject

class TotalBudgetUseCase @Inject constructor(private val totalBudgetRepository: TotalBudgetRepository) {

    suspend fun getTotalBudgetForSpecificDate(year: Int, month: Int): TotalBudget? {
        return totalBudgetRepository.getTotalBudgetForSpecificDate(year, month)?.mapToTotalBudget()
    }
}