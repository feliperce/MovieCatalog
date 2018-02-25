package br.com.mobileti.moviecatalog.home.content.model;

import br.com.mobileti.moviecatalog.api.ApiBuilder;
import br.com.mobileti.moviecatalog.api.ApiService;
import br.com.mobileti.moviecatalog.home.content.ContentMvp;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by felipe on 24/02/18.
 */

public class ContentModel implements ContentMvp.Model {

    private ContentMvp.Callback callback;

    public ContentModel(ContentMvp.Callback callback) {
        this.callback = callback;
    }

    @Override
    public void getPlayingMovies() {
        ApiService apiService = ApiBuilder.getInstance().getApiService();
        Call<MovieResponse> apiCall = apiService.getPlayingMovieList();
        apiCall.enqueue(new Callback<MovieResponse>() {
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
    public void getRatedMovies() {
        ApiService apiService = ApiBuilder.getInstance().getApiService();
        Call<MovieResponse> apiCall = apiService.getRatedMovieList();
        apiCall.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if(response.isSuccessful()) {
                    if(response.body()!=null) {
                        callback.onGetRatedMovieSuccess(response.body().getMovieList());
                    } else {
                        callback.onGetRatedMovieError("getRatedMovieList - null body");
                    }
                } else {
                    callback.onGetRatedMovieError("getRatedMovieList - nonsuccess");
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                callback.onGetRatedMovieError("getRatedMovieList - "+t.getMessage());
            }
        });
    }

    @Override
    public void getTopMovies() {
        ApiService apiService = ApiBuilder.getInstance().getApiService();
        Call<MovieResponse> apiCall = apiService.getTopMovieList();
        apiCall.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if(response.isSuccessful()) {
                    if(response.body()!=null) {
                        callback.onGetTopMovieSuccess(response.body().getMovieList());
                    } else {
                        callback.onGetTopMovieError("getTopMovieList - null body");
                    }
                } else {
                    callback.onGetTopMovieError("getTopMovieList - nonsuccess");
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                callback.onGetTopMovieError("getTopMovieList - "+t.getMessage());
            }
        });
    }
}
