package com.coursera.pets;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;

import com.google.android.material.tabs.TabLayout;
import com.coursera.pets.adapters.PageAdapter;
import com.coursera.pets.fragments.ProfilePetFragment;
import com.coursera.pets.fragments.RecyclerviewFragment;

public class MainActivity extends AppCompatActivity {

    private ImageView ivBoneWhite;
    private ImageView ivBoneOrange;
    private TextView tvRating;
    private ImageView ivFavoritesPets;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        androidx.appcompat.widget.Toolbar toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ivFavoritesPets = (ImageView) findViewById(R.id.ivFavoritesPets);
        FavoritesPets();

        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        if(toolbar != null){
            setSupportActionBar(toolbar);

            SetUpViewPager();
        }
    }

    private ArrayList<Fragment> addFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerviewFragment());
        fragments.add(new ProfilePetFragment());
        return fragments;
    }

    private void SetUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), addFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_profile);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mAbout:
                Intent iAbout = new Intent(this, About.class);
                startActivity(iAbout);
                break;
            case R.id.mContact:
                Intent iContact = new Intent(this, Contact.class);
                startActivity(iContact);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void FavoritesPets(){
        ivFavoritesPets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FavoritesPets.class);
                startActivity(intent);
            }
        });
    }
}