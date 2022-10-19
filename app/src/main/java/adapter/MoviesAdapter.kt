package adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.enrique.netflixclone.databinding.MoviesListBinding
import model.Movies

class MoviesAdapter(val movies: MutableList<Movies>) :
  RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {
  inner class MoviesViewHolder(val binding: MoviesListBinding) :
    RecyclerView.ViewHolder(binding.root) {

  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
    val binding = MoviesListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

    return MoviesViewHolder(binding)
  }

  override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
    TODO("no yet")
  }

  override fun getItemCount() = movies.size
}