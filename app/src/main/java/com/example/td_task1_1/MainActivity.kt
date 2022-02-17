package com.example.td_task1_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.td_task1_1.databinding.ActivityMainBinding


const val KEY_INTENT_NUMBER = "KEY_INTENT_NUMBER"

class MainActivity : AppCompatActivity() {
    companion object {
        private const val KEY_NUMBER = "KEY_NUMBER"
    }

    private val logTag = javaClass.name
    private var number = 0
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setViewNumber()

        binding.btSecondActivity.setOnClickListener {
            val intent = Intent(this, SquareActivity::class.java).apply {
                putExtra(KEY_INTENT_NUMBER, number)
            }
            startActivity(intent)
        }

        Log.i(logTag, "onCreate")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_NUMBER, number)

        Log.i(logTag, "onSaveInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        if (savedInstanceState.containsKey(KEY_NUMBER)) {
            number = savedInstanceState.getInt(KEY_NUMBER)
            increaseNumber()
            setViewNumber()
        } else {
            Log.e(logTag, "Null bundle from RestoreInstanceState")
        }
        Log.i(logTag, "onRestoreInstanceState")
    }

    private fun setViewNumber() {
        binding.number.text = number.toString()
    }

    private fun increaseNumber() {
        number += 1
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
