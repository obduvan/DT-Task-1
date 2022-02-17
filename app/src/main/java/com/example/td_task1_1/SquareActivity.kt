package com.example.td_task1_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.td_task1_1.databinding.ActivitySquareBinding

class SquareActivity : AppCompatActivity() {
    companion object {
        private const val KEY_SQUARE_NUMBER = "KEY_SQUARE_NUMBER"
    }

    private val logTag = javaClass.name
    private lateinit var binding: ActivitySquareBinding
    private var squareNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySquareBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val num = intent.getIntExtra(KEY_INTENT_NUMBER, 0)
        squareNumber = num * num
        setViewNumber()

        Log.i(logTag, "onCreate")
    }

    private fun setViewNumber() {
        binding.squareNumberId.text = squareNumber.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_SQUARE_NUMBER, squareNumber)

        Log.i(logTag, "onSaveInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        if (savedInstanceState.containsKey(KEY_SQUARE_NUMBER)) {
            squareNumber = savedInstanceState.getInt(KEY_SQUARE_NUMBER)
            setViewNumber()
        } else {
            Log.e(logTag, "Null bundle from RestoreInstanceState")
        }
        Log.i(logTag, "onRestoreInstanceState")
    }

    override fun onResume() {
        super.onResume()
        Log.i(logTag, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(logTag, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(logTag, "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(logTag, "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(logTag, "onDestroy")
    }
}