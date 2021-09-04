package com.example.jetpackroomproject.repository.room

import androidx.room.*
import com.example.jetpackroomproject.repository.room.entity.User

@Dao
interface UserDAO {

    @Insert
    fun insert(user: User)

    @Update
    fun update(user: User)

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM T_USER WHERE name=:name")
    fun getUserByName(name: String) : User
}