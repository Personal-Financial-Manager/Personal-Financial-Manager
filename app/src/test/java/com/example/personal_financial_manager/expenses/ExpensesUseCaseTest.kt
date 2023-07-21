package com.example.personal_financial_manager.expenses

import com.example.personal_financial_manager.data.ExpensesRepository
import com.example.personal_financial_manager.usecase.expenses.ExpensesUseCase
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ExpensesUseCaseTest {

    private lateinit var testSubject: ExpensesUseCase
    private lateinit var repository: ExpensesRepository

    @BeforeAll
    fun init(){
        testSubject = ExpensesUseCase(repository)
    }

}