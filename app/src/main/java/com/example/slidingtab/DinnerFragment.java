package com.example.slidingtab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class DinnerFragment extends Fragment {

    private static final String argparam1 = "param1";
    private static final String argparam2 = "param2";

    private String parameter1;
    private String parameter2;

    public DinnerFragment() {
    }


    public static DinnerFragment newInstance(String param1, String param2) {
        DinnerFragment fragment = new DinnerFragment();
        Bundle args = new Bundle();
        args.putString(argparam1, param1);
        args.putString(argparam2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            parameter1 = getArguments().getString(argparam1);
            parameter2 = getArguments().getString(argparam2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_dinner, container, false);
    }
}