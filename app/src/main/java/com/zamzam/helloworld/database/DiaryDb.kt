package com.zamzam.helloworld.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Diary::class], version = 1)
abstract class DiaryDb : RoomDatabase() {

    abstract val dao: DiaryDao

    companion object {

        @Volatile
        private var INSTANCE: DiaryDb? = null

        fun getInstanse(context: Context): DiaryDb {
            synchronized(this) {
                var instant = INSTANCE
                if (instant == null) {
                    instant = Room.databaseBuilder(
                        context.applicationContext,
                        DiaryDb::class.java,
                        "diary.db"
                    ).build()
                    INSTANCE = instant
                }
                return instant
            }
        }
    }
}