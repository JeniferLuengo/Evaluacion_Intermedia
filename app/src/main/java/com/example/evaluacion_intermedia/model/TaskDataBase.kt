package com.example.evaluacion_intermedia.model
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext

@Database(entities = [TaskEntity ::class], version = 1)
abstract class TaskDataBase :RoomDatabase() {

    abstract fun getTaskDao(): TaskDao
    companion object{
        @Volatile
        private var Instance :TaskDataBase? = null

        fun getDataBase(context: Context):TaskDataBase{
            val tempInstance = Instance
            if(tempInstance != null){
                return tempInstance
            }
            synchronized( this){
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    TaskDataBase::class.java,
                    "task_db")
                    .build()
                Instance = instance
                return instance
            }
        }
    }
}