package com.ntsoftware.vspc.minimath.modules;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ntsoftware.vspc.minimath.R;

public class EquationFragment extends Fragment {


    public EquationFragment() {
        // Required empty public constructor
    }

    public static EquationFragment newInstance() {
        EquationFragment fragment = new EquationFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_equation, container, false);
    }
}