package com.example.mobileprogrammingproject.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="user_table")
data class User (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val username: String,
    var score: Int,
    var numbersRepetition: Boolean,
    var bonus: Boolean,
    var scale4: Boolean,
    var scale5: Boolean,
    var tris: Boolean,
    var quater: Boolean,
    var full: Boolean,
    var yahtzee: Boolean,
    var chance: Boolean)