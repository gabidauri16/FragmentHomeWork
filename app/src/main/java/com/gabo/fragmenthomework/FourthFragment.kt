package com.gabo.fragmenthomework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class FourthFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_fourth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text = arguments?.getString(KEY)
        requireActivity().findViewById<TextView>(R.id.tv4).apply {
            setText(text)
            setOnClickListener {
                val textToFirst = "you came here from Fragment Four \n Welcome to First Fragment again"
                requireActivity().supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragment_container, FirstFragment.newInstance(textToFirst))
                        .commit()
                }
            }
        }
    }
    companion object {
        const val KEY = "KEY"
        fun newInstance(text: String) =
            FourthFragment().apply {
                arguments = Bundle().apply {
                    putString(KEY, text)
                }
            }
    }
}