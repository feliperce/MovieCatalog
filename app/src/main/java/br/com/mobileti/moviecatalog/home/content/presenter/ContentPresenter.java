package br.com.mobileti.moviecatalog.home.content.presenter;

import java.util.List;

import br.com.mobileti.moviecatalog.home.content.ContentMvp;
import br.com.mobileti.moviecatalog.home.content.model.ContentModel;
import br.com.mobileti.moviecatalog.home.content.model.Movie;
import br.com.mobileti.moviecatalog.home.genre.model.Genre;

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
    public void getGenre() {
        model.getGenres();
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
    public void closeDrawer() {
        view.closeDrawer();
    }

    @Override
    public void openMovieDetail(int movieId) {
        view.openMovieDetail(movieId);
    }

    @Override
    public void setMoviesByGenre(int genreId) {
        model.getMovieByGenre(genreId);
    }

    @Override
    public void onGetMoviesByGenreSuccess(List<Movie> movieList) {
        view.setMoviesByGenre(movieList);
    }

    @Override
    public void onGetMoviesByGenreError(String errorMessage) {

    }

    @Override
    public void onGetGenresSuccess(List<Genre> genreList) {
        view.increaseProgress();
        view.setGenres(genreList);
    }

    @Override
    public void onGetGenresError(String errorMessage) {
        view.increaseProgress();
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
