package com.example.android2homework2.ui.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.android2homework2.R
import com.example.android2homework2.databinding.FragmentHomeBinding
import com.example.android2homework2.utils.PreferenceHelper

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() {
        val preferenceHelper = PreferenceHelper()
        preferenceHelper.unit(requireContext())
        val check = preferenceHelper.saveBoolean

        if (check == false) {
            val navController = findNavController()
            val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)
            navGraph.setStartDestination(R.id.onBoardFragment)
            navController.graph = navGraph
        }
    }
}