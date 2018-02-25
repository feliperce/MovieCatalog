package br.com.mobileti.moviecatalog.detail.view;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import br.com.mobileti.moviecatalog.BaseActivity;
import br.com.mobileti.moviecatalog.MainActivity;
import br.com.mobileti.moviecatalog.R;
import br.com.mobileti.moviecatalog.detail.MovieDetailMvp;
import br.com.mobileti.moviecatalog.detail.model.MovieDetail;
import br.com.mobileti.moviecatalog.detail.presenter.MovieDetailPresenter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends BaseActivity implements MovieDetailMvp.View {

    @BindView(R.id.imageProgressBar) ProgressBar imageProgressBar;
    @BindView(R.id.movieProgressBar) ProgressBar movieProgressBar;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.movieImageView) ImageView movieImageView;
    @BindView(R.id.movieRateTextView) TextView movieRateTextView;
    @BindView(R.id.movieStatusTextView) TextView movieStatusTextView;
    @BindView(R.id.movieReleaseTextView) TextView movieReleaseTextView;
    @BindView(R.id.movieOverviewTextView) TextView movieOverviewTextView;
    private MovieDetailMvp.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initViews();

        presenter = new MovieDetailPresenter(this);
        presenter.getMovieDetail(getMovieId());
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void startProgressBar() {
        movieProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void increaseProgress() {
        movieProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void setMovie(MovieDetail movieDetail) {

        Glide.with(this).load(
                "https://image.tmdb.org/t/p/w300"+
                        movieDetail.getBackdropPath()
        ).listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                imageProgressBar.setVisibility(View.GONE);
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                imageProgressBar.setVisibility(View.GONE);
                return false;
            }
        }).into(movieImageView);

        toolbar.setTitle(movieDetail.getTitle());
        movieReleaseTextView.setText(movieDetail.getReleaseDate());
        movieRateTextView.setText(Float.toString(movieDetail.getVoteAverage()));
        movieStatusTextView.setText(movieDetail.getStatus());
        movieOverviewTextView.setText(movieDetail.getOverview());
    }

    @Override
    public int getMovieId() {
        return getIntent().getIntExtra(MainActivity.MOVIE_ID_EXTRA, 0);
    }

    @Override
    public void initViews() {
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
    }
}
