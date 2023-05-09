package com.rylderoliveira.preferences

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.lifecycleScope
import com.rylderoliveira.preferences.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val dataStore: DataStore<Preferences> by preferencesDataStore(name = "myDataStorePreferences")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            buttonWrite.setOnClickListener {
                lifecycleScope.launch {
                    savePreferences()
                }
            }
            buttonRead.setOnClickListener {
                lifecycleScope.launch {
                    showPreferences()
                }
            }
            buttonClear.setOnClickListener {
                lifecycleScope.launch {
                    clearPreferences()
                }
            }
        }
    }

    private suspend fun clearPreferences() {
        dataStore.edit {
            it.clear()
        }
    }

    private suspend fun showPreferences() {
        val preferences = dataStore.data.first()
        val name = preferences[NAME_KEY] ?: "Name default"
        val age = preferences[AGE_KEY] ?: 0
        binding.textViewInfo.text = "$name\n$age"
    }

    private suspend fun savePreferences() {
        binding.apply {
            val name = editTextName.text.toString()
            val age = editTextAge.text.toString().toInt()
            dataStore.edit {
                it[NAME_KEY] = name
                it[AGE_KEY] = age
            }
        }
    }

    companion object {
        private val NAME_KEY = stringPreferencesKey("nameKey")
        private val AGE_KEY = intPreferencesKey("ageKey")
    }
}