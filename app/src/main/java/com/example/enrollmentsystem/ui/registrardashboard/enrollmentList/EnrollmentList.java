package com.example.enrollmentsystem.ui.registrardashboard.enrollmentList;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.enrollmentsystem.R;

public class EnrollmentList extends Fragment {

    // Declare UI elements
    private TextView periodTextView, courseTextView, sectionTextView, departmentTextView, yearTextView;
    private EditText periodEditText, courseEditText, sectionEditText, departmentEditText, yearEditText;

    // Rename parameter arguments, choose names that match the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EnrollmentList() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Enrollment_list.
     */
    public static EnrollmentList newInstance(String param1, String param2) {
        EnrollmentList fragment = new EnrollmentList();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_enrollment_list, container, false);

        // Initialize UI elements
        periodTextView = view.findViewById(R.id.textView2);
        periodEditText = view.findViewById(R.id.editText);
        courseTextView = view.findViewById(R.id.textView3);
        courseEditText = view.findViewById(R.id.editText2);
        sectionTextView = view.findViewById(R.id.textView4);
        sectionEditText = view.findViewById(R.id.editText3);
        departmentTextView = view.findViewById(R.id.textView5);
        departmentEditText = view.findViewById(R.id.editText4);
        yearTextView = view.findViewById(R.id.textView6);
        yearEditText = view.findViewById(R.id.editText5);

        // Example usage: Setting text programmatically
        periodEditText.setText("Spring 2024");
        courseEditText.setText("Computer Science");
        sectionEditText.setText("A1");
        departmentEditText.setText("Engineering");
        yearEditText.setText("1st Year");

        // Example usage: Getting text programmatically
        String period = periodEditText.getText().toString();
        String course = courseEditText.getText().toString();
        String section = sectionEditText.getText().toString();
        String department = departmentEditText.getText().toString();
        String year = yearEditText.getText().toString();

        // Add any required logic here

        return view;
    }
}
