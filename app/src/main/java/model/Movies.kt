package model

data class Movies(
  val movieCover: Int
)

class MoviesBuilder {
  var coverMovie: Int = 0
  fun build(): Movies = Movies(coverMovie)
}

fun movies(block: MoviesBuilder.() -> Unit): Movies = MoviesBuilder().apply(block).build()

fun addMovies(): MutableList<Movies> = mutableListOf(
  movies {  }
)