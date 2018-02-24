package br.com.mobileti.moviecatalog.home;

import java.util.List;

import br.com.mobileti.moviecatalog.BaseView;
import br.com.mobileti.moviecatalog.home.model.Genre;

/**
 * Created by felipe on 24/02/18.
 */

public interface HomeMvp {

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
