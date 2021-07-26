package com.example.hamiltontevin_ce05.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import com.example.hamiltontevin_ce05.R;

import java.util.ArrayList;

public class MainDisplayFragment extends ListFragment {
    private static final String ARG_PEOPLE_LIST = "ARG_PEOPLE_LIST";

    public MainDisplayFragment() {
    }

    public static MainDisplayFragment newInstance(ArrayList<String> people) {

        Bundle args = new Bundle();
        args.putStringArrayList(ARG_PEOPLE_LIST,people);

        MainDisplayFragment fragment = new MainDisplayFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail_list,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if(getArguments() != null){
            ArrayList<String> people = getArguments().getStringArrayList(ARG_PEOPLE_LIST);

            if(people != null && getContext() != null){
                ArrayAdapter<String> adapter = new ArrayAdapter<>(
                        getContext(),
                        android.R.layout.simple_expandable_list_item_1,
                        people
                );
                setListAdapter(adapter);

            }
        }
    }
}
