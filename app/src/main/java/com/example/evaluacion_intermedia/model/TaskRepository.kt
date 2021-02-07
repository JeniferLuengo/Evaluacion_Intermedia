package com.example.evaluacion_intermedia.model
import androidx.lifecycle.LiveData

class TaskRepository ( private val taskDao : TaskDao){

    // en esto contiene  toda la info de la base de dato
    val ListAllTask: LiveData<List<TaskEntity>> = taskDao.getAllTask()
    suspend fun insertTask(task: TaskEntity){
        taskDao.insertTask(task)
    }
    suspend fun updateTask(task: TaskEntity){
        taskDao.updateTask(task)
    }
    suspend fun  deleteTask(task:TaskEntity){
        taskDao.deleteTask(task)
    }
      suspend fun  deleteAll() {
        taskDao.deleteAll()
    }
fun getTaskById (id: Int): LiveData<TaskEntity>{
    return taskDao.getTaskById(id)
}

}