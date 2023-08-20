package com.example.personal_financial_manager.ui.budget

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.personal_financial_manager.R
import com.example.personal_financial_manager.data.BudgetPlanRepository
import com.example.personal_financial_manager.data.TotalBudgetRepository
import com.example.personal_financial_manager.data.enum.MessageShowingType
import com.example.personal_financial_manager.data.enum.MoneyUnit
import com.example.personal_financial_manager.data.local.entity.TotalBudgetEntity
import com.example.personal_financial_manager.data.model.TotalBudget
import com.example.personal_financial_manager.data.model.mapToTotalBudget
import com.example.personal_financial_manager.di.JalalliCalendar1
import com.example.personal_financial_manager.util.CalendarInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class BudgetListViewModel @Inject constructor(
    private val application: Application,
    private val totalBudgetRepository: TotalBudgetRepository,
    private val budgetPlanRepository: BudgetPlanRepository,
    @JalalliCalendar1 private val jalalliCalendarHelper: CalendarInterface,
) : ViewModel() {

    private var _budgetUiState = MutableLiveData<BudgetUiState>()
    var budgetUiState: LiveData<BudgetUiState> = _budgetUiState

    private var _budgetValidationUiState = MutableLiveData<BudgetValidationState>()
    var budgetValidationUiState: LiveData<BudgetValidationState> = _budgetValidationUiState

    var totalBudget: TotalBudget? = null
    var sumOfBudgetPlanAmount: Long = 0L

    init {
        isUserSetBudget()
    }

    private fun isUserSetBudget() {
        viewModelScope.launch {
            val currentDateTime = jalalliCalendarHelper.getCurrentDateTime()
            totalBudget =
                totalBudgetRepository.getTotalBudgetForSpecificDate(currentDateTime.dateModel.year,
                    currentDateTime.dateModel.month)?.mapToTotalBudget()

            totalBudget?.let {
                sumOfBudgetPlanAmount = budgetPlanRepository.getSumOfBudgetPlanAmount(it.id)?:0
                withContext(Dispatchers.Main) {
                    _budgetUiState.value = BudgetUiState(it.amount, jalalliCalendarHelper.getCurrentMonthName())
                }
            } ?: apply {
                withContext(Dispatchers.Main) {
                    _budgetUiState.value = BudgetUiState(
                        0,
                        jalalliCalendarHelper.getCurrentMonthName(),
                        R.string.enter_budget)
                }
            }
        }
    }

    fun updateTotalBudgetAmount(updatedTotalBudget: String) {
        if (updatedTotalBudget.isEmpty()) {
            _budgetValidationUiState.value =
                BudgetValidationState(application.getString(R.string.attention),
                    application.getString(R.string.enter_total_budget_hint), MessageShowingType.DIALOG)
        } else if (totalBudget?.amount != 0L && updatedTotalBudget.toLong() < sumOfBudgetPlanAmount) {
            _budgetValidationUiState.value =
                BudgetValidationState(application.getString(R.string.attention),
                    application.getString(R.string.enter_total_budget_is_less_than_budget_plan),
                    MessageShowingType.DIALOG)
        } else if (totalBudget?.amount != 0L && updatedTotalBudget.toLong() > sumOfBudgetPlanAmount) {
            _budgetValidationUiState.value =
                BudgetValidationState(application.getString(R.string.attention),
                    application.getString(R.string.enter_total_budget_is_more_than_budget_plan,
                        updatedTotalBudget.toLong() - sumOfBudgetPlanAmount, MoneyUnit.TOMAN),
                    MessageShowingType.DIALOG)
            updateTotalBudget(updatedTotalBudget)
        } else {
            _budgetValidationUiState.value = BudgetValidationState()
        }
    }

    private fun updateTotalBudget(updatedTotalBudget: String) {
        viewModelScope.launch {
            totalBudgetRepository.updateTotalBudget(
                TotalBudgetEntity(jalalliCalendarHelper.getCurrentDateTime().dateModel.year,
                    jalalliCalendarHelper.getCurrentDateTime().dateModel.month, updatedTotalBudget.toLong()))
        }
    }

    data class BudgetUiState(
        val totalBudgetAmount: Long,
        val monthName: String,
        val showEmptyPageText: Int? = null,
        val moneyUnit: MoneyUnit = MoneyUnit.TOMAN,
    )

    data class BudgetValidationState(
        val errorTitle: String? = null,
        val errorDescription: String? = null,
        val errorMessageShowingType: MessageShowingType = MessageShowingType.DIALOG,
    )
}