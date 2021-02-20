package com.coin.roomrelations.database.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.coin.roomrelations.database.entities.Student
import com.coin.roomrelations.database.entities.Subject


data class SubjectWithStudent(
    @Embedded val subject: Subject,
    @Relation(
        parentColumn = "subjectName",
        entityColumn = "studentName",
        associateBy = Junction(StudentSubjectWithCrossRef::class)
    )
    val student:List<Student>
)
