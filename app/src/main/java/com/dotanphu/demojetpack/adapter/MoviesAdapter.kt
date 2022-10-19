package com.dotanphu.demojetpack.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dotanphu.demojetpack.databinding.ItemMoviesBinding
import com.dotanphu.demojetpack.model.Movies

class MoviesAdapter : PagingDataAdapter<Movies, MoviesAdapter.ViewHolder>(moviesDiff) {

    companion object {
        val moviesDiff = object : DiffUtil.ItemCallback<Movies>() {
            override fun areItemsTheSame(oldItem: Movies, newItem: Movies): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Movies, newItem: Movies): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currChar = getItem(position)

        holder.binding.apply {

            holder.itemView.apply {
                tvTitle.text = "${currChar?.title}"
                tvReleaseDateDetail.text = "${currChar?.release_date}"
                tvRatingDetail.text = "${currChar?.vote_average}"
                tvOverviewDetail.text = "${currChar?.overview}"
                Glide.with(holder.itemView)
                    .load("https://image.tmdb.org/t/p/original/" + currChar?.poster_path)
                    .into(holder.binding.imgMoviess)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemMoviesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    inner class ViewHolder(val binding: ItemMoviesBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

}