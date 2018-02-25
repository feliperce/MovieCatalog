package br.com.mobileti.moviecatalog.home.content.presenter;

import java.util.List;

import br.com.mobileti.moviecatalog.home.content.ContentMvp;
import br.com.mobileti.moviecatalog.home.content.model.ContentModel;
import br.com.mobileti.moviecatalog.home.content.model.Movie;

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
    public void getRatedMovies() {
        model.getRatedMovies();
    }

    @Override
    public void getTopMovies() {
        model.getTopMovies();
    }

    @Override
    public void onGetPlayingMovieSuccess(List<Movie> playingMovieList) {
        view.increaseProgress();
        view.setPlayingMovies(playingMovieList);
    }

    @Override
    public void onGetPlayingMovieError(String errorMessage) {
        view.increaseProgress();
    }

    @Override
    public void onGetRatedMovieSuccess(List<Movie> ratedMovieList) {
        view.increaseProgress();
        view.setRatedMovies(ratedMovieList);
    }

    @Override
    public void onGetRatedMovieError(String errorMessage) {
        view.increaseProgress();
    }

    @Override
    public void onGetTopMovieSuccess(List<Movie> topMovieList) {
        view.increaseProgress();
        view.setTopMovies(topMovieList);
    }

    @Override
    public void onGetTopMovieError(String errorMessage) {
        view.increaseProgress();
    }
}
