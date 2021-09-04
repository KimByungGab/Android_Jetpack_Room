package com.example.jetpackroomproject.repository.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.jetpackroomproject.repository.room.entity.User

@Database(entities = [User::class], version = 1)
// @Database(entities = arrayOf(User::class, Student::class), version = 1)      // 복수개의 엔티티를 가져야 할 때
abstract class UserDatabase: RoomDatabase() {
    abstract fun userDao(): UserDAO

    companion object {
        private var instance: UserDatabase? = null

        @Synchronized
        fun getInstance(context: Context): UserDatabase? {
            if (instance == null) {
                synchronized(UserDatabase::class) {
                    instance = Room.databaseBuilder(context.applicationContext, UserDatabase::class.java, "USER_DB.db").build()
                }
            }

            return instance
        }
    }
}