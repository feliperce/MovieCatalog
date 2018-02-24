package br.com.mobileti.moviecatalog.home.presenter;

import java.util.List;

import br.com.mobileti.moviecatalog.home.HomeMvp;
import br.com.mobileti.moviecatalog.home.model.GenreModel;
import br.com.mobileti.moviecatalog.home.model.Genre;

/**
 * Created by felipe on 24/02/18.
 */

public class HomePresenter implements HomeMvp.Presenter, HomeMvp.Callback {

    private HomeMvp.Model model;
    private HomeMvp.View view;

    public HomePresenter(HomeMvp.View view) {
        this.view = view;
        this.model = new GenreModel(this);
    }

    @Override
    public void getAllGenres() {
        view.startProgressBar();
        model.getAllGenres();
    }

    @Override
    public void onGetAllGenresSuccess(List<Genre> genreList) {
        view.finishProgressBar();
        view.setGenres(genreList);
    }

    @Override
    public void onGetAllGenresError(String errorMessage) {
        view.finishProgressBar();
    }
}
