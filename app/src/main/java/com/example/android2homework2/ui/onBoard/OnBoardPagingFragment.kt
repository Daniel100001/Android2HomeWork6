package com.example.android2homework2.ui.onBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialization()
        goToHomeFragment()
    }



    private fun initialization() = with(binding) {
        when (requireArguments().getInt(ARG_POSITION)) {
            0 -> {
                onTxt.text = "Очень удобный функционал"
                animationView.repeatCount = LottieDrawable.INFINITE
                animationView.repeatMode = LottieDrawable.REVERSE
                animationView.setAnimation(R.raw.anim1)
            }
            1 -> {
                onTxt.text= "Быстрый, качественный продукт"
                animationView.repeatCount = LottieDrawable.INFINITE
                animationView.repeatMode = LottieDrawable.REVERSE
                animationView.setAnimation(R.raw.anim)

            }
            2 ->{
                onTxt.text = "Куча функций и интересных фишек"
                animationView.repeatCount = LottieDrawable.INFINITE
                animationView.repeatMode = LottieDrawable.REVERSE
                animationView.setAnimation(R.raw.anim2)
                fragmentOnBoardPagingText.text = "Начать работу"

            }
        }
    }
    private fun goToHomeFragment() {
        binding.fragmentOnBoardPagingText.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_onBoardPagingPFragment_to_homeFragment)
        })
    }
}