package com.shijas.spaceapp.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.shijas.spaceapp.R
import com.shijas.spaceapp.databinding.FragmentHomeBinding
import com.shijas.spaceapp.presentation.main.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home),NasaItemAdapter.ClickListener {
    private lateinit var binding: FragmentHomeBinding
    private val mainViewModel by activityViewModels<MainActivityViewModel>()

    private val nasaItemAdapter by lazy {
        NasaItemAdapter(this).apply {
            submitList(mainViewModel.nasaData)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentHomeBinding.bind(view)

        binding.recyclerNasaData.adapter = nasaItemAdapter
    }

    override fun onClick(position: Int) {
        mainViewModel.selectedIndex = position
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToNasaDetailFragment())
    }
}