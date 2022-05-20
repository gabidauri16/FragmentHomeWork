package com.gabo.fragmenthomework

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class FirstFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text = arguments?.getString(KEY)
        requireActivity().findViewById<TextView>(R.id.tv1).apply {
            if (text != null) {
                setText(text)
                val fm = requireActivity().supportFragmentManager
                for (i in 0 until fm.backStackEntryCount) {
                    fm.popBackStack()// rogor vnqa ro argumentebis data arwameshalos?
                }
            } else {setText("Welcome To Fragment Uno")}
            setOnClickListener {
                val text1 = "this is Second Fragment. \n you came here from first fragment"
                requireActivity().supportFragmentManager.beginTransaction().apply {
                    replace(
                        R.id.fragment_container,
                        SecondFragment.newInstance(text1)
                    )//aq TAG ristvis undoda?
                    addToBackStack(FirstFragment::class.java.name)
                        .commit()
                }
            }
        }
    }

    companion object {
        const val KEY = "KEY"
        fun newInstance(text: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(KEY, text)
                }
            }
    }
}