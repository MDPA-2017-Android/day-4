package com.lasalle.mdpa.architecture.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.lasalle.mdpa.architecture.R;
import com.lasalle.mdpa.architecture.model.Movie;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView title;
        public TextView extraInfo;

        public ViewHolder(View itemView)
        {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            extraInfo = (TextView) itemView.findViewById(R.id.extra_info);

        }
    }

    private final Context context;
    private List<Movie> values;
    private Integer lastPosition = -1;

    public MovieListAdapter(Context context, List<Movie> values) {
        this.context = context;
        this.values = values;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.movie_layout, parent, false);

        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie movie = values.get(position);

        holder.title.setText(movie.getTitle());
        holder.extraInfo.setText(movie.getDirector() + " - " + Integer.toString(movie.getReleaseYear()));

        int currentAnimation = R.anim.movie_item_right_anim;
        if(position <= lastPosition)
        {
            currentAnimation = R.anim.movie_item_left_anim;
        }

        Animation animation = AnimationUtils.loadAnimation(context, currentAnimation);
        holder.itemView.startAnimation(animation);
        lastPosition = position;
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    public void setValues(List<Movie> values) {
        this.values = values;
    }

    @Override
    public void onViewDetachedFromWindow(ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.itemView.clearAnimation();
    }

}
