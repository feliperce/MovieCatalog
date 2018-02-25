package br.com.mobileti.moviecatalog.api;

import java.util.Locale;

import br.com.mobileti.moviecatalog.detail.model.MovieDetail;
import br.com.mobileti.moviecatalog.detail.model.MovieDetailResponse;
import br.com.mobileti.moviecatalog.home.genre.model.GenreResponse;
import br.com.mobileti.moviecatalog.home.content.model.MovieResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by felipe on 24/02/18.
 */

public interface ApiService {

    public static String CountryCode = "";

    @GET("genre/{genreId}/movies?api_key=f791f0b25a9715e85a133c21fb92c33b&language=&include_adult=false&sort_by=created_at.asc")
    Call<MovieResponse> getMovieByGenre(@Path("genreId") int genreId, @Query("language") String language);

    @GET("genre/movie/list?api_key=f791f0b25a9715e85a133c21fb92c33b&language=")
    Call<GenreResponse> getGenreList(@Query("language") String language);

    @GET("movie/now_playing?api_key=f791f0b25a9715e85a133c21fb92c33b&language=&page=1")
    Call<MovieResponse> getPlayingMovieList(@Query("language") String language);

    @GET("movie/top_rated?api_key=f791f0b25a9715e85a133c21fb92c33b&language=&page=1")
    Call<MovieResponse> getRatedMovieList(@Query("language") String language);

    @GET("movie/popular?api_key=f791f0b25a9715e85a133c21fb92c33b&language=&page=1")
    Call<MovieResponse> getTopMovieList(@Query("language") String language);

    @GET("movie/{movieId}?api_key=f791f0b25a9715e85a133c21fb92c33b&language=")
    Call<MovieDetail> getMovieDetail(@Path("movieId") int movieId, @Query("language") String language);

}
