package com.coin.roomrelations.database

import androidx.room.*
import com.coin.roomrelations.database.entities.Director
import com.coin.roomrelations.database.entities.School
import com.coin.roomrelations.database.relations.SchoolAndDirector


@Dao
interface SchoolDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertSchool(school: School)

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertDirector(director: Director)

  @Transaction
  @Query("SELECT * From school where schoolName = :schoolName")
  suspend fun getSchoolAndDirectorWithSchoolName(schoolName: String) : List<SchoolAndDirector>

}