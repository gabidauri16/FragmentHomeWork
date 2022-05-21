package com.gabo.fragmenthomework

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class ThirdFragment : Fragment(R.layout.fragment_third) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().findViewById<TextView>(R.id.tv3).setOnClickListener {
            val text1 = "you have clicked text1"
            val direction = ThirdFragmentDirections.actionThirdFragmentToFourthFragment(text1)
            findNavController().navigate(direction)
        }
        requireActivity().findViewById<TextView>(R.id.tv33).setOnClickListener {
            val text2 = "you have clicked text2"
            val direction = ThirdFragmentDirections.actionThirdFragmentToFourthFragment(text2)
            findNavController().navigate(direction)
        }
    }

}