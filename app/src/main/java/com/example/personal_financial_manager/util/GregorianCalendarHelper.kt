package com.example.personal_financial_manager.util

import com.example.personal_financial_manager.data.model.DateModel
import com.example.personal_financial_manager.data.model.DateTimeModel
import com.example.personal_financial_manager.data.model.TimeModel
import com.example.personal_financial_manager.di.GregorianCalendar2
import saman.zamani.persiandate.PersianDate
import javax.inject.Inject

@GregorianCalendar2
class GregorianCalendarHelper @Inject constructor(private val persianDate: PersianDate) : CalendarInterface {

    override fun getCurrentDateTime(): DateTimeModel {
        return DateTimeModel(
            DateModel(persianDate.grgYear, persianDate.grgMonth, persianDate.grgDay),
            TimeModel(persianDate.hour, persianDate.minute, persianDate.second))
    }

    override fun getCurrentMonthName(): String {
        return persianDate.grgMonthName
    }
}