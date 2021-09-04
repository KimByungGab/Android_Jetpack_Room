package com.example.jetpackroomproject.repository.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "T_USER")
data class User(
    var name: String,
    var age: Int,
    var phone: String
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}
