package br.com.mobileti.moviecatalog.detail.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import br.com.mobileti.moviecatalog.home.genre.model.Genre;

/**
 * Created by felipe on 25/02/18.
 */

public class MovieDetail {

    private boolean adult;
    @SerializedName("backdrop_path")
    private String backdropPath;
    @SerializedName("genres")
    private List<Genre> genre;
    private String homepage;
    private String overview;
    @SerializedName("release_date")
    private String releaseDate;
    private String title;
    private String status;
    @SerializedName("vote_average")
    private float voteAverage;

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public List<Genre> getGenre() {
        return genre;
    }

    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(float voteAverage) {
        this.voteAverage = voteAverage;
    }

}
