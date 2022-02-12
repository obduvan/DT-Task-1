package com.example.td_task1_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.td_task1_1.databinding.ActivitySquareBinding

class SquareActivity : AppCompatActivity() {

    companion object {
        private const val KEY_SQUARE_NUMBER = "KEY_SQUARE_NUMBER"
    }

    private lateinit var binding: ActivitySquareBinding

    private var squareNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySquareBinding.inflate(layoutInflater)

        val num = intent.getIntExtra(KEY_INTENT_NUMBER, 0)
        squareNumber = num * num

        setViewNumber()
        setContentView(binding.root)
    }

    private fun setViewNumber() {
        binding.squareNumberId.text = squareNumber.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt(KEY_SQUARE_NUMBER, squareNumber)

        Log.e(javaClass.name, "onSaveInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        if (savedInstanceState.containsKey(KEY_SQUARE_NUMBER)) {
            squareNumber = savedInstanceState.getInt(KEY_SQUARE_NUMBER)
            setViewNumber()
        } else {
            Log.e(javaClass.name, "Null bundle from RestoreInstanceState")
        }

        Log.e(javaClass.name, "onRestoreInstanceState")
    }

    override fun onResume() {
        super.onResume()
        Log.e(javaClass.name, "Resume")
    }

    override fun onPause() {
        super.onPause()
        Log.e(javaClass.name, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e(javaClass.name, "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e(javaClass.name, "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(javaClass.name, "onDestroy")
    }
}