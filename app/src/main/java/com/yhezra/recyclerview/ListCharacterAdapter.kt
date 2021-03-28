package com.yhezra.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.yhezra.recyclerview.databinding.ListCharacterBinding

class ListCharacterAdapter(private val listCharacter: ArrayList<SuperHeroes>, var clickListener: OnCharacterClickListener):RecyclerView.Adapter<ListCharacterAdapter.ListViewHolder>() {
    inner class ListViewHolder(private val binding: ListCharacterBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(superHeroes : SuperHeroes, action: OnCharacterClickListener){
            with(binding){
                Glide.with(itemView.context)
                    .load(superHeroes.image)
                    .apply(RequestOptions().override(55,55))
                    .into(tvImgCharacter)
                tvCharName.text = superHeroes.name
                tvCharDetail.text = superHeroes.detail

                itemView.setOnClickListener {
                    action.onCharacterClick(superHeroes, adapterPosition)
                }
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val binding = ListCharacterBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind((listCharacter[position]),clickListener)
    }

    override fun getItemCount(): Int = listCharacter.size
}