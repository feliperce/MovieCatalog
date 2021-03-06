package br.com.mobileti.moviecatalog.home.content.model;

import br.com.mobileti.moviecatalog.api.ApiBuilder;
import br.com.mobileti.moviecatalog.api.ApiService;
import br.com.mobileti.moviecatalog.application.MyApplication;
import br.com.mobileti.moviecatalog.home.content.ContentMvp;
import br.com.mobileti.moviecatalog.home.genre.model.GenreResponse;
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
    public void getGenres() {
        ApiService apiService = ApiBuilder.getInstance().getApiService();
        Call<GenreResponse> apiCall = apiService.getGenreList(MyApplication.COUNTRY_CODE);
        apiCall.enqueue(new Callback<GenreResponse>() {
            @Override
            public void onResponse(Call<GenreResponse> call, Response<GenreResponse> response) {
                if(response.isSuccessful()) {
                    if(response.body()!=null) {
                        callback.onGetGenresSuccess(response.body().getGenres());
                    } else {
                        callback.onGetGenresError("getGenres - null body");
                    }
                } else {
                    callback.onGetGenresError("getGenres - nonsuccess");
                }
            }

            @Override
            public void onFailure(Call<GenreResponse> call, Throwable t) {
                callback.onGetGenresError("getGenres - "+t.getMessage());
            }
        });
    }

    @Override
    public void getPlayingMovies() {
        ApiService apiService = ApiBuilder.getInstance().getApiService();
        Call<MovieResponse> apiCall = apiService.getPlayingMovieList(MyApplication.COUNTRY_CODE);
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
        Call<MovieResponse> apiCall = apiService.getRatedMovieList(MyApplication.COUNTRY_CODE);
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
        Call<MovieResponse> apiCall = apiService.getTopMovieList(MyApplication.COUNTRY_CODE);
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

    @Override
    public void getMovieByGenre(int genreId) {
        ApiService apiService = ApiBuilder.getInstance().getApiService();
        Call<MovieResponse> apiCall = apiService.getMovieByGenre(genreId, MyApplication.COUNTRY_CODE);
        apiCall.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if(response.isSuccessful()) {
                    if(response.body()!=null) {
                        callback.onGetMoviesByGenreSuccess(response.body().getMovieList());
                    } else {
                        callback.onGetMoviesByGenreError("getMovieByGenre - null body");
                    }
                } else {
                    callback.onGetMoviesByGenreError("getMovieByGenre - nonsuccess");
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                callback.onGetMoviesByGenreError("getMovieByGenre - "+t.getMessage());
            }
        });
    }
}
