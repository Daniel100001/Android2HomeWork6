package com.example.android2homework2.ui.onBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.airbnb.lottie.LottieDrawable
import com.example.android2homework2.R
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
        const val TEXT_ONBOARD1 = "Очень удобный функционал"
        const val TEXT_ONBOARD2 = "Быстрый, качественный продукт"
        const val TEXT_ONBOARD3 = "Куча функций и интересных фишек"
        const val BEGINNING_OF_WORK = "Начать работу"

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialization()
        setOnTextClickListener()
    }

    private fun initialization() = with(binding) {
        when (requireArguments().getInt(ARG_POSITION)) {
            0 -> {
                onTxt.text = TEXT_ONBOARD1
                animationView.repeatCount = LottieDrawable.INFINITE
                animationView.repeatMode = LottieDrawable.REVERSE
                animationView.setAnimation(R.raw.anim1)
            }
            1 -> {
                onTxt.text = TEXT_ONBOARD2
                animationView.repeatCount = LottieDrawable.INFINITE
                animationView.repeatMode = LottieDrawable.REVERSE
                animationView.setAnimation(R.raw.anim)

            }
            2 -> {
                onTxt.text = TEXT_ONBOARD3
                animationView.repeatCount = LottieDrawable.INFINITE
                animationView.repeatMode = LottieDrawable.REVERSE
                animationView.setAnimation(R.raw.anim2)
                fragmentOnBoardPagingText.text = BEGINNING_OF_WORK
            }
        }
    }

    private fun setOnTextClickListener() {
        binding.fragmentOnBoardPagingText.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_onBoardFragment_to_homeFragment)
        })
    }
}