package com.coin.roomrelations.database

import androidx.room.*
import com.coin.roomrelations.database.entities.Director
import com.coin.roomrelations.database.entities.School
import com.coin.roomrelations.database.entities.Student
import com.coin.roomrelations.database.relations.SchoolAndDirector
import com.coin.roomrelations.database.relations.SchoolsWithStudent


@Dao
interface SchoolDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertSchool(school: School)

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertDirector(director: Director)

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertStudent(student: Student)

  @Transaction
  @Query("SELECT * From school where schoolName = :schoolName")
  suspend fun getSchoolAndDirectorWithSchoolName(schoolName: String) : List<SchoolAndDirector>

  @Transaction
  @Query("SELECT * From school where schoolName = :schoolName")
  suspend fun getSchoolWithStudents(schoolName:String):List<SchoolsWithStudent>
}