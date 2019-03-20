package com.jonasrosendo.aprendaingles.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jonasrosendo.aprendaingles.Adapter.ViewPagerAdapter;
import com.jonasrosendo.aprendaingles.R;
import com.jonasrosendo.aprendaingles.fragment.BichosFragment;
import com.jonasrosendo.aprendaingles.fragment.NumerosFragment;
import com.jonasrosendo.aprendaingles.fragment.VogaisFragment;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabs;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //retira elevação da appbar
        getSupportActionBar().setElevation(0);

        tabs = findViewById(R.id.tabs);
        pager = findViewById(R.id.pager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new BichosFragment(), "Bichos");
        adapter.addFragment(new NumerosFragment(), "Números");
        adapter.addFragment(new VogaisFragment(), "Vogais");

        pager.setAdapter(adapter);
        tabs.setupWithViewPager(pager);
    }

}
