package com.example.android2homework2.ui.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.android2homework2.ui.onBoard.OnBoardPagingFragment
import com.example.android2homework2.ui.onBoard.OnBoardPagingFragment.Companion.ARG_POSITION

class OnBoardAdapter(
    fragment: Fragment
) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int) = OnBoardPagingFragment().apply {
        arguments = Bundle().apply {
            putInt(ARG_POSITION, position)
        }
    }
}