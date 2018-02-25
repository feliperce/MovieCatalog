package br.com.mobileti.moviecatalog.detail.model;

import br.com.mobileti.moviecatalog.api.ApiBuilder;
import br.com.mobileti.moviecatalog.api.ApiService;
import br.com.mobileti.moviecatalog.detail.MovieDetailMvp;
import br.com.mobileti.moviecatalog.home.content.ContentMvp;
import br.com.mobileti.moviecatalog.home.content.model.MovieResponse;
import br.com.mobileti.moviecatalog.home.genre.model.GenreResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by felipe on 24/02/18.
 */

public class MovieDetailModel implements MovieDetailMvp.Model {

    private MovieDetailMvp.Callback callback;

    public MovieDetailModel(MovieDetailMvp.Callback callback) {
        this.callback = callback;
    }

    @Override
    public void getMovieDetail(int movieId) {
        ApiService apiService = ApiBuilder.getInstance().getApiService();
        Call<MovieDetail> apiCall = apiService.getMovieDetail(movieId);
        apiCall.enqueue(new Callback<MovieDetail>() {
            @Override
            public void onResponse(Call<MovieDetail> call, Response<MovieDetail> response) {
                if(response.isSuccessful()) {
                    if(response.body()!=null) {
                        callback.onGetMovieDetailSuccess(response.body());
                    } else {
                        callback.onGetMovieDetailError("getMovieDetail - null body");
                    }
                } else {
                    callback.onGetMovieDetailError("getMovieDetail - nonsuccess");
                }
            }

            @Override
            public void onFailure(Call<MovieDetail> call, Throwable t) {
                callback.onGetMovieDetailError("getMovieDetail - "+t.getMessage());
            }
        });
    }
}
