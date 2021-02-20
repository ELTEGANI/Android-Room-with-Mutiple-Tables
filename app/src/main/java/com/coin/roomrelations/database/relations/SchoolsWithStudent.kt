package com.coin.roomrelations.database.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.coin.roomrelations.database.entities.School
import com.coin.roomrelations.database.entities.Student

data class SchoolsWithStudent(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val students:List<Student>
)
