package com.scriptedpapers.androidcircluarviewpagerexample.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.scriptedpapers.androidcircluarviewpagerexample.R;
import com.scriptedpapers.androidcircluarviewpagerexample.adapter.BravoPagerBaseAdapter;
import com.scriptedpapers.androidcircularviewpager.CircularViewPager;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    public CircularViewPager viewPager;

    List<Integer> bravoList;

    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (CircularViewPager) findViewById(R.id.viewPager);

        bravoList = new ArrayList<>();

        bravoList.add(0);
        bravoList.add(1);
        bravoList.add(2);

        viewPager.setAdapter(new BravoPagerBaseAdapter(getSupportFragmentManager(), bravoList));

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.d("Tag", ""+ position);
            }

            @Override
            public void onPageSelected(int position) {

                if(toast != null) {
                    toast.cancel();
                }

                toast = Toast.makeText(MainActivity.this, "Position" + position, Toast.LENGTH_SHORT);
                toast.show();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


}
