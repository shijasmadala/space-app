package com.shijas.spaceapp.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.shijas.spaceapp.R
import com.shijas.spaceapp.databinding.FragmentNasaDetailBinding
import com.shijas.spaceapp.presentation.main.MainActivityViewModel


class NasaDetailFragment : Fragment(R.layout.fragment_nasa_detail) {

    private lateinit var binding: FragmentNasaDetailBinding
    private val mainViewModel by activityViewModels<MainActivityViewModel>()
    private val nasDetailItemAdapter by lazy { NasaItemDetailAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNasaDetailBinding.bind(view)
        nasDetailItemAdapter.submitList(mainViewModel.nasaData)
        setUpViewPager()
        setlisteners()
    }

    private fun setUpViewPager() {
        binding.viewPager.adapter = nasDetailItemAdapter
        binding.viewPager.setCurrentItem(mainViewModel.selectedIndex, false)

    }

    private fun setlisteners(){
        binding.floatingActionButton.setOnClickListener{
            findNavController().navigateUp()
        }
    }

}