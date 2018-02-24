package br.com.mobileti.moviecatalog.home.genre;

import java.util.List;

import br.com.mobileti.moviecatalog.BaseView;
import br.com.mobileti.moviecatalog.home.genre.model.Genre;

/**
 * Created by felipe on 24/02/18.
 */

public interface GenreMvp {

    interface Model {
        void getAllGenres();
    }

    interface View extends BaseView {
        void setGenres(List<Genre> genreList);
    }

    interface Presenter {
        void getAllGenres();
    }

    interface Callback {
        void onGetAllGenresSuccess(List<Genre> genreList);
        void onGetAllGenresError(String errorMessage);
    }
}
