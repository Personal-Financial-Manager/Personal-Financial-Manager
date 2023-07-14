package com.example.personal_financial_manager.util

import com.example.personal_financial_manager.data.model.DateTimeModel

interface CalendarInterface {

    fun getCurrentDateTime(): DateTimeModel

    fun getCurrentMonthName():String
}