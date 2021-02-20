package com.coin.roomrelations.database.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.coin.roomrelations.database.entities.Student
import com.coin.roomrelations.database.entities.Subject


data class StudentWithSubjects(
    @Embedded val student: Student,
    @Relation(
        parentColumn = "studentName",
        entityColumn = "subjectName",
        associateBy = Junction(StudentSubjectWithCrossRef::class)
    )
    val subjects:List<Subject>
)
