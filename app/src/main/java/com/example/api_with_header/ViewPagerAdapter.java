package com.example.api_with_header;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.example.api_with_header.fragment.HomeFragment;
import com.example.api_with_header.fragment.MapFragment;
import com.example.api_with_header.fragment.ScheduleFragment;


public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position == 0) {
            return new HomeFragment();
        } else if (position == 1) {
            return new MapFragment();
        } else if (position == 2) {
            return new ScheduleFragment();
        } else {
            return new HomeFragment();
        }
    }
    @Override
    public int getCount() {
        return 3;
    }
}
