package com.example.ad340_hw1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class TabActivity extends AppCompatActivity implements LikeClickListener {

    private static final String TAG = TabActivity.class.getSimpleName();
    private FirebaseMatchesViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);


        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        if (b != null)
        {
            // Setting ViewPager for tabs
            ViewPager viewpager = findViewById(R.id.viewpager);
            setupViewPager(viewpager, b);

            //toolbar already given due to app creation type
            TabLayout tabs = findViewById(R.id.tabs);
            tabs.setupWithViewPager(viewpager);

            Log.i(TAG, b.getString(Constants.KEY_USERNAME)+" tabActivity");
        }

        //for single activity testing
        else{

            ViewPager viewpager = findViewById(R.id.viewpager);
            setupViewPager(viewpager, b);

            //toolbar already given due to app creation type
            TabLayout tabs = findViewById(R.id.tabs);
            tabs.setupWithViewPager(viewpager);
        }

        Log.i(TAG, "onCreate()");
    }

    //add fragments to tabs
    private void setupViewPager(ViewPager viewpager, Bundle b) {

        MatchesFragment matchesFragment = new MatchesFragment();
        ProfileFragment profileFragment = new ProfileFragment();
        SettingsFragment settingsFragment = new SettingsFragment();

        Adapter adapter = new Adapter(getSupportFragmentManager());
        adapter.addFragment(matchesFragment, "MATCHES");
        adapter.addFragment(profileFragment, "PROFILE");
        adapter.addFragment(settingsFragment, "SETTINGS");
//        adapter.addFragment(new ProfileFragment(), "PROFILE");
//        adapter.addFragment(new SettingsFragment(), "SETTINGS");

        // Add bundle to profile fragment
        adapter.getItem(1).setArguments(b); //uncomment for working app bundle passed from activity

        // Add bundle to settings fragment
        adapter.getItem(2).setArguments(b);

        viewpager.setAdapter(adapter);
    }

    @Override
    public void onLikeClick(MatchesItem item) {

    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {
            super(manager);
        }


        @Override
        public Fragment getItem(int position) {

            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


//    @Override
//    public void onListFragmentInteractionListener(MatchesItem matchesItem) {
//        //like button here
//        matchesItem.liked = !matchesItem.liked;
//    }

    //Update database on like click
    public void LikeClick(MatchesItem item) {
//        vm.update...
    }
    //when rotated onResume is called
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume()");
    }

    //call clear listeners
    @Override
    protected void onPause() {
        super.onPause();
//        vm.clear();
        Log.i(TAG, "onPause()");
    }

}
