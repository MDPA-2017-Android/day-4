package com.lasalle.mdpa.architecture.view;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lasalle.mdpa.architecture.R;
import com.lasalle.mdpa.architecture.model.Movie;
import com.lasalle.mdpa.architecture.view.adapter.MovieListAdapter;
import com.lasalle.mdpa.architecture.view.model.LibraryViewModel;

import java.util.ArrayList;

public class MoviesFragment extends Fragment {

    private LibraryViewModel libraryViewModel;

    public static MoviesFragment newInstance() {
        MoviesFragment fragment = new MoviesFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        libraryViewModel = ViewModelProviders.of(getActivity()).get(LibraryViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movies_fragment, container, false);

        setupRecyclerView(view);

        return view;
    }

    private void setupRecyclerView(View view) {
        RecyclerView movieRecyclerView = (RecyclerView) view.findViewById(R.id.movie_list);
        MovieListAdapter movieListAdapter = new MovieListAdapter(getContext(), new ArrayList<Movie>());
        movieRecyclerView.setAdapter(movieListAdapter);
        movieRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        libraryViewModel.getMovieTitleList().observe(this, movieTitleList -> {
            movieListAdapter.setValues(movieTitleList);
            movieListAdapter.notifyDataSetChanged();
        });
    }
}
