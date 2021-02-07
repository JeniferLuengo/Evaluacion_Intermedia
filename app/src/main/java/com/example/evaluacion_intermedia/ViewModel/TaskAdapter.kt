package com.example.evaluacion_intermedia.ViewModel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.evaluacion_intermedia.databinding.TaskItemListBinding
import com.example.evaluacion_intermedia.model.TaskEntity



class TaskAdapter : RecyclerView.Adapter<TaskAdapter.TaskVH>(){
    private var listTak= listOf<TaskEntity>()

    private val selectedTaskItem= MutableLiveData <TaskEntity>()
    fun selectItem():LiveData<TaskEntity> = selectedTaskItem

    fun update(list: List<TaskEntity>){
        listTak =list
        notifyDataSetChanged()
    }
 inner class TaskVH(private val binding: TaskItemListBinding):
         RecyclerView.ViewHolder(binding.root), View.OnClickListener {
     fun bind(task: TaskEntity) {
         binding.tvNombre.text = task.nombre
         binding.tvCantidad.text = task.cantidad.toString()
         binding.tvTotal.text = task.precio.toString()
         itemView.setOnClickListener(this)
     }

     override fun onClick(v: View?) {
         selectedTaskItem.value = listTak[adapterPosition]
     }
 }
     override fun onCreateViewHolder(parent:ViewGroup,viewType:Int):TaskVH{
         return TaskVH(TaskItemListBinding.inflate(LayoutInflater.from(parent.context)))
     }


    override fun onBindViewHolder(holder: TaskAdapter.TaskVH, position: Int) {
        val task= listTak[position]
        holder.bind(task)

    }

    override fun getItemCount(): Int = listTak.size


}