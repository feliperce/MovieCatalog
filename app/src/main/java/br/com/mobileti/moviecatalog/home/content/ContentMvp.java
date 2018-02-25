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
        void getPlayingMovies();
        void getRatedMovies();
        void getTopMovies();
    }

    interface View extends BaseView {
        void setPlayingMovies(List<Movie> playingMovieList);
        void setRatedMovies(List<Movie> ratedMovieList);
        void setTopMovies(List<Movie> topMovieList);
        void setAdapters();
    }

    interface Presenter {
        void getPlayingMovies();
        void getRatedMovies();
        void getTopMovies();
    }

    interface Callback {
        void onGetPlayingMovieSuccess(List<Movie> playingMovieList);
        void onGetPlayingMovieError(String errorMessage);
        void onGetRatedMovieSuccess(List<Movie> ratedMovieList);
        void onGetRatedMovieError(String errorMessage);
        void onGetTopMovieSuccess(List<Movie> topMovieList);
        void onGetTopMovieError(String errorMessage);
    }
}
