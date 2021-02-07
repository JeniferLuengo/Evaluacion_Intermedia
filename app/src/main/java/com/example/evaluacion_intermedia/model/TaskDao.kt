package com.example.evaluacion_intermedia.model

import androidx.lifecycle.LiveData
import  androidx.room.*

@Dao

interface TaskDao {

    // Insertar Elemento
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(Task:TaskEntity)

    //Insertar Lista de tareas
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  insertAllTask(ListTask:List<TaskEntity>)

    //Actualizar Elemento

    @Update
    suspend fun updateTask(task:TaskEntity)

    //Borrar una tarea

    @Delete
    suspend fun deleteTask(task: TaskEntity)
    // Borrar todo
    @Query("DELETE FROM task_table")
    suspend fun  deleteAll()
    // traer todos los elementos
    @Query("SELECT * FROM task_table")
    fun getAllTask(): LiveData<List<TaskEntity>>
    //traer por titulo
    @Query("SELECT * FROM task_table WHERE nombre = nombre LIMIT 1")
    fun  getTaskByTitle (nombre : String): LiveData<TaskEntity>

    // traer po id
    @Query("SELECT * From task_table WHERE id= :id")
    fun getTaskById(id: Int): LiveData<TaskEntity>
}
