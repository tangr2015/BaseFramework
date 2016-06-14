package com.tangr.baseframework;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        ViewPager vp = (ViewPager) findViewById(R.id.viewpager);
        vp.setOffscreenPageLimit(1);
        vp.setAdapter(adapter);
    }

    class PagerAdapter extends FragmentStatePagerAdapter {
        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            Log.e("tangr","getItem:" + position);
            return SampleFragment.newInstance(position);
        }
        @Override
        public int getCount() {
            return 5;
        }
    }
}
