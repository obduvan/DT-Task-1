package com.example.td_task1_1

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.td_task1_1.databinding.ActivityMainBinding
import java.lang.RuntimeException


const val KEY_INTENT_NUMBER = "KEY_INTENT_NUMBER"

class MainActivity : AppCompatActivity() {

    companion object {
        private const val KEY_NUMBER = "KEY_NUMBER"
    }

    private var number = 0
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.number.text = number.toString()
        setContentView(binding.root)

        binding.btSecondActivity.setOnClickListener {
            val intent = Intent(this, SquareActivity::class.java).apply {
                putExtra(KEY_INTENT_NUMBER, number)
            }
            startActivity(intent)
        }

        Log.e(javaClass.name, "onCreate")

    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        increaseNumber()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt(KEY_NUMBER, number)

        Log.e(javaClass.name, "onSaveInstanceState")

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        if (savedInstanceState.containsKey(KEY_NUMBER)) {
            number = savedInstanceState.getInt(KEY_NUMBER)
            setViewNumber()
        } else {
            Log.e(javaClass.name, "Null bundle from RestoreInstanceState")
        }

        Log.e(javaClass.name, "onRestoreInstanceState")

    }

    private fun setViewNumber() {
        binding.number.text = number.toString()
    }

    private fun increaseNumber() {
        number += 1
        setViewNumber()
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
