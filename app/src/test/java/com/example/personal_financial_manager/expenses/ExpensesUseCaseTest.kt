package com.example.personal_financial_manager.expenses

import com.example.personal_financial_manager.data.ExpensesRepository
import com.example.personal_financial_manager.data.local.entity.Expense
import com.example.personal_financial_manager.usecase.expenses.ExpensesUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import javax.inject.Inject

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ExpensesUseCaseTest @Inject constructor() {

    private lateinit var testSubject: ExpensesUseCase
    private lateinit var repository: ExpensesRepository

    @BeforeAll
    fun init() {
        repository = ExpensesRepositoryTestDouble()
        testSubject = ExpensesUseCase(repository)
    }

    @Test
    fun fetchExpenses_emptyInput_returnsListOfExpenses() {
        CoroutineScope(Dispatchers.IO).launch {
            val expensesList = testSubject.fetchExpenses()
            assertEquals(0, expensesList.size)
        }
    }
}

class ExpensesRepositoryTestDouble() : ExpensesRepository {
    override suspend fun fetchExpenses(): List<Expense> {
        return listOf()
    }

    override suspend fun insertExpense(expense: Expense): Long {
        TODO("Not implemented")
    }

    override suspend fun insertExpenses(vararg expenses: Expense): List<Long> {
        TODO("Not yet implemented")
    }

    override suspend fun updateExpense(expense: Expense): Int {
        TODO("Not implemented")
    }

    override suspend fun deleteExpense(expense: Expense): Int {
        TODO("Not implemented")
    }

    override suspend fun deleteAllExpense(): Int {
        TODO("Not implemented")
    }
}