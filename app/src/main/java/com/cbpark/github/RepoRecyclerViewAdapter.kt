package com.cbpark.github

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RepoRecyclerViewAdapter : RecyclerView.Adapter<RepoRecyclerViewAdapter.RepoViewHolder>() {

    private val githubRepos: ArrayList<GithubRepo> = ArrayList()

    inner class RepoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_repo_name)
        var tvLanguage: TextView = itemView.findViewById(R.id.tv_repo_language)
        var tvIsPrivate: TextView = itemView.findViewById(R.id.tv_repo_is_private)
        var tvDate: TextView = itemView.findViewById(R.id.tv_date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder =
        RepoViewHolder(
            (LayoutInflater.from(parent.context).inflate(R.layout.repo_item, parent, false))
        )

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.tvName.text = githubRepos[position].name
        holder.tvLanguage.text = githubRepos[position].language
        holder.tvDate.text = githubRepos[position].date
        holder.tvIsPrivate.text = if (githubRepos[position].isPrivate) {
            "Private"
        } else {
            "Public"
        }
    }

    override fun getItemCount(): Int = githubRepos.size

    @SuppressLint("NotifyDataSetChanged")
    fun update(githubRepos: ArrayList<GithubRepo>) {
        this.githubRepos.clear()
        this.githubRepos.addAll(githubRepos)
        notifyDataSetChanged()
    }
}