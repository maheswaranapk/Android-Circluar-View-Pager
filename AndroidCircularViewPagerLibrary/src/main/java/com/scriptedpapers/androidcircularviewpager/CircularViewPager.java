package com.scriptedpapers.androidcircularviewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

/**
 * Created by mahes on 20/6/15.
 */
public class CircularViewPager extends ViewPager {

    private OnPageChangeListener  userPageChangeListener;
    private OnPageChangeListener pageChangeListener;

    private static final int PAGE_CHANGE_ANIM_TIME = 200;

    public CircularViewPager(Context context) {
        super(context);
        initViewPagerCircular();
    }

    public CircularViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViewPagerCircular();
    }

    @Override
    public void setOnPageChangeListener(OnPageChangeListener listener) {

        if(listener == pageChangeListener) {
            super.setOnPageChangeListener(listener);
        } else {
            userPageChangeListener = listener;
        }
    }

    void initViewPagerCircular() {

        pageChangeListener = new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                final int lastItem = getAdapter().getCount() - 1;

                if(position == 0) {
                    position = lastItem - 2;
                } else if (position == lastItem) {
                    position = 0;
                } else {
                    position = position - 1;
                }

                if(userPageChangeListener != null) {
                    userPageChangeListener.onPageScrolled(position, positionOffset, positionOffsetPixels);
                }
            }

            @Override
            public void onPageSelected(int position) {

                changeToOriginalItemWithRunnable(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

                if(userPageChangeListener != null) {
                    userPageChangeListener.onPageScrollStateChanged(state);
                }
            }
        };

        setOnPageChangeListener(pageChangeListener);
    }

    @Override
    public void setAdapter(PagerAdapter adapter) {
        super.setAdapter(adapter);
        setCurrentItem(1);
    }

    private void changeToOriginalItemWithRunnable(final int position) {

        postDelayed(new Runnable() {
            @Override
            public void run() {
                changeToOriginalItem(position);
            }
        }, PAGE_CHANGE_ANIM_TIME);
    }

    private void changeToOriginalItem(final int position) {

        final int lastItem = getAdapter().getCount() - 1;

        if(position == 0) {
            setCurrentItem((lastItem - 1), false);
        } else if(position == lastItem) {
            setCurrentItem(1, false);
        }

        if(userPageChangeListener != null) {
            userPageChangeListener.onPageSelected(getCurrentItem() - 1);
        }
    }

}
