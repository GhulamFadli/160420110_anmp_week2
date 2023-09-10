package com.example.a160420110_anmp_week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation


class ResultFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnBack = view.findViewById<Button>(R.id.btnHome)
        val correctRes = ResultFragmentArgs.fromBundle(requireArguments()).correctAnswer
        val txtRes = view.findViewById<TextView>(R.id.txtScore)
        txtRes.text = "Your score is '$correctRes'"

        btnBack.setOnClickListener {
            val actionHome = ResultFragmentDirections.actionMainFragment()
            Navigation.findNavController(it).navigate(actionHome)
        }
    }
}