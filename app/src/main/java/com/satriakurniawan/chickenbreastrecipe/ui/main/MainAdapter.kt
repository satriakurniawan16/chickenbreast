package com.satriakurniawan.chickenbreastrecipe.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.satriakurniawan.chickenbreastrecipe.R
import kotlinx.android.synthetic.main.item_meal.view.*

class MainAdapter(private val listMeal: ArrayList<MainModel>) : RecyclerView.Adapter<MainAdapter.ListViewHolder>() {
    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_meal, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listMeal[position])
    }

    override fun getItemCount(): Int = listMeal.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(meal: MainModel) {
            with(itemView){
                tv_meal_name.text = meal.title
                itemView.setOnClickListener { onItemClickCallback?.onItemClicked(meal) }
                Glide.with(itemView.context)
                    .load(meal.image)
                    .into(iv_meal)
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: MainModel)
    }
}