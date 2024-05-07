package com.example.roomapp.domain.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomapp.R
import com.example.roomapp.domain.models.Hero
import com.squareup.picasso.Picasso

class HeroAdapter (val heroes: List<Hero>) : RecyclerView.Adapter<HeroAdapter.ViewHolder>(){
    class ViewHolder(item: View) : RecyclerView.ViewHolder(item){
        val name = item.findViewById<TextView>(R.id.tv_hero_name)
        val image = item.findViewById<ImageView>(R.id.iv_hero_image)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.hero_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return heroes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hero = heroes[position]
        holder.name.text = hero.name
        Picasso.get().load(hero.imageUrl).into(holder.image)
    }

}