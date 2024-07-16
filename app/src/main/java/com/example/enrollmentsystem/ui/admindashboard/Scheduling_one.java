package com.example.enrollmentsystem.ui.admindashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.activity.OnBackPressedCallback;

import com.example.enrollmentsystem.R;

public class Scheduling_one extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.fragment_scheduling_one);

        // Section spinner
        Spinner secSpinner = findViewById(R.id.secspin);
        ArrayAdapter<CharSequence> secAdapter = ArrayAdapter.createFromResource(this,
                R.array.sec_items, android.R.layout.simple_spinner_item);
        secAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        secSpinner.setAdapter(secAdapter);

        // Year spinner
        Spinner yearSpinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> yearAdapter = ArrayAdapter.createFromResource(this,
                R.array.year_items, android.R.layout.simple_spinner_item);
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearSpinner.setAdapter(yearAdapter);

        // Semester spinner
        Spinner semSpinner = findViewById(R.id.semspin);
        ArrayAdapter<CharSequence> semAdapter = ArrayAdapter.createFromResource(this,
                R.array.sem_items, android.R.layout.simple_spinner_item);
        semAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        semSpinner.setAdapter(semAdapter);

        Button addbtn = findViewById(R.id.button);

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Scheduling_two scheduling2Fragment = new Scheduling_two();
                navigateToFragment(scheduling2Fragment);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void navigateToFragment(Fragment fragment) {

        //Fragment fragment = new scheduling2();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();

        findViewById(R.id.sched).setVisibility(View.VISIBLE);
        findViewById(R.id.imageView).setVisibility(View.VISIBLE);
        findViewById(R.id.sec).setVisibility(View.GONE);
        findViewById(R.id.secspin).setVisibility(View.GONE);
        findViewById(R.id.sem).setVisibility(View.GONE);
        findViewById(R.id.semspin).setVisibility(View.GONE);
        findViewById(R.id.year).setVisibility(View.GONE);
        findViewById(R.id.spinner).setVisibility(View.GONE);
        findViewById(R.id.button).setVisibility(View.GONE);
        findViewById(R.id.button2).setVisibility(View.GONE);
        findViewById(R.id.fragment_container).setVisibility(View.VISIBLE); // Show the fragment container
    }

    @Override
    public void onBackPressed() {
        //Show main activity UI elements if there's only one fragment in the stack
        if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
            findViewById(R.id.sched).setVisibility(View.VISIBLE);
            findViewById(R.id.imageView).setVisibility(View.VISIBLE);
            findViewById(R.id.sec).setVisibility(View.VISIBLE);
            findViewById(R.id.secspin).setVisibility(View.VISIBLE);
            findViewById(R.id.sem).setVisibility(View.VISIBLE);
            findViewById(R.id.semspin).setVisibility(View.VISIBLE);
            findViewById(R.id.year).setVisibility(View.VISIBLE);
            findViewById(R.id.spinner).setVisibility(View.VISIBLE);
            findViewById(R.id.fragment_container).setVisibility(View.GONE);
        }
        super.onBackPressed();
    }
}

