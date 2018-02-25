package br.com.mobileti.moviecatalog.home.content;

import java.util.List;

import br.com.mobileti.moviecatalog.BaseView;
import br.com.mobileti.moviecatalog.home.content.model.Movie;
import br.com.mobileti.moviecatalog.home.genre.model.Genre;

/**
 * Created by felipe on 24/02/18.
 */

public interface ContentMvp {

    interface Model {
        void getGenres();
        void getPlayingMovies();
        void getRatedMovies();
        void getTopMovies();
        void getMovieByGenre(int genreId);
    }

    interface View extends BaseView {
        void setMoviesByGenre(List<Movie> movieList);
        void setGenres(List<Genre> genreList);
        void setPlayingMovies(List<Movie> playingMovieList);
        void setRatedMovies(List<Movie> ratedMovieList);
        void setTopMovies(List<Movie> topMovieList);
        void setAdapters();
        void closeDrawer();
        boolean isMovieEmpty();
        void initViews();
    }

    interface Presenter {
        void setMoviesByGenre(int genreId);
        void getGenre();
        void getPlayingMovies();
        void getRatedMovies();
        void getTopMovies();
        void closeDrawer();
    }

    interface Callback {
        void onGetMoviesByGenreSuccess(List<Movie> movieList);
        void onGetMoviesByGenreError(String errorMessage);
        void onGetGenresSuccess(List<Genre> genreList);
        void onGetGenresError(String errorMessage);
        void onGetPlayingMovieSuccess(List<Movie> playingMovieList);
        void onGetPlayingMovieError(String errorMessage);
        void onGetRatedMovieSuccess(List<Movie> ratedMovieList);
        void onGetRatedMovieError(String errorMessage);
        void onGetTopMovieSuccess(List<Movie> topMovieList);
        void onGetTopMovieError(String errorMessage);
    }
}
