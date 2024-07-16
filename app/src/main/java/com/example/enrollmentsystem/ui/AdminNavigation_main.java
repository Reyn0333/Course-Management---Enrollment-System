package com.example.enrollmentsystem.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.enrollmentsystem.Login_main;
import com.example.enrollmentsystem.R;
import com.example.enrollmentsystem.ui.admindashboard.adding_courses;
import com.example.enrollmentsystem.ui.createAccount.CreateAccountFragment;
import com.example.enrollmentsystem.ui.admindashboard.AdminDashboard;
import com.example.enrollmentsystem.ui.manageAccount.ManageAccountFragment;
import com.google.android.material.navigation.NavigationView;
import android.content.Intent;

public class AdminNavigation_main extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_navigation_main);

        Toolbar toolbar = findViewById(R.id.admin_toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.admin_dashboard);
        NavigationView navigationView = findViewById(R.id.admin_nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.inflateHeaderView(R.layout.nav_header);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.admin_fragment_container, new AdminDashboard()).commit();
            navigationView.setCheckedItem(R.id.admin_acc);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.admin_board) {
            getSupportFragmentManager().beginTransaction().replace(R.id.admin_fragment_container, new AdminDashboard()).commit();
        } else if (id == R.id.admin_createAcc) {
            getSupportFragmentManager().beginTransaction().replace(R.id.admin_fragment_container, new CreateAccountFragment()).commit();
        } else if (id == R.id.admin_manageAcc) {
            getSupportFragmentManager().beginTransaction().replace(R.id.admin_fragment_container, new ManageAccountFragment()).commit();
        } else if (id == R.id.admin_curr) {
            getSupportFragmentManager().beginTransaction().replace(R.id.admin_fragment_container, new adding_courses()).commit();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
