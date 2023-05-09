package com.rylderoliveira.preferences

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.orhanobut.hawk.Hawk
import com.rylderoliveira.preferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Hawk.init(applicationContext).build()
        binding.apply {
            buttonWrite.setOnClickListener {
                savePreferences()
            }
            buttonRead.setOnClickListener {
                showPreferences()
            }
            buttonClear.setOnClickListener {
                clearPreferences()
            }
        }
    }

    private fun clearPreferences() {
        Hawk.deleteAll()
    }

    private fun showPreferences() {
        val name = Hawk.get("nameKey", "Name default")
        val age = Hawk.get("ageKey", 0)
        binding.textViewInfo.text = "$name\n$age"
    }

    private fun savePreferences() {
        binding.apply {
            val name = editTextName.text.toString()
            val age = editTextAge.text.toString().toInt()
            Hawk.put("nameKey", name)
            Hawk.put("ageKey", age)
        }
    }
}