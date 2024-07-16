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
import com.example.enrollmentsystem.ui.createAccount.CreateAccountFragment;
import com.example.enrollmentsystem.ui.instructordashboard.InstructorDashboard;
import com.example.enrollmentsystem.ui.instructordashboard.instructorClassList.InstructorClassList;
import com.example.enrollmentsystem.ui.instructordashboard.instructorSchedule.InstructorSchedule;
import com.example.enrollmentsystem.ui.manageAccount.ManageAccountFragment;
import com.google.android.material.navigation.NavigationView;

public class InstructorNavigation_main extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructor_navigation_main);

        Toolbar toolbar = findViewById(R.id.instructor_toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.instructor_dashboard);
        NavigationView navigationView = findViewById(R.id.instructor_nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.inflateHeaderView(R.layout.nav_header);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.instructor_fragment_container, new InstructorDashboard()).commit();
            navigationView.setCheckedItem(R.id.instructor_board);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.instructor_board) {
            getSupportFragmentManager().beginTransaction().replace(R.id.instructor_fragment_container, new InstructorDashboard()).commit();
        } else if (id == R.id.instructor_classlist) {
            getSupportFragmentManager().beginTransaction().replace(R.id.instructor_fragment_container, new InstructorClassList()).commit();
        } else if (id == R.id.instructor_sched) {
            getSupportFragmentManager().beginTransaction().replace(R.id.instructor_fragment_container, new InstructorSchedule()).commit();
        } else if (id == R.id.instructor_gradeSheet) {
            getSupportFragmentManager().beginTransaction().replace(R.id.instructor_fragment_container, new ManageAccountFragment()).commit();
        } else if (id == R.id.instructor_setting) {
            getSupportFragmentManager().beginTransaction().replace(R.id.instructor_fragment_container, new CreateAccountFragment()).commit();
        } else if (id == R.id.instructor_logout) {
            Intent intent = new Intent (this, Login_main.class);
            startActivity(intent);
            finish();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
