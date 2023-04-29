package com.example.android2homework2.ui.fragments.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android2homework2.App
import com.example.android2homework2.R
import com.example.android2homework2.databinding.FragmentNoteAppBinding
import com.example.android2homework2.ui.adapters.NoteAppAdapter

class NoteAppFragment : Fragment() {

    private lateinit var binding: FragmentNoteAppBinding
    private val noteAppAdapter = NoteAppAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteAppBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setUpListeners()
        setUpData()
    }

    private fun initialize() {
        binding.recyclerViewFragmentNote.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = noteAppAdapter
            }
    }

    private fun setUpListeners() {
        binding.buttonAddNote.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_note_app_to_noteAppDetailFragment)
        }

        var grid = true

        binding.imageChangeLayoutManagerFragmentHome.setOnClickListener {
            if (grid) {
                binding.recyclerViewFragmentNote.layoutManager =
                    GridLayoutManager(requireContext(), 2)
                binding.imageChangeLayoutManagerFragmentHome.setImageResource(R.drawable.linear_them)
                grid = false
            } else {
                binding.recyclerViewFragmentNote.layoutManager =
                    LinearLayoutManager(requireContext())
                binding.imageChangeLayoutManagerFragmentHome.setImageResource(R.drawable.grid_them)
                grid = true
            }
        }
    }

    private fun setUpData() {
        App.getInstate()?.noteDao()?.getAll()?.observe(viewLifecycleOwner) {
            noteAppAdapter.setList(it)
        }
    }
}

