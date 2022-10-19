package model

import com.enrique.netflixclone.R

data class Movies(
  val movieCover: Int
)

class MoviesBuilder {
  var coverMovie: Int = 0
  fun build(): Movies = Movies(coverMovie)
}

fun movies(block: MoviesBuilder.() -> Unit): Movies = MoviesBuilder().apply(block).build()

fun addMovies(): MutableList<Movies> = mutableListOf(
  movies {
    coverMovie = R.drawable.filme1
  },
  movies {
    coverMovie = R.drawable.filme2
  },
  movies {
    coverMovie = R.drawable.filme3
  },
  movies {
    coverMovie = R.drawable.filme4
  },
  movies {
    coverMovie = R.drawable.filme5
  },
  movies {
    coverMovie = R.drawable.filme6
  },
  movies {
    coverMovie = R.drawable.filme7
  },
  movies {
    coverMovie = R.drawable.filme8
  },
  movies {
    coverMovie = R.drawable.filme9
  },
  movies {
    coverMovie = R.drawable.filme10
  },
  movies {
    coverMovie = R.drawable.filme11
  },
  movies {
    coverMovie = R.drawable.filme12
  },
)