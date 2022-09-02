package com.zamzam.helloworld.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "diary")
data class Diary(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var judul: String,
    var diary: String,
    var tanggal: Long = System.currentTimeMillis(),
)