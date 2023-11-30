package com.sakibpractice.mytube;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ChipNavigationBar chipNavigationBar =findViewById(R.id.chipNavigationBar);

        HomeFragment homeFragment = new HomeFragment();
        ProfileFragment profileFragment = new ProfileFragment();


        chipNavigationBar.setItemSelected(R.id.home,true);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.framelayout,homeFragment)
                .commit();

        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                if (i== R.id.home){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.framelayout,homeFragment)
                            .commit();
                }else if (i == R.id.profile){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.framelayout,profileFragment)
                            .commit();
                }
            }
        });
    }
}