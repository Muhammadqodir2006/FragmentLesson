package com.example.lessonfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lessonfragment.databinding.FragmentSecondBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FragmentSecond : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSecondBinding.inflate(inflater, container, false)
        parentFragmentManager.beginTransaction()
            .add(R.id.fragment_second_fragment_container, BlankFragment1())
            .commit()
        binding.button2.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_second_fragment_container, BlankFragment1())
                .commit()
        }
        binding.button.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_second_fragment_container, BlankFragment2())
                .commit()
        }
        return binding.root
    }
}