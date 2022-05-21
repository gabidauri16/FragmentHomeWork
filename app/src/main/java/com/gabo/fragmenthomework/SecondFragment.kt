package com.gabo.fragmenthomework

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class SecondFragment : Fragment(R.layout.fragment_second) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val safeArgs: SecondFragmentArgs by navArgs()
        val arg2 = safeArgs.arg2

        requireActivity().findViewById<TextView>(R.id.tv2).apply{
            text = arg2
            setOnClickListener {
                findNavController().navigate(R.id.thirdFragment)
            }
        }
        requireActivity().findViewById<Button>(R.id.btn_log_out).setOnClickListener {
            findNavController().navigate(R.id.firstFragment)
        }
    }
}