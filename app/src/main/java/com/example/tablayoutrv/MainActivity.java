package com.example.tablayoutrv;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tablayout_id);
        viewPager = findViewById(R.id.viewpager_id);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        // Add Fragment Here
        adapter.AddFragment(new FragmentBookBank(),"");
        adapter.AddFragment(new FragmentIssue(),"");
        adapter.AddFragment(new FragmentFine(),"");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_bookbank);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_issue);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_fine);

        //Remove Shadow From the action bar

        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);
    }
}
