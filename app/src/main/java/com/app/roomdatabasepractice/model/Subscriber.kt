package com.app.roomdatabasepractice.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "subscriber_table")
data class Subscriber(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("subscriber_id")
    val id:Int,
    @ColumnInfo("subscriber_name")
    val name: String,
    @ColumnInfo("subscriber_email")
    val email: String
)
