package com.example.math_run

import android.app.ProgressDialog.show
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.roundToLong

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        //val rollButton2: Button = findViewById(R.id.Next)
        rollButton.setOnClickListener {
            setContentView(R.layout.screentwo)
            val rollButton2: Button = findViewById(R.id.Next)
            rollButton2.setOnClickListener {
                val varible1 = rollDice()
                val varible2 = rollDice2()
                val operator = function()
                show(varible1,varible2,operator)
                showclick()
                val resultTextView: TextView = findViewById(R.id.textView3)
                resultTextView.text = operator.toString()
            }
            //dice()
        }


    }
    private fun rollDice2() : Int{
        val dice = Dice(99)
        val diceRoll = dice.roll()
        val resultTextView: TextView = findViewById(R.id.textView3)
        resultTextView.text = diceRoll.toString()
        return diceRoll
    }
    private fun rollDice() : Int {
        val dice = Dice(99)
        val diceRoll = dice.roll()
        val resultTextView: TextView = findViewById(R.id.textView6)
        resultTextView.text = diceRoll.toString()
        return diceRoll
    }

    private fun show(a : Int, b : Int, operator : Int){
        val resultTextView: TextView = findViewById(R.id.a)
        //resultTextView.text = k.toString()
        val k : Double
        //val p : Boolean
        if (operator == 1){
            k = a.toDouble() + b.toDouble()
            resultTextView.text = k.toString()
        }
        else if (operator == 2){
            k =  a.toDouble() * b
            resultTextView.text = k.toString()
        }
        else if (operator == 3){
            k = a.toDouble() - b
            resultTextView.text = k.toString()
        }
        else if (operator == 4){
            k = a.toDouble() / b.toDouble()
            resultTextView.text = k.toString()
        }
    }

    private fun function() : Int{
        val dice = Dice(4)
        val op = dice.roll()
        val resultTextView : TextView = findViewById(R.id.textView5)

        if (op == 1){
            resultTextView.text = "+"
        }
        else if (op == 2){
            resultTextView.text = "*"
        }
        else if (op == 3){
            resultTextView.text = "-"
        }
        else if (op == 4){
            resultTextView.text = "/"
        }
        return op
    }
    private fun showclick(){
        val toast = Toast.makeText(this, "Correct", Toast.LENGTH_SHORT)
        toast.show()
    }
}
class Dice(val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}
