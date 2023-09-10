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

        val rand1 = generateRandomNumber()
        val rand2 = generateRandomNumber()

        txtNum1.text = rand1.toString()
        txtNum2.text = rand2.toString()

        val txtAnswer = view.findViewById<TextView>(R.id.txtAnswer)

        var result = txtNum1.text.toString().toInt() + txtNum2.text.toString().toInt()


        if (arguments != null) {
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            val txtTurn = view.findViewById<TextView>(R.id.txtViewName)
            txtTurn.text = "$playerName's Turn"

        }
        val btnAnswer = view.findViewById<Button>(R.id.btnAnswer)

        btnAnswer.setOnClickListener {
            if(txtAnswer.text.toString() == result.toString()){

                correctAnswer += 1

                txtNum1.text = generateRandomNumber().toString()
                txtNum2.text = generateRandomNumber().toString()
                result = txtNum1.text.toString().toInt() + txtNum2.text.toString().toInt()
                txtAnswer.text = ""
            }
            else{
                val actionRes = GameFragmentDirections.actionResultFragment(correctAnswer)
                Navigation.findNavController(it).navigate(actionRes)
            }
        }
    }
    private fun generateRandomNumber(): Int {
        return (1..100).random() // Generate random numbers between 1 and 10 (adjust as needed)
    }
}