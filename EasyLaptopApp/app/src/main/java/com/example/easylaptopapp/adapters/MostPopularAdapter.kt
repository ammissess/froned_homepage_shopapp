package com.example.easylaptopapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.easylaptopapp.databinding.PopularItemsBinding
import com.example.easylaptopapp.pojo.MealsByCategory

class MostPopularAdapter() : RecyclerView.Adapter<MostPopularAdapter.PopularLaptopViewHolder>() {

    lateinit var onItemClick:((MealsByCategory )-> Unit)
    private var mealsList = ArrayList<MealsByCategory>()

    fun setMeals(mealsList: ArrayList<MealsByCategory>){
        this.mealsList = mealsList
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularLaptopViewHolder {
        return PopularLaptopViewHolder(PopularItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: PopularLaptopViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load(mealsList[position].strMealThumb)
            .fitCenter()
            .into(holder.binding.imgPopularLaptopItem)
        holder.itemView.setOnClickListener{
            onItemClick.invoke(mealsList[position])
        }

    }

    override fun getItemCount(): Int {
        return mealsList.size
    }

    class PopularLaptopViewHolder(var binding: PopularItemsBinding):RecyclerView.ViewHolder(binding.root)


}