package com.example.fundamentals.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fundamentals.API.Games
import com.example.fundamentals.R
import kotlinx.android.synthetic.main.game_list.view.*

class GamesAdapter(private val games: ArrayList<Games>?): RecyclerView.Adapter<GamesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.game_list,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.gameTitle.text = games!![position].name
        holder.gameDescription.text = games[position].description
        holder.gamePrice.text = games[position].price_rur
    }

    override fun getItemCount(): Int {
        return games!!.size
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val gameTitle = view.gameTitle
        val gamePrice = view.gamePrice
        val gameDescription = view.gameDesciption
    }

}