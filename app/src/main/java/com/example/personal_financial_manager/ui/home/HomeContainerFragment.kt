package com.example.personal_financial_manager.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.personal_financial_manager.R
import com.example.personal_financial_manager.databinding.FragmentHomeContainerBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeContainerFragment : Fragment() {

    private var _binding: FragmentHomeContainerBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeContainerViewModel by viewModels()

    companion object {
        fun newInstance() = HomeContainerFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_container, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        setupViewPager()
        setupBottomNavigationView()
    }

    private fun setupViewPager() {
        binding.viewPagerHomeContainerFragment.apply {
            isUserInputEnabled = false
            offscreenPageLimit = 4
            adapter = HomePagerAdapter(this@HomeContainerFragment)
            currentItem = 0
        }
    }

    private fun setupBottomNavigationView() {
        addOnNavigationItemSelected()
    }

    private fun addOnNavigationItemSelected() {
        val viewPager = binding.viewPagerHomeContainerFragment
        binding.bottomNavigationHomeContainerFragment.setOnItemSelectedListener { item ->
            val currentItem = when (item.itemId) {
                R.id.profileFragment -> 0
                R.id.budgetListFragment -> 1
                R.id.ExpensesFragment -> 2
                R.id.IncomesFragment -> 3
                else -> -1
            }
            viewPager.currentItem = currentItem
            currentItem != -1
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}