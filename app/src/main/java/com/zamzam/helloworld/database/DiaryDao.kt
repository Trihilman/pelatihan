package com.zamzam.helloworld.database

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface DiaryDao {

    @Insert
    fun insert(diary: Diary)
}