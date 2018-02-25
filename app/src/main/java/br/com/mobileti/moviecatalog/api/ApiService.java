package br.com.mobileti.moviecatalog.api;

import br.com.mobileti.moviecatalog.detail.model.MovieDetail;
import br.com.mobileti.moviecatalog.detail.model.MovieDetailResponse;
import br.com.mobileti.moviecatalog.home.genre.model.GenreResponse;
import br.com.mobileti.moviecatalog.home.content.model.MovieResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by felipe on 24/02/18.
 */

public interface ApiService {

    @GET("genre/{genreId}/movies?api_key=f791f0b25a9715e85a133c21fb92c33b&language=en-US&include_adult=false&sort_by=created_at.asc")
    Call<MovieResponse> getMovieByGenre(@Path("genreId") int genreId);

    @GET("genre/movie/list?api_key=f791f0b25a9715e85a133c21fb92c33b&language=en-US")
    Call<GenreResponse> getGenreList();

    @GET("movie/now_playing?api_key=f791f0b25a9715e85a133c21fb92c33b&language=en-US&page=1")
    Call<MovieResponse> getPlayingMovieList();

    @GET("movie/top_rated?api_key=f791f0b25a9715e85a133c21fb92c33b&language=en-US&page=1")
    Call<MovieResponse> getRatedMovieList();

    @GET("movie/popular?api_key=f791f0b25a9715e85a133c21fb92c33b&language=en-US&page=1")
    Call<MovieResponse> getTopMovieList();

    @GET("movie/{movieId}?api_key=f791f0b25a9715e85a133c21fb92c33b&language=en-US")
    Call<MovieDetail> getMovieDetail(@Path("movieId") int movieId);

}
