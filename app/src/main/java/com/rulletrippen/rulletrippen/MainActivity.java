package com.rulletrippen.rulletrippen;

import com.rulletrippen.rulletrippen.fragments.*;
import com.rulletrippen.rulletrippen.database.FetchFromDatabase;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
        pager.setAdapter(new AppPagerAdapter(getSupportFragmentManager()));
        pager.setCurrentItem((int)(Integer.MAX_VALUE/2));

        //new FetchFromDatabase(this);
    }

    private class AppPagerAdapter extends FragmentPagerAdapter {

        public AppPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            pos = pos % 3;

            switch(pos) {
                case 0: return RoutesFragment.newInstance();
                case 1: return ProfileFragment.newInstance();
                case 2: return SettingsFragment.newInstance();
                default: return null;
            }
        }
        @Override
        public int getCount(){
            return Integer.MAX_VALUE;
        }
    }
}
