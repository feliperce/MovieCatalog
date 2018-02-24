package br.com.mobileti.moviecatalog.home.model;

import java.util.List;

import br.com.mobileti.moviecatalog.ApiBuilder;
import br.com.mobileti.moviecatalog.home.HomeMvp;
import br.com.mobileti.moviecatalog.home.api.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by felipe on 24/02/18.
 */

public class GenreModel implements HomeMvp.Model {

    private HomeMvp.Callback callback;
    private Retrofit retrofit;

    public GenreModel(HomeMvp.Callback callback) {
        this.callback = callback;
    }

    @Override
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
    }
}
