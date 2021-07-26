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
import com.example.hamiltontevin_ce05.people.Student;

public class StudentFragment extends Fragment implements View.OnClickListener {
    private AddTextListener listener;

    public StudentFragment() {
    }

    public static StudentFragment newInstance() {

        Bundle args = new Bundle();

        StudentFragment fragment = new StudentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof AddTextListener){
            listener = (AddTextListener)context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_student_form,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(getView() != null){
            (getView().findViewById(R.id.btn_student)).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {

        if(getView() != null){
            EditText et_FName = getView().findViewById(R.id.et_student_firstName);
            EditText et_LName = getView().findViewById(R.id.et_student_lastName);
            EditText et_Id = getView().findViewById(R.id.et_idNum);

            String fName = et_FName.getText().toString();
            String lName = et_LName.getText().toString();
            String idString = et_Id.getText().toString();

           int idNum = Integer.parseInt(idString);

            et_FName.setText(R.string.empty);
            et_LName.setText(R.string.empty);
            et_Id.setText(R.string.empty);

            Student student = new Student(fName,lName,idNum);
            listener.addString(student.toString());


        }
    }
}
