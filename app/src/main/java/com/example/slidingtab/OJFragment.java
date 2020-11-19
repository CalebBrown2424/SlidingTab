package com.example.slidingtab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class OJFragment extends Fragment {

    private static final String argparam1 = "param1";
    private static final String argparam2 = "param2";

    private String mParam1;
    private String mParam2;

    public OJFragment() {

    }


    public static OJFragment newInstance(String param1, String param2) {
        OJFragment fragment = new OJFragment();
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
            mParam1 = getArguments().getString(argparam1);
            mParam2 = getArguments().getString(argparam2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_oj, container, false);
    }
}