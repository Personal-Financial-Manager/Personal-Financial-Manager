package com.example.personal_financial_manager.ui.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.personal_financial_manager.ui.budget.BudgetListFragment
import com.example.personal_financial_manager.ui.expense.ExpensesFragment
import com.example.personal_financial_manager.ui.income.IncomesFragment
import com.example.personal_financial_manager.ui.profile.ProfileFragment

private const val NUM_PAGES = 4

class HomePagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return NUM_PAGES
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ProfileFragment.newInstance()
            1 -> BudgetListFragment.newInstance()
            2 -> ExpensesFragment.newInstance()
            else -> IncomesFragment.newInstance()
        }
    }

}