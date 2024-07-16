package com.example.enrollmentsystem.ui.admindashboard;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.enrollmentsystem.R;

public class adding_courses extends Fragment {

    private TableLayout tableLayout;
    private Button addNewButton;
    private Button saveButton;
    private Button backButton;
    private int rowCount = 1; // Track number of rows added, starting from 1 for first_row

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_adding_course, container, false);

        tableLayout = view.findViewById(R.id.tableLayout);
        addNewButton = view.findViewById(R.id.addnew_button);
        saveButton = view.findViewById(R.id.save);
        backButton = view.findViewById(R.id.back);

        addNewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewTableRow();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConfirmationDialog();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to the previous fragment
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                fragmentManager.popBackStack();
            }
        });

        return view;
    }

    private void addNewTableRow() {
        // Create a new TableRow
        TableRow newRow = new TableRow(requireContext());
        newRow.setLayoutParams(new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT
        ));

        // Example TextViews for demonstration, customize as per your needs
        TextView textView1 = new TextView(requireContext());
        textView1.setText("New Data 1");
        textView1.setLayoutParams(new TableRow.LayoutParams(
                TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT
        ));
        textView1.setPadding(10, 10, 10, 10);
        newRow.addView(textView1);

        TextView textView2 = new TextView(requireContext());
        textView2.setText("New Data 2");
        textView2.setLayoutParams(new TableRow.LayoutParams(
                TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT
        ));
        textView2.setPadding(10, 10, 10, 10);
        newRow.addView(textView2);

        TextView textView3 = new TextView(requireContext());
        textView3.setText("New Data 3");
        textView3.setLayoutParams(new TableRow.LayoutParams(
                TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT
        ));
        textView3.setPadding(10, 10, 10, 10);
        newRow.addView(textView3);

        // Add the new TableRow below the last added row
        tableLayout.addView(newRow, rowCount);
        rowCount++;
    }

    private void showConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Confirmation");
        builder.setMessage("Are you sure you want to save these courses?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Courses saved, show message and navigate to MainActivity
                Toast.makeText(requireContext(), "Courses successfully added", Toast.LENGTH_SHORT).show();
                navigateToMainActivity();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // User clicked No, do nothing or handle as needed
            }
        });

        builder.show();
    }

    private void navigateToMainActivity() {
        // Navigate to MainActivity
        Intent intent = new Intent(requireContext(), AdminDashboard.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // Clear back stack
        startActivity(intent);
        requireActivity().finish(); // Optional: Finish current activity if needed
    }
}
