package br.com.mobileti.moviecatalog.home.genre.presenter;

import java.util.List;

import br.com.mobileti.moviecatalog.home.genre.GenreMvp;
import br.com.mobileti.moviecatalog.home.genre.model.GenreModel;
import br.com.mobileti.moviecatalog.home.genre.model.Genre;

/**
 * Created by felipe on 24/02/18.
 */

public class HomePresenter implements GenreMvp.Presenter, GenreMvp.Callback {

    private GenreMvp.Model model;
    private GenreMvp.View view;

    public HomePresenter(GenreMvp.View view) {
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
