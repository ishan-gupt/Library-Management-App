package com.example.librarymanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class Main_Page extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    NavigationView navigationView;
    static FragmentManager fragmentManager;
    DrawerLayout drawerLayout;
    private static final String TAG = "Main_Page";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__page);

        changeStatusBarColor("#58BBFD");
        Intent intent=getIntent();
        Bundle bundle = new Bundle();
        bundle.putString("email", intent.getStringExtra("email"));
        bundle.putString("pass", intent.getStringExtra("pass"));
        Profile fragobj = new Profile();
        fragobj.setArguments(bundle);

        navigationView=(NavigationView)findViewById(R.id.nav);
        fragmentManager=getSupportFragmentManager();
        loadFragment(new Library_books());


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        drawerLayout=findViewById(R.id.draw_layout);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(Main_Page.this,drawerLayout,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        navigationView.setNavigationItemSelectedListener(Main_Page.this);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        fragmentManager=getSupportFragmentManager();

    }

    private void changeStatusBarColor(String color){
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor(color));
        }
    }


    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_contenter, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    public void logout()
    {
        finish();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment select=null;
            switch (menuItem.getItemId())
            {
                case R.id.library_books:
                {
                    select = new Library_books();
                    Log.e(TAG, "onNavigationItemSelected: " );
                    break;
                }
                case R.id.news:
                {
                    select=new News();
                    break;
                }
                case R.id.my_books:
                {
                    select=new My_books();
                    break;
                }
                case R.id.profile:
                {
                    select=new Profile();
                    break;
                }

            }

            fragmentManager.beginTransaction().replace(R.id.fragment_contenter,select).commit();
            return true;
        };
    };



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.logout: {
                Shareprefences.getInstance(this).isLoggedOUT();
                logout();
                startActivity(new Intent(this,MainActivity.class));
            }
        }
        return true;
    }

}
