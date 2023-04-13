package com.example.android2homework2.ui.onBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android2homework2.databinding.FragmentOnBoardPagingBinding


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
    }

    private fun initialization() = with(binding) {
        when (requireArguments().getInt(ARG_POSITION)) {
            0 -> {
                onTxt.text = "First Fragment"
            }
            1 -> {
                onTxt.text= "Second Fragment"

            }
            2 ->{
                onTxt.text = "Third Fragment"

            }
        }
    }
}