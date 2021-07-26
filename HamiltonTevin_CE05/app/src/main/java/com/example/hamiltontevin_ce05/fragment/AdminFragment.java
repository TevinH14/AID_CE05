package com.example.hamiltontevin_ce05.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.hamiltontevin_ce05.AddTextListener;
import com.example.hamiltontevin_ce05.R;
import com.example.hamiltontevin_ce05.people.Admin;

public class AdminFragment extends Fragment implements View.OnClickListener {
    private AddTextListener listener;
    public AdminFragment() {
    }

    public static AdminFragment newInstance() {

        Bundle args = new Bundle();

        AdminFragment fragment = new AdminFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof AddTextListener){
            listener =(AddTextListener)context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_admin_form,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(getView() != null){
            (getView().findViewById(R.id.btn_Admin)).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        if(getView() != null){
            EditText et_FName = getView().findViewById(R.id.et_Admin_firstName);
            EditText et_LName = getView().findViewById(R.id.et_Admin_lastName);
            EditText et_program = getView().findViewById(R.id.et_program);

            String fName = et_FName.getText().toString();
            String lName = et_LName.getText().toString();
            String program = et_program.getText().toString();

            et_FName.setText(R.string.empty);
            et_LName.setText(R.string.empty);
            et_program.setText(R.string.empty);

            Admin admin = new Admin(fName,lName,program);



            listener.addString(admin.toString());
        }
    }
}
