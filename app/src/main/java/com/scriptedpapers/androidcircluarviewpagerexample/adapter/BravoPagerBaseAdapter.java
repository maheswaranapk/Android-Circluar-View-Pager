package com.scriptedpapers.androidcircluarviewpagerexample.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;


import com.scriptedpapers.androidcircluarviewpagerexample.fragment.BravoFragment;
import com.scriptedpapers.androidcircularviewpager.CircularViewPagerBaseAdapter;

import java.util.List;

/**
 * Created by mahes on 31/5/15.
 */
public class BravoPagerBaseAdapter extends CircularViewPagerBaseAdapter<Integer> {

    private List<Integer> bravoArrayList;

    public BravoPagerBaseAdapter(FragmentManager fm, List<Integer> bravoArrayList) {
        super(fm, bravoArrayList);
        this.bravoArrayList = bravoArrayList;
    }

    @Override
    protected Fragment getFragmentForPosition(int position) {
        return BravoFragment.newInstance(bravoArrayList, position);
    }

}
