# **Android-Circluar-View-Pager**
This library is useful in making View Pager circular.

# **Usage**
For making View Pager to Scroll endless.

# **How To use**
Import **AndroidCircularViewPagerLibrary** module to the project.

In gradle file,

```
dependencies {
         compile project(':AndroidCircularViewPagerLibrary')
}
```

In Layout xml,
```xml
            <com.scriptedpapers.androidcircularviewpager.CircularViewPager
                    android:id="@+id/viewPager"
                    android:layout_width="match_parent"
                    android:layout_margin="16dp"
                    android:layout_height="match_parent"/>
```

In Adapter,
    extend Adapter to **CircularViewPagerBaseAdapter**
```
    public class BravoPagerBaseAdapter extends CircularViewPagerBaseAdapter<Integer>
```

in constructor, pass the list
```
    public BravoPagerBaseAdapter(FragmentManager fm, List<Integer> bravoArrayList) {
        super(fm, bravoArrayList);
    }
```

and return Fragment in **getFragmentForPosition(int position)**
```
    @Override
    protected Fragment getFragmentForPosition(int position) {
        return BravoFragment.newInstance(bravoArrayList, position);
    }
```

# **Output**