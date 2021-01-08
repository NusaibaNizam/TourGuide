package org.a55889966.bleach.saran.tourguide;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

/**
 * Created by saran on 1/4/2018.
 */

public class TabPagerAdapter extends FragmentStatePagerAdapter {
    int tabCount;
    CurrentWeatherFragment currentWeatherFragment;
    ForcastWeatherFragment forcastWeatherFragment;


    public TabPagerAdapter(FragmentManager fm,
                           int tabCount,
                           CurrentWeatherFragment currentWeatherFragment,
                           ForcastWeatherFragment forcastWeatherFragment) {
        super(fm);
        this.tabCount=tabCount;
        this.currentWeatherFragment=currentWeatherFragment;
        this.forcastWeatherFragment=forcastWeatherFragment;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return currentWeatherFragment;
            case 1:
                return forcastWeatherFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabCount;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}

