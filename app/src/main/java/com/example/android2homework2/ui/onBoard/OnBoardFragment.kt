package com.example.android2homework2.ui.onBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.android2homework2.R
import com.example.android2homework2.databinding.FragmentOnBoardBinding
import com.example.android2homework2.ui.adapters.OnBoardAdapter

class OnBoardFragment : Fragment() {


    private lateinit var binding: FragmentOnBoardBinding
    private var text: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        text= view.findViewById(R.id.next_txt)
        intilialize()
        clickButton()
    }


    private fun intilialize() {
        binding.viewPager.adapter = OnBoardAdapter(this@OnBoardFragment)
    }
    private fun clickButton() = with(binding.viewPager) {
        binding.nextTxt.setOnClickListener(){
            if (currentItem < 2){
                setCurrentItem(currentItem +1,true)
            }
        }
    }

}