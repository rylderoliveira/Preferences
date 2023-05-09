package com.rylderoliveira.preferences

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.rylderoliveira.preferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val keyGenParameterSpec = MasterKeys.AES256_GCM_SPEC
        val mainKeyAlias = MasterKeys.getOrCreate(keyGenParameterSpec)
        sharedPreferences = EncryptedSharedPreferences.create(
            "mySharedPreferencesEncrypted",
            mainKeyAlias,
            applicationContext,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
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
        sharedPreferences.edit {
            clear()
        }
    }

    private fun showPreferences() {
        val name = sharedPreferences.getString("nameKey", "Name default")
        val age = sharedPreferences.getInt("ageKey", 0)
        binding.textViewInfo.text = "$name\n$age"
    }

    private fun savePreferences() {
        binding.apply {
            val name = editTextName.text.toString()
            val age = editTextAge.text.toString().toInt()
            sharedPreferences.edit {
                putString("nameKey", name)
                putInt("ageKey", age)
            }
        }
    }
}