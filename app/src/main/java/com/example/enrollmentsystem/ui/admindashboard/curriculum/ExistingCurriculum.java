package com.example.enrollmentsystem.ui.admindashboard.curriculum;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.enrollmentsystem.R;

public class ExistingCurriculum extends Fragment {

    private ExistingCurriculumViewModel mViewModel;

    public static ExistingCurriculum newInstance() {
        return new ExistingCurriculum();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_existing_curriculum, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ExistingCurriculumViewModel.class);
        // TODO: Use the ViewModel
    }

}