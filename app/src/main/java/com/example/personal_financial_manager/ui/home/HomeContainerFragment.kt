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

class HomeContainerFragment : Fragment() {

    private var _binding: FragmentHomeContainerBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = HomeContainerFragment()
    }

    private val viewModel: HomeContainerViewModel by viewModels()

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
        binding.bottomNavigationHomeContainerFragment.setOnItemSelectedListener  {
            when (it.itemId) {
                R.id.profileFragment -> {
                    viewPager.currentItem = 0
                    return@setOnItemSelectedListener true
                }
                R.id.budgetListFragment -> {
                    viewPager.currentItem = 1
                    return@setOnItemSelectedListener  true
                }
                R.id.ExpensesFragment -> {
                    viewPager.currentItem = 2
                    return@setOnItemSelectedListener  true
                }
                R.id.IncomesFragment -> {
                    viewPager.currentItem = 3
                    return@setOnItemSelectedListener  true
                }
            }
            false
        }
    }
}