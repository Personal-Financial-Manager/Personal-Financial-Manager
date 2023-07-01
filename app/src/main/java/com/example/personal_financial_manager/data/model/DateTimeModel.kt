package com.example.personal_financial_manager.data.model

data class DateTimeModel(
    val dateModel: DateModel,
    val timeModel: TimeModel,
)

data class DateModel(
    val year: Int,
    val month: Int,
    val day: Int,
)

data class TimeModel(
    val hour: Int,
    val minute: Int,
    val second: Int,
)