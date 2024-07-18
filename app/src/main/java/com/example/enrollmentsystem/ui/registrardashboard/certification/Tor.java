package com.example.enrollmentsystem.ui.registrardashboard.certification;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.widget.Toast;

import com.example.enrollmentsystem.R;

public class Tor extends Fragment {

    private TableLayout collegiateRecordTable;
    private Button generatePdfButton;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tor, container, false);
        initializeViews(view);
        return view;
    }

    private void initializeViews(View view) {
        collegiateRecordTable = view.findViewById(R.id.tablelayout);
        generatePdfButton = view.findViewById(R.id.btnGenerate);

        generatePdfButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generatePDF();
            }
        });

        // Example: Add a row to the collegiate record table
        addCollegiateRecordRow("1st Sem 2013-2014", "Introduction to Programming", "3", "85");
        addCollegiateRecordRow("2nd Sem 2013-2014", "Data Structures", "3", "90");
        // Add more rows as needed
    }

    private void addCollegiateRecordRow(String courseNo, String title, String units, String finalGrade) {
        TableRow row = new TableRow(getContext());
        TextView courseNoTextView = new TextView(getContext());
        courseNoTextView.setText(courseNo);
        courseNoTextView.setPadding(3, 3, 3, 3);

        TextView titleTextView = new TextView(getContext());
        titleTextView.setText(title);
        titleTextView.setPadding(3, 3, 3, 3);

        TextView unitsTextView = new TextView(getContext());
        unitsTextView.setText(units);
        unitsTextView.setPadding(3, 3, 3, 3);

        TextView finalGradeTextView = new TextView(getContext());
        finalGradeTextView.setText(finalGrade);
        finalGradeTextView.setPadding(3, 3, 3, 3);

        row.addView(courseNoTextView);
        row.addView(titleTextView);
        row.addView(unitsTextView);
        row.addView(finalGradeTextView);
        collegiateRecordTable.addView(row);
    }

    private void generatePDF() {
        // Implement your PDF generation logic here
        Toast.makeText(getContext(), "Generating PDF...", Toast.LENGTH_SHORT).show();
    }
}
