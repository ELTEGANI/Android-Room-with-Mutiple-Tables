package com.coin.roomrelations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.coin.roomrelations.database.SchoolDataBase
import com.coin.roomrelations.database.entities.Director
import com.coin.roomrelations.database.entities.School
import com.coin.roomrelations.database.entities.Student
import com.coin.roomrelations.database.entities.Subject
import com.coin.roomrelations.database.relations.StudentSubjectWithCrossRef
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dao = SchoolDataBase.getInstance(this).schoolDao
        val directors = listOf(
            Director("Mike Litoris", "Jake Wharton School"),
            Director("Jack Goff", "Kotlin School"),
            Director("Chris P. Chicken", "JetBrains School")
        )
        val schools = listOf(
            School("Jake Wharton School"),
            School("Kotlin School"),
            School("JetBrains School")
        )
        val subjects = listOf(
            Subject("Dating for programmers"),
            Subject("Avoiding depression"),
            Subject("Bug Fix Meditation"),
            Subject("Logcat for Newbies"),
            Subject("How to use Google")
        )
        val students = listOf(
            Student("Beff Jezos", 2, "Kotlin School"),
            Student("Mark Suckerberg", 5, "Jake Wharton School"),
            Student("Gill Bates", 8, "Kotlin School"),
            Student("Donny Jepp", 1, "Kotlin School"),
            Student("Hom Tanks", 2, "JetBrains School")
        )
        val studentSubjectRelations = listOf(
            StudentSubjectWithCrossRef("Beff Jezos", "Dating for programmers"),
            StudentSubjectWithCrossRef("Beff Jezos", "Avoiding depression"),
            StudentSubjectWithCrossRef("Beff Jezos", "Bug Fix Meditation"),
            StudentSubjectWithCrossRef("Beff Jezos", "Logcat for Newbies"),
            StudentSubjectWithCrossRef("Mark Suckerberg", "Dating for programmers"),
            StudentSubjectWithCrossRef("Gill Bates", "How to use Google"),
            StudentSubjectWithCrossRef("Donny Jepp", "Logcat for Newbies"),
            StudentSubjectWithCrossRef("Hom Tanks", "Avoiding depression"),
            StudentSubjectWithCrossRef("Hom Tanks", "Dating for programmers")
        )

        lifecycleScope.launch {
            directors.forEach { dao.insertDirector(it) }
            schools.forEach { dao.insertSchool(it) }
            subjects.forEach { dao.insertSubject(it) }
            students.forEach { dao.insertStudent(it) }
            studentSubjectRelations.forEach { dao.insertStudentSubjectCrossRef(it) }
        }
    }
}