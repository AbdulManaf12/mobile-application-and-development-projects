package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    private lateinit var dice : Dice

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.dice = Dice(6)
    }
    fun Roll(view: View){
        val diceRoll = dice.roll()
        val img = findViewById<ImageView>(R.id.result)
        when(diceRoll) {
            1 -> img.setImageResource(R.drawable.dice_1)
            2 -> img.setImageResource(R.drawable.dice_2)
            3 -> img.setImageResource(R.drawable.dice_3)
            4 -> img.setImageResource(R.drawable.dice_4)
            5 -> img.setImageResource(R.drawable.dice_5)
            6 -> img.setImageResource(R.drawable.dice_6)
        }
    }
}
class Dice(val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}