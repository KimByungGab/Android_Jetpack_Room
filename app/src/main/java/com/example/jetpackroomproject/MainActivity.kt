package com.example.jetpackroomproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackroomproject.databinding.ActivityMainBinding
import com.example.jetpackroomproject.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        val mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        setListener(activityMainBinding, mainViewModel)
        setViewModel(activityMainBinding, mainViewModel)
    }

    private fun setListener(activityMainBinding: ActivityMainBinding, mainViewModel: MainViewModel) {

        activityMainBinding.insertButton.setOnClickListener {
            val name = activityMainBinding.userNameEdittext.text.toString()
            val age = Integer.parseInt(activityMainBinding.userAgeEdittext.text.toString())
            val phone = activityMainBinding.userPhoneEdittext.text.toString()

            mainViewModel.insertDB(name, age, phone)
        }

        activityMainBinding.updateButton.setOnClickListener {
            val name = activityMainBinding.userNameEdittext.text.toString()
            val age = Integer.parseInt(activityMainBinding.userAgeEdittext.text.toString())
            val phone = activityMainBinding.userPhoneEdittext.text.toString()

            mainViewModel.updateDB(name, age, phone)
        }

        activityMainBinding.deleteButton.setOnClickListener {
            val name = activityMainBinding.userNameEdittext.text.toString()
            val age = Integer.parseInt(activityMainBinding.userAgeEdittext.text.toString())
            val phone = activityMainBinding.userPhoneEdittext.text.toString()

            mainViewModel.deleteDB(name, age, phone)
        }

        activityMainBinding.selectButtonByName.setOnClickListener {
            val name = activityMainBinding.userNameEdittext.text.toString()

            mainViewModel.selectDBByName(name)
        }
    }

    private fun setViewModel(activityMainBinding: ActivityMainBinding, mainViewModel: MainViewModel) {

        mainViewModel.currentValue.observe(this, Observer {
            activityMainBinding.userNameEdittext.setText(it.name)
            activityMainBinding.userAgeEdittext.setText(it.age.toString())
            activityMainBinding.userPhoneEdittext.setText(it.phone)
        })
    }
}