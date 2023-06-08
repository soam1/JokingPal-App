package com.akashsoam.jokesapp.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.akashsoam.jokesapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FavJokesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FavJokesFragment extends Fragment {

//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";

//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;

    public FavJokesFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static FavJokesFragment newInstance() {
        FavJokesFragment fragment = new FavJokesFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fav_jokes, container, false);
    }
}