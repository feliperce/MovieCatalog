package br.com.mobileti.moviecatalog.home.api;

import java.util.List;

import br.com.mobileti.moviecatalog.home.model.Genre;
import br.com.mobileti.moviecatalog.home.model.GenreResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by felipe on 24/02/18.
 */

public interface ApiService {

    @GET("genre/movie/list?api_key=f791f0b25a9715e85a133c21fb92c33b&language=en-US")
    Call<GenreResponse> getGenreList();

}
