package com.lasalle.mdpa.architecture.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lasalle.mdpa.architecture.view.MoviesFragment;
import com.lasalle.mdpa.architecture.view.TvShowsFragment;

public class TabAdapter extends FragmentPagerAdapter {

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return MoviesFragment.newInstance();
            case 1:
                return TvShowsFragment.newInstance();
        }

        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch(position) {
            case 0:
                return "Movies";
            case 1:
                return "TvShows";
        }

        return null;
    }


    @Override
    public int getCount() {
        return 2;
    }
}
