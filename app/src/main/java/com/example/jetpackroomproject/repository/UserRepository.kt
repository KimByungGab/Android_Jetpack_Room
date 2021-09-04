package com.example.jetpackroomproject.repository

import android.app.Application
import android.os.Message
import com.example.jetpackroomproject.repository.room.UserDatabase
import com.example.jetpackroomproject.repository.room.entity.User
import com.example.jetpackroomproject.viewmodel.MainViewModel

class UserRepository(application: Application) {

    private val userDB by lazy {
        UserDatabase.getInstance(application)
    }

    fun insertDB(name: String, age: Int, phone: String) {

        val data = User(name, age, phone)

        Thread {
            userDB!!.userDao().insert(data)
        }.start()
    }

    fun updateDB(name: String, age: Int, phone: String) {
        val data = User(name, age, phone)

        Thread {
            userDB!!.userDao().update(data)
        }.start()
    }

    fun deleteDB(name: String, age: Int, phone: String) {
        val data = User(name, age, phone)

        Thread {
            userDB!!.userDao().delete(data)
        }.start()
    }

    fun selectDBByName(name: String): User {

        return userDB!!.userDao().getUserByName(name)
    }
}