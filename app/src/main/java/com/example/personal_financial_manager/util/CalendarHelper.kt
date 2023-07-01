package com.example.personal_financial_manager.util

import com.example.personal_financial_manager.data.model.DateModel
import com.example.personal_financial_manager.data.model.DateTimeModel
import com.example.personal_financial_manager.data.model.TimeModel
import java.util.Calendar

class CalendarHelper {

    fun getCurrentDateTime(): DateTimeModel {
        val instance = Calendar.getInstance()
       return DateTimeModel(
            DateModel(
                instance.get(Calendar.YEAR),
                instance.get(Calendar.MONTH),
                instance.get(Calendar.DAY_OF_MONTH)
            ),
            TimeModel(
                instance.get(Calendar.HOUR_OF_DAY),
                instance.get(Calendar.MINUTE),
                instance.get(Calendar.SECOND)
            )
        )
    }
}