package com.example.aboutme.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aboutme.databinding.ItemHobbyBinding
import com.example.aboutme.models.Hobby

class HobbiesAdapter(private val hobbies: List<Hobby>):
    RecyclerView.Adapter<HobbiesAdapter.HobbiesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HobbiesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemHobbyBinding.inflate(layoutInflater, parent, false)
        return HobbiesViewHolder(binding)
    }

    override fun getItemCount() = hobbies.size

    override fun onBindViewHolder(holder: HobbiesViewHolder, position: Int) {
        val hobby = hobbies[position]
        holder.bind(hobby)
    }

    class HobbiesViewHolder(private val binding: ItemHobbyBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(hobby: Hobby) {
            binding.apply {
                hobbyTitle.text = hobby.title
                hobbyDesc.text = hobby.desc
            }
        }
    }
}