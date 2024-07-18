package com.example.enrollmentsystem.ui.registrardashboard.department;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.example.enrollmentsystem.R;

public class Department extends Fragment {

    private DepartmentViewModel mViewModel;

    public static Department newInstance() {
        return new Department();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_department, container, false);

        Spinner certificateSpinner = view.findViewById(R.id.certificate_spinner);
        ArrayAdapter<CharSequence> secAdapter = ArrayAdapter.createFromResource(
                getContext(),
                R.array.certificate_spinner,
                android.R.layout.simple_spinner_item);
        secAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        certificateSpinner.setAdapter(secAdapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DepartmentViewModel.class);
        // TODO: Use the ViewModel
    }

}