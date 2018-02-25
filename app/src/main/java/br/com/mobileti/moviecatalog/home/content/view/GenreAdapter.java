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
import br.com.mobileti.moviecatalog.home.genre.model.Genre;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by felipe on 24/02/18.
 */

public class GenreAdapter extends RecyclerView.Adapter<GenreAdapter.ViewHolder> {

    private List<Genre> genreList;
    private Context context;

    public GenreAdapter(List<Genre> genreList, Context context) {
        this.genreList = genreList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.genre_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.genreTextView.setText(
                genreList.get(position).getName()
        );

    }

    @Override
    public int getItemCount() {
        return genreList != null ? genreList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.genreTextView) TextView genreTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
