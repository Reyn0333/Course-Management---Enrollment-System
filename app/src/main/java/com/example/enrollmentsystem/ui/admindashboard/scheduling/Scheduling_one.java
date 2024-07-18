package com.example.enrollmentsystem.ui.admindashboard.scheduling;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.enrollmentsystem.R;

public class Scheduling_one extends Fragment {

    public Scheduling_one() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scheduling_one, container, false);

        // Section spinner
        Spinner secSpinner = view.findViewById(R.id.secspin);
        ArrayAdapter<CharSequence> secAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.sec_items, android.R.layout.simple_spinner_item);
        secAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        secSpinner.setAdapter(secAdapter);

        // Year spinner
        Spinner yearSpinner = view.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> yearAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.year_items, android.R.layout.simple_spinner_item);
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearSpinner.setAdapter(yearAdapter);

        // Semester spinner
        Spinner semSpinner = view.findViewById(R.id.semspin);
        ArrayAdapter<CharSequence> semAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.sem_items, android.R.layout.simple_spinner_item);
        semAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        semSpinner.setAdapter(semAdapter);

        Button addbtn = view.findViewById(R.id.button);

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Scheduling_two scheduling2Fragment = new Scheduling_two();
                navigateToFragment(scheduling2Fragment);
            }
        });
        return view;
    }

    private void navigateToFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
}
