package com.example.archcomponents

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations

class MainVIewModel(context: Application) : AndroidViewModel(context) {

    companion object {
        private const val DEFAULT_NAME: String = "Escreva um nome"
    }

    //Here we declare our LiveData object
    val currentName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    /**
     * Here we updates the currentName LiveData object and post its value
     */
    fun updateName(newName: String) {
        if (newName.isNotBlank()) {
            currentName.postValue(newName)
        } else {
            currentName.postValue(DEFAULT_NAME)
        }
    }

}