package br.com.mobileti.moviecatalog;

import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Group;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import br.com.mobileti.moviecatalog.home.content.ContentMvp;
import br.com.mobileti.moviecatalog.home.content.model.Movie;
import br.com.mobileti.moviecatalog.home.content.presenter.ContentPresenter;
import br.com.mobileti.moviecatalog.home.content.view.MovieAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, ContentMvp.View {

    @BindView(R.id.playingGroup) Group playingGroup;
    @BindView(R.id.topGroup) Group topGroup;
    @BindView(R.id.ratedGroup) Group ratedGroup;
    @BindView(R.id.progressBar) ProgressBar progressBar;
    @BindView(R.id.playingRecyclerView) RecyclerView playingRecyclerView;
    @BindView(R.id.topRecyclerView) RecyclerView topRecyclerView;
    @BindView(R.id.ratedRecyclerView) RecyclerView ratedRecyclerView;
    private int progress;
    private ContentMvp.Presenter presenter;
    private MovieAdapter playingMovieAdapter;
    private MovieAdapter topMovieAdapter;
    private MovieAdapter ratedMovieAdapter;
    private List<Movie> playingMovieList;
    private List<Movie> topMovieList;
    private List<Movie> ratedMovieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        setAdapters();

        startProgressBar();
        presenter = new ContentPresenter(this);
        presenter.getPlayingMovies();
        presenter.getTopMovies();
        presenter.getRatedMovies();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void startProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
        progress = 0;
    }

    @Override
    public void increaseProgress() {
        progress++;
        if(progress == 3) {
            progressBar.setVisibility(View.GONE);
        }
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
        playingMovieList = new ArrayList<>();
        ratedMovieList = new ArrayList<>();
        topMovieList = new ArrayList<>();

        LinearLayoutManager playingLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager ratedLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager topLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);


        playingMovieAdapter = new MovieAdapter(playingMovieList, this);
        ratedMovieAdapter = new MovieAdapter(ratedMovieList, this);
        topMovieAdapter = new MovieAdapter(topMovieList, this);

        playingRecyclerView.setLayoutManager(playingLayoutManager);
        playingRecyclerView.setAdapter(playingMovieAdapter);

        ratedRecyclerView.setLayoutManager(ratedLayoutManager);
        ratedRecyclerView.setAdapter(ratedMovieAdapter);

        topRecyclerView.setLayoutManager(topLayoutManager);
        topRecyclerView.setAdapter(topMovieAdapter);

    }
}
