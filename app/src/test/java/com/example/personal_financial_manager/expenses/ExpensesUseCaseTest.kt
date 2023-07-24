package com.example.personal_financial_manager.expenses

import com.example.personal_financial_manager.data.ExpensesRepository
import com.example.personal_financial_manager.data.local.entity.Expense
import com.example.personal_financial_manager.usecase.expenses.ExpensesUseCase
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
        val expensesList = testSubject.fetchExpenses()
        assertEquals(0, expensesList.size)
    }
}

class ExpensesRepositoryTestDouble() : ExpensesRepository {
    override fun fetchExpenses(): List<Expense> {
        return listOf()
    }
}