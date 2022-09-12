package com.example.bonapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PengeluaranData::class], version = 1)
abstract class DatabasePengeluaran : RoomDatabase() {

    companion object {

        @Volatile
        private var instance: DatabasePengeluaran? = null

        fun getDatabase(context: Context) : DatabasePengeluaran {
            if (instance == null) {
                synchronized(this) {
                    instance = buildDatabase(context)
                }
            }
            return instance!!
        }

        private fun buildDatabase(context: Context): DatabasePengeluaran? {
            return Room.databaseBuilder(
                context.applicationContext, DatabasePengeluaran::class.java, "dbpengeluaran.db"
            ).build()
        }
    }

}