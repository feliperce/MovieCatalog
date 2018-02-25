package br.com.mobileti.moviecatalog.home.content.presenter;

import java.util.List;

import br.com.mobileti.moviecatalog.home.content.ContentMvp;
import br.com.mobileti.moviecatalog.home.content.model.ContentModel;
import br.com.mobileti.moviecatalog.home.content.model.Movie;
import br.com.mobileti.moviecatalog.home.genre.GenreMvp;
import br.com.mobileti.moviecatalog.home.genre.model.Genre;
import br.com.mobileti.moviecatalog.home.genre.model.GenreModel;

/**
 * Created by felipe on 24/02/18.
 */

public class ContentPresenter implements ContentMvp.Presenter, ContentMvp.Callback {

    private ContentMvp.Model model;
    private ContentMvp.View view;

    public ContentPresenter(ContentMvp.View view) {
        this.view = view;
        this.model = new ContentModel(this);
    }

    @Override
    public void getPlayingMovies() {
        model.getPlayingMovies();
    }

    @Override
    public void getPopularMovies() {

    }

    @Override
    public void getTopMovies() {

    }

    @Override
    public void onGetPlayingMovieSuccess(List<Movie> playingMovieList) {
        view.finishProgressBar();
        view.setPlayingMovies(playingMovieList);
    }

    @Override
    public void onGetPlayingMovieError(String errorMessage) {
        view.finishProgressBar();
    }

    @Override
    public void onGetPopularMovieSuccess(List<Movie> popularMovieList) {

    }

    @Override
    public void onGetPopularMovieError(String errorMessage) {

    }

    @Override
    public void onGetTopMovieSuccess(List<Movie> topMovieList) {

    }

    @Override
    public void onGetTopMovieError(String errorMessage) {

    }
}
