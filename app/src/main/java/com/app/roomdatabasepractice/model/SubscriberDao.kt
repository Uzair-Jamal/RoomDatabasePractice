package com.app.roomdatabasepractice.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface SubscriberDao {
    @Insert
    suspend fun insertSubscriber(subscriber: Subscriber): Long

    @Update
    suspend fun updateSubscriber(subscriber: Subscriber)

    @Delete
    suspend fun deleteSubscriber(subscriber: Subscriber)

    @Query("DELETE FROM subscriber_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM subscriber_table")
    fun getAllSubscribers():LiveData<List<Subscriber>>
}
