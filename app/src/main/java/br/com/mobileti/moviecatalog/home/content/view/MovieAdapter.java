package br.com.mobileti.moviecatalog.home.content.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import br.com.mobileti.moviecatalog.R;
import br.com.mobileti.moviecatalog.home.content.model.Movie;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by felipe on 24/02/18.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private List<Movie> movieList;
    private Context context;
    private int itemLayout;

    public MovieAdapter(List<Movie> movieList, Context context) {
        this.movieList = movieList;
        this.context = context;
        itemLayout = R.layout.movie_item;
    }

    public MovieAdapter(List<Movie> movieList, Context context, int itemLayout) {
        this.movieList = movieList;
        this.context = context;
        this.itemLayout = itemLayout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(itemLayout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(context).load(
                "https://image.tmdb.org/t/p/w300/"+
                        movieList.get(position).getPosterPath()
        ).into(holder.movieImageView);

        holder.movieNameTextView.setText(
                movieList.get(position).getTitle()
        );
        holder.movieRateTextView.setText(Float.toString(
                movieList.get(position).getVoteAverage())
        );
    }

    @Override
    public int getItemCount() {
        return movieList != null ? movieList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.movieImageView) ImageView movieImageView;
        @BindView(R.id.movieNameTextView) TextView movieNameTextView;
        @BindView(R.id.movieRateTextView) TextView movieRateTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
