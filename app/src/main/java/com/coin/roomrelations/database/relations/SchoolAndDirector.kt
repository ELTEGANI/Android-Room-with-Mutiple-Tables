package com.coin.roomrelations.database.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.coin.roomrelations.database.entities.Director
import com.coin.roomrelations.database.entities.School


data class SchoolAndDirector(
  @Embedded val school: School,
  @Relation(
      parentColumn = "schoolName",
      entityColumn = "schoolName"
  )
  var director: Director
)
