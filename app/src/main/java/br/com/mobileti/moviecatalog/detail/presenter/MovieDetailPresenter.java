package br.com.mobileti.moviecatalog.detail.presenter;

import java.util.List;

import br.com.mobileti.moviecatalog.detail.MovieDetailMvp;
import br.com.mobileti.moviecatalog.detail.model.MovieDetail;
import br.com.mobileti.moviecatalog.detail.model.MovieDetailModel;
import br.com.mobileti.moviecatalog.home.content.ContentMvp;
import br.com.mobileti.moviecatalog.home.content.model.ContentModel;
import br.com.mobileti.moviecatalog.home.content.model.Movie;
import br.com.mobileti.moviecatalog.home.genre.model.Genre;

/**
 * Created by felipe on 24/02/18.
 */

public class MovieDetailPresenter implements MovieDetailMvp.Presenter, MovieDetailMvp.Callback {

    private MovieDetailMvp.Model model;
    private MovieDetailMvp.View view;

    public MovieDetailPresenter(MovieDetailMvp.View view) {
        this.view = view;
        this.model = new MovieDetailModel(this);
    }

    @Override
    public void getMovieDetail(int movieId) {
        view.startProgressBar();
        model.getMovieDetail(movieId);
    }

    @Override
    public void onGetMovieDetailSuccess(MovieDetail movieDetail) {
        view.increaseProgress();
        view.setMovie(movieDetail);
    }

    @Override
    public void onGetMovieDetailError(String errorMessage) {
        view.increaseProgress();
    }
}
