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
import com.example.hamiltontevin_ce05.people.Teacher;

public class TeacherFragment extends Fragment implements View.OnClickListener {

    private AddTextListener listener;

    public TeacherFragment() {
    }

    public static TeacherFragment newInstance() {

        Bundle args = new Bundle();

        TeacherFragment fragment = new TeacherFragment();
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
        return inflater.inflate(R.layout.fragment_teacher_form,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(getView() != null){
            (getView().findViewById(R.id.btn_Teacher)).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        if(getView() != null) {
            EditText et_FName = getView().findViewById(R.id.et_teacher_firstName);
            EditText et_LName = getView().findViewById(R.id.et_Teacher_lastName);
            EditText et_Class = getView().findViewById(R.id.et_class);

            String fName =et_FName.getText().toString();
            String lName = et_LName.getText().toString();
            String course = et_Class.getText().toString();

            Teacher teacher = new Teacher(fName, lName, course);

            listener.addString(teacher.toString());

            et_FName.setText(R.string.empty);
            et_LName.setText(R.string.empty);
            et_Class.setText(R.string.empty);
        }
    }
}
