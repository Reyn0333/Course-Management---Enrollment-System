package com.example.enrollmentsystem.ui.instructordashboard.instructorClassList;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.enrollmentsystem.R;
import com.example.enrollmentsystem.ui.instructordashboard.InstructorDashboard;

public class InstructorClassList extends Fragment {

    private InstructorClassListViewModel mViewModel;

    public static InstructorClassList newInstance() {
        return new InstructorClassList();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_instructor_classlist, container, false);

        Button addbtn = view.findViewById(R.id.instructor_addButton);
        addbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view1) {
                showFirstDialog();
            }
        });
        return  view;
    }

    private void showFirstDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Confirmation")
                .setMessage("Are you sure you want to add this?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(InstructorClassListViewModel.class);
        // TODO: Use the ViewModel
    }
}