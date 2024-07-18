package com.example.enrollmentsystem.ui.admindashboard.yearend_semester;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.enrollmentsystem.R;

public class Yearend_Semester extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_yearend__semester, container, false);

        Button backButton = view.findViewById(R.id.back);
        Button saveButton = view.findViewById(R.id.save);
        EditText yearLevelEditText = view.findViewById(R.id.year_level_textbox);
        EditText semesterEditText = view.findViewById(R.id.semester_textbox);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go back to the previous fragment
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String yearLevel = yearLevelEditText.getText().toString();
                String semester = semesterEditText.getText().toString();
                showConfirmationDialog();
            }
        });

        return view;
    }

    private void showConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Confirm");
        builder.setMessage("Are you sure you want to add this Year level and Semester?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getContext(), "Year Level and Semester successfully added", Toast.LENGTH_SHORT).show();
                loadNextFragment();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Do nothing, just dismiss the dialog
            }
        });
        builder.show();
    }

    private void loadNextFragment() {
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new YearendSemesterList())
                .addToBackStack(null)
                .commit();
    }
}
