package com.rylderoliveira.preferences

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.lifecycle.lifecycleScope
import com.rylderoliveira.preferences.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val dataStore: DataStore<Person> by dataStore(
        fileName = "personPrefs.pb",
        serializer = PersonSerializer,
    )

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
        dataStore.updateData {
            it.toBuilder().clear().build()
        }
    }

    private suspend fun showPreferences() {
        val name = dataStore.data.first().name
        val age = dataStore.data.first().age
        binding.textViewInfo.text = "$name\n$age"
    }

    private suspend fun savePreferences() {
        binding.apply {
            val name = editTextName.text.toString()
            val age = editTextAge.text.toString().toInt()
            dataStore.updateData {
                it.toBuilder()
                    .setName(name)
                    .setAge(age)
                    .build()
            }
        }
    }
}