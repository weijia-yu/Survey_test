package com.example.survey_test.survey;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.survey_test.MainActivity;
import com.example.survey_test.R;
import com.example.survey_test.databinding.FragmentSurveyBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

public class SurveyFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_survey, container, false);
        FragmentSurveyBinding binding = FragmentSurveyBinding.bind(view);
        binding.setViewModel(MainActivity.getViewModel(getActivity()));
        binding.setLifecycleOwner(getActivity());

        return binding.getRoot();
    }
}
