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
import com.example.enrollmentsystem.ui.admindashboard.AdminDashboard;
import com.example.enrollmentsystem.ui.manageAccount.ManageAccountFragment;
import com.example.enrollmentsystem.ui.registrardashboard.RegistrarDashboard;
import com.example.enrollmentsystem.ui.registrardashboard.department.Department;
import com.google.android.material.navigation.NavigationView;
import android.content.Intent;

public class RegistrarNavigation_main extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar_navigation_main);

        Toolbar toolbar = findViewById(R.id.registrar_toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.registrar_dashboard);
        NavigationView navigationView = findViewById(R.id.registrar_nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.inflateHeaderView(R.layout.nav_header);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.registrar_fragment_container, new RegistrarDashboard()).commit();
            navigationView.setCheckedItem(R.id.registrar_acc);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.registrar_board) {
            getSupportFragmentManager().beginTransaction().replace(R.id.registrar_fragment_container, new AdminDashboard()).commit();
        } else if (id == R.id.registrar_createAcc) {
            getSupportFragmentManager().beginTransaction().replace(R.id.registrar_fragment_container, new CreateAccountFragment()).commit();
        } else if (id == R.id.registrar_manageAcc) {
            getSupportFragmentManager().beginTransaction().replace(R.id.registrar_fragment_container, new ManageAccountFragment()).commit();
        }else if (id == R.id.registrar_certificates){
            getSupportFragmentManager().beginTransaction().replace(R.id.registrar_fragment_container, new Department()).commit();
        } else if (id == R.id.registrar_logout) {
            Intent intent = new Intent (this, Login_main.class);
            startActivity(intent);
            finish();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
