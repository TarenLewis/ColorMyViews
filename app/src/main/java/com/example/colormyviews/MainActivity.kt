package com.example.colormyviews


import android.R.attr.button
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.colormyviews.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


//bias: position of element along horizontal or vertical axis

class MainActivity : AppCompatActivity() {

    //This will be used to bind these boxes
    private lateinit var binding : ActivityMainBinding

    // Status of boxes, to keep track of whether they are currently colored or not.
    private var boxOne_colored: Boolean = false
    private var boxTwo_colored: Boolean = false
    private var boxThree_colored: Boolean = false
    private var boxFour_colored: Boolean = false
    private var boxFive_colored: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Run set listeners on create
        setListeners()
    }

    private fun setListeners(){
        val clickableViews: List<View> =
            listOf(box_one_text, box_two_text, box_three_text, box_four_text, box_five_text, constraint_layout)

        //Iterates through all of the views in the clickableViews list and sets an on click listener to make that view colored when it is clicked.
        for (item in clickableViews){
            item.setOnClickListener{makeColored(it)}
        }
    }

    private fun makeColored(boxView: View) {

        //https://stackoverflow.com/questions/14779259/get-background-color-of-a-layout
        val color = (boxView.background as ColorDrawable).color.toString()

        //Toast
        //https://developer.android.com/guide/topics/ui/notifiers/toasts
        val duration = Toast.LENGTH_SHORT
        val toast = Toast.makeText(applicationContext, color, duration)
        toast.show()

        //when is switch(case) for kotlin
        if(color == "-1" || color == "0"){
            when (boxView.id) {

                // Boxes using Color class colors for background
                R.id.box_one_text   -> boxView.setBackgroundColor(Color.DKGRAY)
                R.id.box_two_text   -> boxView.setBackgroundColor(Color.GRAY)

                // Boxes using Android color resources for background
                R.id.box_three_text -> boxView.setBackgroundResource(android.R.color.holo_green_light)
                R.id.box_four_text  -> boxView.setBackgroundResource(android.R.color.holo_green_dark)
                R.id.box_five_text  -> boxView.setBackgroundResource(android.R.color.holo_green_light)

                else -> boxView.setBackgroundColor(Color.LTGRAY)
            }
        }


    }

}
