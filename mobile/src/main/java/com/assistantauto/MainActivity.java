package com.assistantauto;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.assistantauto.fragments.MapFragment;
import com.assistantauto.fragments.NewsFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements MapFragment.OnMapListener, NewsFragment.OnNewsListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private Fragment current;
    private GoogleMap map;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_assistant: {
                    current = MapFragment.newInstance();
                    getFragmentManager().beginTransaction().replace(R.id.container, current).commit();
                    return true;
                }
                case R.id.nav_news: {
                    current = NewsFragment.newInstance();
                    getFragmentManager().beginTransaction().replace(R.id.container, current).commit();
                    return true;
                }
                case R.id.nav_books: {
                    current = MapFragment.newInstance();
                    getFragmentManager().beginTransaction().replace(R.id.container, current).commit();
                    return true;
                }
                case R.id.nav_music: {
                    current = NewsFragment.newInstance();
                    getFragmentManager().beginTransaction().replace(R.id.container, current).commit();
                    return true;
                }
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        current = MapFragment.newInstance();
        getFragmentManager().beginTransaction().add(R.id.container, current).commit();
    }

    @Override
    public void onNewsItem(Uri uri) {

    }

    @Override
    public void onMapReaded(GoogleMap aMap) {
        map = aMap;
        map.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(43.1f, 87.9f)));
    }

    @Override
    public void onRoadSelected(Uri uri) {

    }
}
