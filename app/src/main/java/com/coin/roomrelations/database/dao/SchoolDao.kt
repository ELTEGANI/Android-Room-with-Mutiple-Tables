package com.coin.roomrelations.database.dao

import androidx.room.*
import com.coin.roomrelations.database.entities.Director
import com.coin.roomrelations.database.entities.School
import com.coin.roomrelations.database.entities.Student
import com.coin.roomrelations.database.entities.Subject
import com.coin.roomrelations.database.relations.*


@Dao
interface SchoolDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertSchool(school: School)

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertDirector(director: Director)

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertStudent(student: Student)

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertSubject(subject: Subject)

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertStudentSubjectCrossRef(crossRef:StudentSubjectWithCrossRef)

  @Transaction
  @Query("SELECT * From school where schoolName = :schoolName")
  suspend fun getSchoolAndDirectorWithSchoolName(schoolName: String) : List<SchoolAndDirector>

  @Transaction
  @Query("SELECT * FROM school WHERE schoolName = :schoolName")
  suspend fun getSchoolWithStudents(schoolName: String): List<SchoolsWithStudent>

  @Transaction
  @Query("SELECT * From subject where subjectName = :subjectName")
  suspend fun getStudentOfSubject(subjectName:String):List<SubjectWithStudent>

  @Transaction
  @Query("SELECT * From student where studentName = :studentName")
  suspend fun getSubjectOfStudent(studentName:String):List<StudentWithSubjects>


}