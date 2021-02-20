package com.coin.roomrelations.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.coin.roomrelations.database.dao.SchoolDao
import com.coin.roomrelations.database.entities.Director
import com.coin.roomrelations.database.entities.School
import com.coin.roomrelations.database.entities.Student
import com.coin.roomrelations.database.entities.Subject
import com.coin.roomrelations.database.relations.StudentSubjectWithCrossRef


@Database(entities = [
    School::class,
    Student::class,
    Subject::class,
    Director::class,
    StudentSubjectWithCrossRef::class
],version = 1)

abstract class SchoolDataBase : RoomDatabase(){
    abstract val schoolDao:SchoolDao
    companion object{
       @Volatile
       private var INSTANCE:SchoolDataBase? = null

        fun getInstance(context: Context):SchoolDataBase{
            synchronized(this){
                return INSTANCE?:Room.databaseBuilder(
                    context.applicationContext,
                    SchoolDataBase::class.java,
                    "school_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }

}
