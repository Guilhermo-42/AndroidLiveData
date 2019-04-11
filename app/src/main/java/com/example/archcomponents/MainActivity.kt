package com.example.archcomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), LifecycleOwner {

    private val viewModel: MainVIewModel by lazy {
        ViewModelProviders.of(this).get(MainVIewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val observer: Observer<String> = Observer { newName ->
//            nameTextView.text = newName
//            nameEditText.text.clear()
//        }
//
//        viewModel.currentName.observe(this, observer)

        viewModel.currentName.observe(this, Observer { name ->
            updateUi(name)
        })

        setListeners()
    }

    private fun setListeners() {
        btnSubmit.setOnClickListener {
            val newName = nameEditText.text.toString()
            viewModel.updateName(newName)
        }
    }

    private fun updateUi(newName: String) {
        nameTextView.text = newName
        nameEditText.text.clear()
    }
}
