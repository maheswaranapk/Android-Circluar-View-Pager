package com.scriptedpapers.androidcircularviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by mahes on 20/6/15.
 */
public abstract class CircularViewPagerBaseAdapter<Item> extends FragmentStatePagerAdapter {

    private List<Item> itemList;

    public CircularViewPagerBaseAdapter(final FragmentManager fragmentManager, final List<Item> itemList) {
        super(fragmentManager);
        this.itemList = itemList;
    }

    protected abstract Fragment getFragmentForPosition(final int item);

    @Override
    public Fragment getItem(final int position) {

        final int size = itemList.size();

        if(position == 0) {

            return getFragmentForPosition((size - 1));
        } else if(position == size + 1) {

            return getFragmentForPosition(0);
        } else {

            return getFragmentForPosition((position - 1));
        }
    }

    @Override
    public int getCount() {

        final int size = itemList.size();

        if(size > 1) {
            return  size+ 2;
        } else {
            return size;
        }
    }

}
