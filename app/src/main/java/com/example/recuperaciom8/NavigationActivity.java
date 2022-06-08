package com.example.recuperaciom8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.os.SystemClock;

import com.example.recuperaciom8.databinding.ActivityNavigationBinding;
import com.example.recuperaciom8.Fragments.FragmentFav;
import com.example.recuperaciom8.Fragments.FragmentFormSQLite;
import com.example.recuperaciom8.Fragments.FragmentHome;
import com.example.recuperaciom8.Fragments.FragmentListSQLite;
import com.example.recuperaciom8.Fragments.FragmentMaps;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NavigationActivity extends AppCompatActivity {

    private ActivityNavigationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SystemClock.sleep(1000);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_navigation);

        // Properties
        BottomNavigationView bottomNav = findViewById(R.id.main_menu);

        bottomNav.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.nav_home:
                    selectedFragment = new FragmentHome();
                    break;

                case R.id.nav_maps:
                    selectedFragment = new FragmentMaps();
                    break;

                case R.id.nav_Fav:
                    selectedFragment = new FragmentFav();
                    break;

                case R.id.nav_formSQLite:
                    selectedFragment = new FragmentFormSQLite();
                    break;

                case R.id.nav_listSQLite:
                    selectedFragment = new FragmentListSQLite();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        });
    }

}