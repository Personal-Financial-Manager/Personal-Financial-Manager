package com.example.personal_financial_manager.di

import com.example.personal_financial_manager.util.CalendarInterface
import com.example.personal_financial_manager.util.GregorianCalendarHelper
import com.example.personal_financial_manager.util.JalalliCalendarHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import saman.zamani.persiandate.PersianDate
import javax.inject.Qualifier


@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class JalalliCalendar1

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class GregorianCalendar2

@InstallIn(ViewModelComponent::class)
@Module
class CalendarTypesModule {

    @Provides
    @JalalliCalendar1
    fun bindJalalliCalendar(persianDate: PersianDate): CalendarInterface {
        return JalalliCalendarHelper(persianDate)
    }

    @Provides
    @GregorianCalendar2
    fun bindGregorianCalendar(persianDate: PersianDate): CalendarInterface {
        return GregorianCalendarHelper(persianDate)
    }
}

