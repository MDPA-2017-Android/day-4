package com.lasalle.mdpa.architecture.view;

import android.content.res.Resources;

import java.util.List;

public interface MainView {

    void populateMovies(List<String> movies);
    void populateTvShows(List<String> tvShows);

    Resources getResources();

}
