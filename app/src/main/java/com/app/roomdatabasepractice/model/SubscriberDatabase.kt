package com.app.roomdatabasepractice.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [Subscriber::class],version = 1)
abstract class SubscriberDatabase: RoomDatabase() {

    abstract val subscriberDao: SubscriberDao

    companion object{
        @Volatile
        private var INSTANCE : SubscriberDatabase? = null
            @OptIn(InternalCoroutinesApi::class)
            fun getInstance(context: Context): SubscriberDatabase{
                synchronized(this){
                    var instance = INSTANCE
                    if(instance==null){
                        instance = Room.databaseBuilder(
                            context.applicationContext,
                            SubscriberDatabase::class.java,
                            "subscriber_database"
                        ).build()
                        INSTANCE = instance
                    }
                    return instance
                }
            }
    }

}