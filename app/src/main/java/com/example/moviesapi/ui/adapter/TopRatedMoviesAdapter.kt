package com.example.moviesapi.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapi.R
import com.example.moviesapi.ui.model.Movie
import com.example.moviesapi.ui.util.ImgLoader
import com.google.android.material.card.MaterialCardView

class TopRatedMoviesAdapter(
    val click: AdapterClick<Movie>,
    val imgLoader: ImgLoader
): RecyclerView.Adapter<TopRatedMoviesAdapter.TopMoviesViewHolder>() {
    var moviesSearchList = ArrayList<Movie>()
    var movies = ArrayList<Movie>()

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TopMoviesViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.movie_card_view, viewGroup, false)

        return TopMoviesViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: TopMoviesViewHolder, position: Int) {
        val movie = movies[position]

        viewHolder.title.text = movie.title
        viewHolder.genre.text = movie.genres
        viewHolder.releaseYear.text = movie.releaseYear
        viewHolder.movieRatingCount.text = movie.rating.toString()
        viewHolder.movieRatingBar.rating = movie.rating.toFloat()

        imgLoader.loadImage(
            imgUrl = movie.movieImgUrl,
            imgView = viewHolder.movieImg
        )

        viewHolder.cardView.setOnClickListener { click.simpleClick(movie) }

        if (movies[position].topRated) {
            viewHolder.topIcon.visibility = View.VISIBLE
            viewHolder.topRatedTxt.visibility = View.VISIBLE
            viewHolder.ratingLayout.setBackgroundResource(R.drawable.rating_top_rated_bg)
            viewHolder.cardView.background
                .setTint(
                    ContextCompat
                        .getColor(viewHolder.itemView.context, R.color.movie_card_top_rated_bg)
                )
        } else {
            viewHolder.topIcon.visibility = View.GONE
            viewHolder.topRatedTxt.visibility = View.GONE
            viewHolder.ratingLayout.setBackgroundResource(R.drawable.rating_normal_bg)
            viewHolder.cardView.background
                .setTint(
                    ContextCompat
                        .getColor(viewHolder.itemView.context, R.color.movie_card_bg)
                )
        }
    }

    fun updateData(list: List<Movie>) {
        movies = ArrayList<Movie>(list)
        moviesSearchList = ArrayList<Movie>(list)
        notifyDataSetChanged()
    }

    override fun getItemCount() = movies.size

    fun getFilter(): Filter {
        return eventNameFilter
    }

    private val eventNameFilter = object : Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults {
            val filteredList: ArrayList<Movie> = ArrayList()
            if (constraint == null || constraint.isEmpty()) {
                moviesSearchList.let { filteredList.addAll(it) }
            } else {
                val query = constraint.toString().trim().toLowerCase()
                moviesSearchList.forEach {
                    if (it.title.toLowerCase().contains(query)) {
                        filteredList.add(it)
                    }
                }
            }
            val results = FilterResults()
            results.values = filteredList
            return results
        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
            if (results?.values is ArrayList<*>) {
                movies.clear()
                movies.addAll(results.values as ArrayList<Movie>)
                notifyDataSetChanged()
            }
        }
    }

    class TopMoviesViewHolder(
        view: View,
        val title: TextView = view.findViewById(R.id.movieCvTitleTxtView),
        val genre: TextView = view.findViewById(R.id.movieCvGenreTxtView),
        val releaseYear: TextView = view.findViewById(R.id.movieReleaseYearTxtView),
        val movieRatingCount: TextView = view.findViewById(R.id.movieRatingCount),
        val movieRatingBar: RatingBar = view.findViewById(R.id.movieRatingBar),
        val cardView: MaterialCardView = view.findViewById(R.id.movieCardView),
        val movieImg: ImageView = view.findViewById(R.id.movieCvImg),
        val topIcon: ImageView = view.findViewById(R.id.movieCvTopIcon),
        val topRatedTxt: TextView = view.findViewById(R.id.movieCvTopTxtView),
        val ratingLayout: LinearLayoutCompat = view.findViewById(R.id.movieCvRatingLayout),
    ): RecyclerView.ViewHolder(view) {
    }
}