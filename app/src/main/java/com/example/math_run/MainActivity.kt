package com.example.math_run

import android.app.ProgressDialog.show
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.*
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
            val answerA : RadioButton = findViewById(R.id.a)
            val answerB : RadioButton = findViewById(R.id.b)
            val answerC : RadioButton = findViewById(R.id.c)
            val answerD : RadioButton = findViewById(R.id.d)
            rollButton2.setOnClickListener {
                val varible1 = rollDice()
                val varible2 = rollDice2()
                val operator = function()
                show(varible1,varible2,operator)

                answerA.setOnClickListener{
                    if (operator == 1){
                        showclick()
                    }
                }
                answerB.setOnClickListener{
                    if (operator ==  3){
                        showclick()
                    }
                }
                answerC.setOnClickListener{
                    if (operator == 4){
                        showclick()
                    }
                }
                answerD.setOnClickListener{
                    if (operator == 2){
                        showclick()
                    }
                }

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
        val bTextView : TextView = findViewById(R.id.b)
        val cTextView : TextView = findViewById(R.id.c)
        val dTextView : TextView = findViewById(R.id.d)
        //resultTextView.text = k.toString()
        val k : Double
        val l : Double
        val w : Double
        val j : Double
        //val p : Boolean
        if (operator == 1){
            k = a.toDouble() + b.toDouble()
            l = 2.0 * a.toDouble() + b.toDouble()
            w = 9.0 + a.toDouble() + b.toDouble()
            j = 10.0 - a.toDouble() + b.toDouble()
            resultTextView.text = k.toString()
            bTextView.text = l.toString()
            cTextView.text = w.toString()
            dTextView.text = j.toString()
        }
        else if (operator == 2){
            k =  a.toDouble() * b
            l = 2.0 - a.toDouble() * b.toDouble()
            w = 9.0  * a.toDouble() * b.toDouble()
            j = 10.0 - a.toDouble() * b.toDouble()
            resultTextView.text = j.toString()
            bTextView.text = l.toString()
            cTextView.text = w.toString()
            dTextView.text = k.toString()
        }
        else if (operator == 3){
            k = b.toDouble() - a.toDouble()
            l = 2.0 - a.toDouble() - b.toDouble()
            w = 9.0 - a.toDouble() - b.toDouble()
            j = 10.0 - a.toDouble() - b.toDouble()
            resultTextView.text = l.toString()
            bTextView.text = k.toString()
            cTextView.text = w.toString()
            dTextView.text = j.toString()
        }
        else if (operator == 4){
            k = b.toDouble() / a.toDouble()
            l = 2.0 * a.toDouble() / b.toDouble()
            w = 9.0 / a.toDouble() * b.toDouble()
            j = 10.0 - a.toDouble() / b.toDouble()
            resultTextView.text = w.toString()
            bTextView.text = l.toString()
            cTextView.text = k.toString()
            dTextView.text = j.toString()
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
