package com.gabo.fragmenthomework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class SecondFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text = arguments?.getString(KEY)
        requireView().findViewById<TextView>(R.id.tv2).apply {
            setText(text)
            setOnClickListener {
                val text1 = "You came here from second Fragment"
                val name = "This is Third Fragment"
                requireActivity().supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragment_container, ThirdFragment.newInstance(text1, name))
                    addToBackStack(SecondFragment::class.java.name)
                    commit()
                }
            }
        }
    }

    companion object {
        const val KEY = "KEY"
        fun newInstance(text: String): SecondFragment {
            return SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(KEY, text)
                }
            }
        }
    }
}