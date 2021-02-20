package com.coin.roomrelations.database.relations

import androidx.room.Entity


@Entity(primaryKeys = ["studentName","subjectName"])
data class StudentSubjectWithCrossRef(
    val studentName:String,
    val subjectName:String
)


