package com.lasalle.mdpa.architecture.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.lasalle.mdpa.architecture.R;
import com.lasalle.mdpa.architecture.model.Movie;
import com.lasalle.mdpa.architecture.model.TvShow;

import java.util.List;

public class TvShowListAdapter extends RecyclerView.Adapter<TvShowListAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView title;
        public TextView extraInfo;
        public ImageView image;

        public ViewHolder(View itemView)
        {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            extraInfo = (TextView) itemView.findViewById(R.id.extra_info);
            image = (ImageView) itemView.findViewById(R.id.image_view);
        }
    }

    private final Context context;
    private List<TvShow> values;
    private Integer lastPosition = -1;

    public TvShowListAdapter(Context context, List<TvShow> values) {
        this.context = context;
        this.values = values;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.series_layout, parent, false);

        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TvShow tvShow = values.get(position);

        holder.title.setText(tvShow.getTitle());

        int seasons = tvShow.getSeasons();
        if(seasons > 1) {
            holder.extraInfo.setText(tvShow.getSeasons() + " Seasons");
        }
        else {
            holder.extraInfo.setText(tvShow.getSeasons() + " Season");
        }

        if(position % 2 == 0) {
            holder.image.setImageResource(R.drawable.breaking_bad);
        }
        else {
            holder.image.setImageResource(R.drawable.soa);
        }
/*
        int currentAnimation = R.anim.movie_item_right_anim;
        if(position <= lastPosition)
        {
            currentAnimation = R.anim.movie_item_left_anim;
        }

        Animation animation = AnimationUtils.loadAnimation(context, currentAnimation);
        holder.itemView.startAnimation(animation);
        lastPosition = position;
        */
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    public void setValues(List<TvShow> values) {
        this.values = values;
    }

    @Override
    public void onViewDetachedFromWindow(ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.itemView.clearAnimation();
    }

}
