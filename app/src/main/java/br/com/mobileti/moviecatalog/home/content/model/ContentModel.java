package br.com.mobileti.moviecatalog.home.content.model;

import br.com.mobileti.moviecatalog.api.ApiBuilder;
import br.com.mobileti.moviecatalog.api.ApiService;
import br.com.mobileti.moviecatalog.home.content.ContentMvp;
import br.com.mobileti.moviecatalog.home.genre.GenreMvp;
import br.com.mobileti.moviecatalog.home.genre.model.GenreResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by felipe on 24/02/18.
 */

public class ContentModel implements ContentMvp.Model {

    private ContentMvp.Callback callback;

    public ContentModel(ContentMvp.Callback callback) {
        this.callback = callback;
    }

   /* @Override
    public void getAllGenres() {
        ApiService apiService = ApiBuilder.getInstance().getApiService();
        Call<GenreResponse> genreCall = apiService.getGenreList();
        genreCall.enqueue(new Callback<GenreResponse>() {
            @Override
            public void onResponse(Call<GenreResponse> call, Response<GenreResponse> response) {
                if(response.isSuccessful()) {
                    if(response.body()!=null) {
                        callback.onGetAllGenresSuccess(response.body().getGenres());
                    } else {
                        callback.onGetAllGenresError("getGenre - null body");
                    }
                } else {
                    callback.onGetAllGenresError("getGenre - nonsuccess");
                }
            }

            @Override
            public void onFailure(Call<GenreResponse> call, Throwable t) {
                callback.onGetAllGenresError("getGenre - "+t.getMessage());
            }
        });
    }*/

    @Override
    public void getPlayingMovies() {
        ApiService apiService = ApiBuilder.getInstance().getApiService();
        Call<MovieResponse> genreCall = apiService.getPlayingMovieList();
        genreCall.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if(response.isSuccessful()) {
                    if(response.body()!=null) {
                        callback.onGetPlayingMovieSuccess(response.body().getMovieList());
                    } else {
                        callback.onGetPlayingMovieError("getPlayingMovie - null body");
                    }
                } else {
                    callback.onGetPlayingMovieError("getPlayingMovie - nonsuccess");
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                callback.onGetPlayingMovieError("getPlayingMovie - "+t.getMessage());
            }
        });
    }

    @Override
    public void getPopularMovies() {

    }

    @Override
    public void getTopMovies() {

    }
}
