package com.example.colormyviews


import android.R.attr.button
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.colormyviews.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


//bias: position of element along horizontal or vertical axis

class MainActivity : AppCompatActivity() {

    //This will be used to bind these boxes
    private lateinit var binding: ActivityMainBinding

    // Random integer used to create random color
    private lateinit var random: Random
    private lateinit var randomColor: Color

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Run set listeners on create
        setListeners()
    }

    private fun setListeners() {
        val clickableViews: List<View> =
            listOf(
                box_one_text,
                box_two_text,
                box_three_text,
                box_four_text,
                box_five_text,
                constraint_layout,
                red_button,
                yellow_button,
                green_button
            )

        //Iterates through all of the views in the clickableViews list and sets an on click listener to make that view colored when it is clicked.
        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }
    }

    private fun makeColored(boxView: View) {

        //https://stackoverflow.com/questions/14779259/get-background-color-of-a-layout
        val color = (boxView.background as ColorDrawable).color
        val TAG = "fun makeColored()"
        Log.d(TAG, "Color of "+ boxView + "background: $color")

        random = Random()

        val randomColor = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256))
        //boxView.setBackgroundColor(randomColor)

        //when is switch(case) for kotlin, color -1 is white, color 0 is transparent
        if (color == -1 || color == 0) {
            when (boxView.id) {

                // Boxes using Color class colors for background
                R.id.box_one_text -> boxView.setBackgroundColor(Color.DKGRAY)
                R.id.box_two_text -> boxView.setBackgroundColor(Color.GRAY)

                // Boxes using Android color resources for background
                R.id.box_three_text -> boxView.setBackgroundResource(android.R.color.holo_green_light)
                //R.id.box_four_text -> boxView.setBackgroundResource(android.R.color.holo_green_dark)
                R.id.box_five_text -> boxView.setBackgroundResource(android.R.color.holo_green_light)



                //Have had a lot of trouble assignming these background resources. I had to reassign the "style" of the buttons, not using
                //the original background color and style of the default button style, for some reason.
                // Boxes using custom colors for background
                R.id.red_button -> box_three_text.setBackgroundResource(R.color.my_red)
                R.id.yellow_button -> box_four_text.setBackgroundResource(android.R.color.holo_orange_light)

                //Pretty sure this version works, needs to be fixed a little bit though...
                R.id.green_button -> box_four_text.setBackgroundResource(R.color.my_green)

                // This is another option, using the drawable resource, but the app crashes if the textview is pressed after the button, not a great solution
                //R.id.green_button -> box_four_text.setBackgroundResource(R.drawable.rectangle_button)




                else -> boxView.setBackgroundColor(Color.LTGRAY)
            }
        } else {
            when (boxView.id) {

                // Boxes using Color class colors for background
                R.id.box_one_text -> boxView.setBackgroundColor(Color.WHITE)
                R.id.box_two_text -> boxView.setBackgroundColor(Color.WHITE)

                // Boxes using Android color resources for background
                R.id.box_three_text -> boxView.setBackgroundResource(android.R.color.white)
                R.id.box_four_text -> boxView.setBackgroundResource(android.R.color.white)
                R.id.box_five_text -> boxView.setBackgroundResource(android.R.color.white)

/*

                // Boxes using custom colors for background
                R.id.red_button -> box_three_text.setBackgroundResource(android.R.color.white)
                R.id.yellow_button -> box_four_text.setBackgroundResource(android.R.color.white)
                R.id.green_button -> box_five_text.setBackgroundResource(android.R.color.white)
*/


                else -> boxView.setBackgroundColor(Color.TRANSPARENT)
            }

        }

    }

}
