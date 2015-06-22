package com.scriptedpapers.androidcircluarviewpagerexample.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.scriptedpapers.androidcircluarviewpagerexample.R;

import java.util.List;

/**
 * Created by mahes on 20/6/15.
 */
public class BravoFragment extends Fragment {

    private int fragmentObject;

    public static final String VALUE = "PageNumber";

    public static BravoFragment newInstance(List<Integer> bravoArrayList, int position) {

        BravoFragment fragmentFirst = new BravoFragment();

        Bundle args = new Bundle();

        args.putInt(VALUE, bravoArrayList.get(position));

        fragmentFirst.setArguments(args);

        return fragmentFirst;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentObject = getArguments().getInt(VALUE, 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bravo, container, false);

        ImageView bravoImageView = (ImageView) view.findViewById(R.id.bravoImageView);
        TextView tvLabel = (TextView) view.findViewById(R.id.textView);

        tvLabel.setText(getHelperString(fragmentObject));
        bravoImageView.setImageResource(getBravo(fragmentObject));

        return view;
    }

    private int getBravo(int position) {

        if(position == 0) {
            return R.mipmap.bravo_1;
        } else if(position == 1) {
            return R.mipmap.bravo_2;
        } else if(position == 2) {
            return R.mipmap.bravo_3;
        }

        return R.mipmap.bravo_1;
    }

    private String getHelperString(int position){

        if(position == 0) {
            return "This ViewPager";
        } else if(position == 1) {
            return "is";
        } else if(position == 2) {
            return "Circular";
        }

        return "";
    }
}
