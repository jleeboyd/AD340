package com.example.ad340_hw1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class TabActivity extends AppCompatActivity {

//    private MatchesFragment matches;

    private static final String TAG = TabActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

//          matches = findViewById(R.id.fragment_matches)
//        MatchesFragment matches = new MatchesFragment();
//        ProfileFragment profile = new ProfileFragment();
//        SettingsFragment settings = new SettingsFragment();

        // Setting ViewPager for tabs
        ViewPager viewpager = findViewById(R.id.viewpager);
        setupViewPager(viewpager);

        //toolbar already given due to app creation type
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewpager);

//        tabs.addTab(tabs.newTab().setText("MATCHES"));
//        tabs.addTab(tabs.newTab().setText("PROFILE"));
//        tabs.addTab(tabs.newTab().setText("SETTINGS"));

//        Intent intent = getIntent();
//        Bundle b = intent.getExtras();

        Log.i(TAG, "onCreate()");
    }

    //add fragments to tabs
    private void setupViewPager(ViewPager viewpager) {
        Adapter adapter = new Adapter(getSupportFragmentManager());
        adapter.addFragment(new MatchesFragment(), "MATCHES");
        adapter.addFragment(new ProfileFragment(), "PROFILE");
        adapter.addFragment(new SettingsFragment(), "SETTINGS");
        viewpager.setAdapter(adapter);
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
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
    @Override
    protected void onRestart() {
        super.onRestart();

        Log.i(TAG, "onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i(TAG, "Start()");
    }

    //when rotated onResume is called
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
    }
}
