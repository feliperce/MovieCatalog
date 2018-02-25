package br.com.mobileti.moviecatalog.detail;


import br.com.mobileti.moviecatalog.BaseView;
import br.com.mobileti.moviecatalog.detail.model.MovieDetail;

/**
 * Created by felipe on 24/02/18.
 */

public interface MovieDetailMvp {

    interface Model {
        void getMovieDetail(int movieId);
    }

    interface View extends BaseView {
        void setMovie(MovieDetail movieDetail);
        int getMovieId();
        void initViews();
    }

    interface Presenter {
        void getMovieDetail(int movieId);
    }

    interface Callback {
        void onGetMovieDetailSuccess(MovieDetail movieDetail);
        void onGetMovieDetailError(String errorMessage);
    }
}
