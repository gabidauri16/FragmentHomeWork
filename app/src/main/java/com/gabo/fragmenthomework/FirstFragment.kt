package com.gabo.fragmenthomework


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import org.w3c.dom.Text


class FirstFragment : Fragment(R.layout.fragment_first) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val safeArgs:FirstFragmentArgs by navArgs()
        val text1 = safeArgs.arg1
        if (text1 != null){
            requireActivity().findViewById<TextView>(R.id.tv1).text = text1
        }
        requireActivity().findViewById<Button>(R.id.btn).setOnClickListener {

            val text = requireActivity().findViewById<EditText>(R.id.et).text.toString()

            val directions = FirstFragmentDirections.actionFirstFragmentToSecondFragment(text)
            findNavController().navigate(directions)
        }
    }
}