package com.lasalle.mdpa.architecture.view;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.lasalle.mdpa.architecture.R;
import com.lasalle.mdpa.architecture.model.Movie;
import com.lasalle.mdpa.architecture.model.TvShow;
import com.lasalle.mdpa.architecture.view.adapter.MovieListAdapter;
import com.lasalle.mdpa.architecture.view.adapter.TvShowListAdapter;
import com.lasalle.mdpa.architecture.view.model.LibraryViewModel;

import java.util.ArrayList;
import java.util.List;

public class TvShowsFragment extends Fragment {

    private LibraryViewModel libraryViewModel;

    public static TvShowsFragment newInstance() {
        TvShowsFragment fragment = new TvShowsFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        libraryViewModel = ViewModelProviders.of(getActivity()).get(LibraryViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tvshow_fragment, container, false);

        setupRecyclerView(view);

        return view;
    }

    private void setupRecyclerView(View view) {
        RecyclerView tvShowRecyclerView = (RecyclerView) view.findViewById(R.id.movie_list);
        TvShowListAdapter tvShowListAdapter = new TvShowListAdapter(getContext(), new ArrayList<TvShow>());
        tvShowRecyclerView.setAdapter(tvShowListAdapter);
        tvShowRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));

        libraryViewModel.getTvShowTitleList().observe(this, tvShowList -> {
            tvShowListAdapter.setValues(tvShowList);
            tvShowListAdapter.notifyDataSetChanged();
        });
    }
}
