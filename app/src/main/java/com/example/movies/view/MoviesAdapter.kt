package com.example.movies.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.movies.model.Movie
import com.example.movies.R
import com.example.movies.view.viewholder.MoviesViewHolder
import kotlinx.android.synthetic.main.movie_item_layout.view.*

class MoviesAdapter(private val moviesList: List<Movie>): RecyclerView.Adapter<MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item_layout, parent, false)
        return MoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.itemView.apply {
            movieTitle.text = moviesList[position].titulo
            movieImage.load(moviesList[position].imagem) {
                placeholder(R.drawable.ic_image)
                fallback(R.drawable.ic_image)
            }
        }
    }

    override fun getItemCount(): Int = moviesList.size
}