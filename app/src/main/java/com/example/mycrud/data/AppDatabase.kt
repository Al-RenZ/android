package com.example.mycrud.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mycrud.data.dao.UserDao
import com.example.mycrud.data.entity.User

@Database (entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun UserDao(): UserDao

    companion object {
        private var instance: AppDatabase? = null

        fun getInstance(context:Context): AppDatabase{
            if (instance==null) {
                instance = Room.databaseBuilder(context, AppDatabase::class.java,"app-database")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return instance!!
        }
    }
}