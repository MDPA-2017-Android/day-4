package com.lasalle.mdpa.architecture.view;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.lasalle.mdpa.architecture.R;
import com.lasalle.mdpa.architecture.view.adapter.TabAdapter;
import com.lasalle.mdpa.architecture.view.model.LibraryViewModel;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LibraryViewModel libraryViewModel = ViewModelProviders.of(this).get(LibraryViewModel.class);
        libraryViewModel.setResources(getResources());

        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initFragmentManager();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.mi_add:
                Toast.makeText(this, "Option not available yet", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch(item.getItemId())
        {
            case R.id.action_movies:
                fragment = MoviesFragment.newInstance();
                break;

            case R.id.action_tvshows:
                fragment = TvShowsFragment.newInstance();
                break;
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit();

        item.setChecked(true);
        setTitle(item.getTitle());

        return true;
    }

    private void initFragmentManager() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        MoviesFragment fragment = MoviesFragment.newInstance();
        fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit();
    }
}
