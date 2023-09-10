package com.example.a160420110_anmp_week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation

class GameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var correctAnswer = 0
        val txtNum1 = view.findViewById<TextView>(R.id.num1TextView)
        val txtNum2 = view.findViewById<TextView>(R.id.num2TextView)

        val rand1 = (0..100).shuffled().last()
        val rand2 = (0..100).shuffled().last()

        txtNum1.text = rand1.toString()
        txtNum2.text = rand2.toString()

        val txtAnswer = view.findViewById<TextView>(R.id.txtAnswer)

        val result = txtNum1.text.toString().toInt() + txtNum2.text.toString().toInt()


        if (arguments != null) {
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            val txtTurn = view.findViewById<TextView>(R.id.txtViewName)
            txtTurn.text = "$playerName's Turn"

        }
        val btnAnswer = view.findViewById<Button>(R.id.btnAnswer)

        btnAnswer.setOnClickListener {
            if(txtAnswer.text.toString() == result.toString()){
                correctAnswer += 1

                txtNum1.text = (0..100).shuffled().last().toString()
                txtNum2.text = (0..100).shuffled().last().toString()
                txtAnswer.text = ""
            }
            else{
                val actionRes = GameFragmentDirections.actionResultFragment(correctAnswer)
                Navigation.findNavController(it).navigate(actionRes)
            }
        }
    }
}