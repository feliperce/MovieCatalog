package br.com.mobileti.moviecatalog.detail.model;

import com.google.gson.annotations.SerializedName;

import br.com.mobileti.moviecatalog.home.genre.model.Genre;

/**
 * Created by felipe on 25/02/18.
 */

public class MovieDetailResponse {

    private MovieDetail movieDetail;

    public MovieDetail getMovieDetail() {
        return movieDetail;
    }

    public void setMovieDetail(MovieDetail movieDetail) {
        this.movieDetail = movieDetail;
    }
}
