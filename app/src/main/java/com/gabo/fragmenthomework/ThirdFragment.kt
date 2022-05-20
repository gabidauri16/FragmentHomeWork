package com.gabo.fragmenthomework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ThirdFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text1 = arguments?.getString(KEY1)
        val text2 = arguments?.getString(KEY2)
        requireActivity().findViewById<TextView>(R.id.tv3).apply {
          text = text1
          setOnClickListener {
              val text = "you have clicked on text1 \n\n Welcome to fragment Quadro"
              requireActivity().supportFragmentManager.beginTransaction().apply {
                  replace(R.id.fragment_container, FourthFragment.newInstance(text))
                  addToBackStack(SecondFragment::class.java.name)
                      .commit()
              }
          }
        }
        requireActivity().findViewById<TextView>(R.id.tv33).apply {
            text = text2
            setOnClickListener {
                val text = "you have clicked on text2 \n \n This is fragment Quadro"
                requireActivity().supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragment_container, FourthFragment.newInstance(text))
                    addToBackStack(ThirdFragment::class.java.name)
                        .commit()
                }
            }
        }

    }
    companion object {
        const val KEY1 = "KEY1"
        const val KEY2 = "KEY2"
        fun newInstance(text: String, name: String) =
            ThirdFragment().apply {
                arguments = Bundle().apply {
                    putString(KEY1, text)
                    putString(KEY2, name)
                }
            }
    }
}