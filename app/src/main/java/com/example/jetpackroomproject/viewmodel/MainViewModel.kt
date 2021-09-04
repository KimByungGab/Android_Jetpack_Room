package com.example.jetpackroomproject.viewmodel

import android.app.Application
import android.os.Message
import androidx.lifecycle.*
import com.example.jetpackroomproject.repository.UserRepository
import com.example.jetpackroomproject.repository.room.UserDatabase
import com.example.jetpackroomproject.repository.room.entity.User
import java.util.logging.Handler

public class MainViewModel(application: Application): AndroidViewModel(application) {
    public val _currentValue = MutableLiveData<User>()
    private val repository by lazy {
        UserRepository(application)
    }

    init {
        _currentValue.value = User("", 0, "")
    }

    val currentValue: LiveData<User>
        get() {
            return _currentValue
        }

    fun insertDB(name: String, age: Int, phone: String) {

        repository.insertDB(name, age, phone)
    }

    fun updateDB(name: String, age: Int, phone: String) {
        repository.updateDB(name, age, phone)
    }

    fun deleteDB(name: String, age: Int, phone: String) {
        repository.deleteDB(name, age, phone)
    }

    fun selectDBByName(name: String) {
//        val data = repository.selectDBByName(name)
//        _currentValue.value = data
        val handler = android.os.Handler()
        Thread {
            val data = repository.selectDBByName(name)
            handler.post {
                _currentValue.value = data
            }
        }.start()
    }
}