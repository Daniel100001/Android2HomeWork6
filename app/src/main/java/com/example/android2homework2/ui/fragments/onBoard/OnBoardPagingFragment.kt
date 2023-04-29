package com.example.android2homework2.ui.fragments.onBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.android2homework2.R
import com.example.android2homework2.databinding.FragmentOnBoardPagingBinding
import com.example.android2homework2.utils.PreferenceHelper

class OnBoardPagingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardPagingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardPagingBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        const val ARG_POSITION = "onBoard"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialization()
        setUpListener()
    }

    private fun initialization() = with(binding) {
        when (requireArguments().getInt(ARG_POSITION)) {
            0 -> {
                onTxt.text = getString(R.string.OnBoardPagingText)
                animationView.setAnimation(R.raw.anim1)
            }
            1 -> {
                onTxt.text = getString(R.string.OnBoardText2)
                animationView.setAnimation(R.raw.anim)
            }
            2 -> {
                animationView.setAnimation(R.raw.anim2)
                fragmentOnBoardPagingText.text = getString(R.string.Beginning_of_work)
            }
        }
    }

    private fun setUpListener() {
        binding.fragmentOnBoardPagingText.setOnClickListener {
            val preferenceHelper = PreferenceHelper()
            preferenceHelper.unit(requireContext())
            preferenceHelper.saveBoolean = true
            findNavController().navigate(R.id.action_onBoardFragment_to_singUpFragment)
        }
    }
}
