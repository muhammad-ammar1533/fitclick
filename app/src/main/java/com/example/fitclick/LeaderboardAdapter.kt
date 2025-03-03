package com.example.fitclick

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class LeaderboardItem(val position: String, val exp: String, val rank: String)

class LeaderboardAdapter(private val leaderboardList: List<LeaderboardItem>) :
    RecyclerView.Adapter<LeaderboardAdapter.LeaderboardViewHolder>() {

    class LeaderboardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val positionText: TextView = view.findViewById(R.id.position)
        val expText: TextView = view.findViewById(R.id.exp)
        val rankText: TextView = view.findViewById(R.id.rank)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeaderboardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.leaderboard_item, parent, false)
        return LeaderboardViewHolder(view)
    }

    override fun onBindViewHolder(holder: LeaderboardViewHolder, position: Int) {
        val item = leaderboardList[position]
        holder.positionText.text = item.position
        holder.expText.text = item.exp
        holder.rankText.text = item.rank
    }

    override fun getItemCount(): Int = leaderboardList.size
}
