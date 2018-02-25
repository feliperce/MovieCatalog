package br.com.mobileti.moviecatalog;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.Group;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.mobileti.moviecatalog.detail.view.DetailActivity;
import br.com.mobileti.moviecatalog.home.content.ContentMvp;
import br.com.mobileti.moviecatalog.home.content.model.Movie;
import br.com.mobileti.moviecatalog.home.content.presenter.ContentPresenter;
import br.com.mobileti.moviecatalog.home.content.view.GenreAdapter;
import br.com.mobileti.moviecatalog.home.content.view.MovieAdapter;
import br.com.mobileti.moviecatalog.home.genre.model.Genre;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements ContentMvp.View {

    public static String MOVIE_ID_EXTRA = "movieId";

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.emptyMovieTextView) TextView emptyMovieTextView;
    @BindView(R.id.playingGroup) Group playingGroup;
    @BindView(R.id.topGroup) Group topGroup;
    @BindView(R.id.ratedGroup) Group ratedGroup;
    @BindView(R.id.progressBar) ProgressBar progressBar;
    @BindView(R.id.drawer_layout) DrawerLayout drawer;
    @BindView(R.id.nav_view) NavigationView navigationView;
    @BindView(R.id.genreRecyclerView) RecyclerView genreRecyclerView;
    @BindView(R.id.playingRecyclerView) RecyclerView playingRecyclerView;
    @BindView(R.id.topRecyclerView) RecyclerView topRecyclerView;
    @BindView(R.id.ratedRecyclerView) RecyclerView ratedRecyclerView;
    @BindView(R.id.moviesByGenreRecyclerView) RecyclerView moviesByGenreRecyclerView;
    private int progress;
    private ContentMvp.Presenter presenter;
    private GenreAdapter genreAdapter;
    private MovieAdapter playingMovieAdapter;
    private MovieAdapter topMovieAdapter;
    private MovieAdapter ratedMovieAdapter;
    private MovieAdapter movieByGenreAdapter;
    private List<Genre> genreList;
    private List<Movie> playingMovieList;
    private List<Movie> topMovieList;
    private List<Movie> ratedMovieList;
    private List<Movie> movieByGenreList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        presenter = new ContentPresenter(this);
        
        setAdapters();
        startProgressBar();

        presenter.getGenre();
        presenter.getPlayingMovies();
        presenter.getTopMovies();
        presenter.getRatedMovies();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void startProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
        progress = 0;
    }

    @Override
    public void increaseProgress() {
        progress++;
        if(progress == 4) {
            progressBar.setVisibility(View.GONE);
            progress = 0;
            if(isMovieEmpty()) {
                emptyMovieTextView.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void setMoviesByGenre(List<Movie> movieList) {
        playingGroup.setVisibility(View.GONE);
        topGroup.setVisibility(View.GONE);
        ratedGroup.setVisibility(View.GONE);
        moviesByGenreRecyclerView.setVisibility(View.VISIBLE);
        this.movieByGenreList.clear();
        this.movieByGenreList.addAll(movieList);
        movieByGenreAdapter.notifyDataSetChanged();

    }

    @Override
    public void setGenres(List<Genre> genreList) {
        this.genreList.clear();
        this.genreList.addAll(genreList);
        genreAdapter.notifyDataSetChanged();
    }

    @Override
    public void setPlayingMovies(List<Movie> playingMovieList) {
        playingGroup.setVisibility(View.VISIBLE);
        this.playingMovieList.clear();
        this.playingMovieList.addAll(playingMovieList);
        playingMovieAdapter.notifyDataSetChanged();
    }

    @Override
    public void setRatedMovies(List<Movie> ratedMovieList) {
        ratedGroup.setVisibility(View.VISIBLE);
        this.ratedMovieList.clear();
        this.ratedMovieList.addAll(ratedMovieList);
        ratedMovieAdapter.notifyDataSetChanged();
    }

    @Override
    public void setTopMovies(List<Movie> topMovieList) {
        topGroup.setVisibility(View.VISIBLE);
        this.topMovieList.clear();
        this.topMovieList.addAll(topMovieList);
        topMovieAdapter.notifyDataSetChanged();
    }

    @Override
    public void setAdapters() {
        genreList = new ArrayList<>();
        playingMovieList = new ArrayList<>();
        ratedMovieList = new ArrayList<>();
        topMovieList = new ArrayList<>();
        movieByGenreList = new ArrayList<>();

        LinearLayoutManager genreLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        LinearLayoutManager playingLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager ratedLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager topLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);
        StaggeredGridLayoutManager moviesByGenreLayoutManager = new StaggeredGridLayoutManager(
                2, StaggeredGridLayoutManager.VERTICAL
        );

        genreAdapter = new GenreAdapter(genreList, this, presenter);
        playingMovieAdapter = new MovieAdapter(playingMovieList, this, presenter);
        ratedMovieAdapter = new MovieAdapter(ratedMovieList, this, presenter);
        topMovieAdapter = new MovieAdapter(topMovieList, this, presenter);
        movieByGenreAdapter = new MovieAdapter(movieByGenreList,
                this, presenter, R.layout.movie_by_genre_item);

        genreRecyclerView.setLayoutManager(genreLayoutManager);
        genreRecyclerView.setAdapter(genreAdapter);

        playingRecyclerView.setLayoutManager(playingLayoutManager);
        playingRecyclerView.setAdapter(playingMovieAdapter);

        ratedRecyclerView.setLayoutManager(ratedLayoutManager);
        ratedRecyclerView.setAdapter(ratedMovieAdapter);

        topRecyclerView.setLayoutManager(topLayoutManager);
        topRecyclerView.setAdapter(topMovieAdapter);

        moviesByGenreRecyclerView.setLayoutManager(moviesByGenreLayoutManager);
        moviesByGenreRecyclerView.setAdapter(movieByGenreAdapter);

    }

    @Override
    public void closeDrawer() {
        drawer.closeDrawer(GravityCompat.START);
    }

    @Override
    public boolean isMovieEmpty() {
        return playingGroup.getVisibility() == View.GONE &&
                ratedGroup.getVisibility() == View.GONE &&
                topGroup.getVisibility() == View.GONE;
    }

    @Override
    public void initViews() {
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

    }

    @Override
    public void openMovieDetail(int movieId) {
        Intent it = new Intent(this, DetailActivity.class);
        it.putExtra(MOVIE_ID_EXTRA, movieId);
        startActivity(it);
    }

}
