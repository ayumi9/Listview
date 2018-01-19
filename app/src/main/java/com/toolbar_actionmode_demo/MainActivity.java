package com.toolbar_actionmode_demo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private static ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        setupViewPager(viewPager);//Set up View Pager

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);//setting tab over viewpager
    }


    //Setting View Pager
    private void setupViewPager(ViewPager viewPager) {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new ListView_Fragment(), "通知");
        adapter.addFrag(new RecyclerView_Fragment(), "行った");
        adapter.addFrag(new RecyclerView_Fragment2(), "行きたい");
        viewPager.setAdapter(adapter);
    }


    //Return current fragment on basis of Position
    public Fragment getFragment(int pos) {
        return adapter.getItem(pos);
    }

}
