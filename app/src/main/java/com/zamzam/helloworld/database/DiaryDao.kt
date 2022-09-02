package com.zamzam.helloworld.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DiaryDao {

    @Insert
    fun insert(diary: Diary)

    @Query("SELECT * FROM diary ORDER BY id DESC")
    fun getDiaries(): LiveData<List<Diary>>
}