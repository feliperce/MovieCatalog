package br.com.mobileti.moviecatalog.home.genre.model;

import java.util.List;

/**
 * Created by felipe on 24/02/18.
 */

public class GenreResponse {

    private List<Genre> genres;

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
}
