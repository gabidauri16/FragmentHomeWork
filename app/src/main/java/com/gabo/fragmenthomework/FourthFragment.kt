package com.gabo.fragmenthomework

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class FourthFragment : Fragment(R.layout.fragment_fourth) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val safeArgs: FourthFragmentArgs by navArgs()
        val argument1 = safeArgs.arg1
        val argument2 = safeArgs.arg2
        if (argument1 != null){
            requireActivity().findViewById<TextView>(R.id.tv4).text = argument1
        } else {
            requireActivity().findViewById<TextView>(R.id.tv4).text = argument2

        }
        requireActivity().findViewById<TextView>(R.id.tv4).setOnClickListener {
            val text = "you came here from Fourth Fragment"
            val direction = FourthFragmentDirections.actionFourthFragmentToFirstFragment(text)
            findNavController().navigate(direction)
        }
    }
}