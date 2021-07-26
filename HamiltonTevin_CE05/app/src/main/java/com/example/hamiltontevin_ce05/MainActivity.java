package com.example.hamiltontevin_ce05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.hamiltontevin_ce05.fragment.AdminFragment;
import com.example.hamiltontevin_ce05.fragment.MainDisplayFragment;
import com.example.hamiltontevin_ce05.fragment.StudentFragment;
import com.example.hamiltontevin_ce05.fragment.TeacherFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AddTextListener, AdapterView.OnItemSelectedListener {

    private final ArrayList<String> peopleList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){

            Button refreshButton = findViewById(R.id.refreshButton);
            refreshButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_detail, MainDisplayFragment.newInstance(peopleList)).commit();


                }
            });

            Spinner mainSpinner = findViewById(R.id.peopleSpinner);
            mainSpinner.setOnItemSelectedListener(this);

            //create an array to capture resource
            String[] peopleArray;

            peopleArray = getResources().getStringArray(R.array.people);

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,peopleArray);
            arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            mainSpinner.setAdapter(arrayAdapter);

            getSupportFragmentManager().beginTransaction().add(R.id.frameLayout_detail, MainDisplayFragment.newInstance(peopleList)).commit();

            getSupportFragmentManager().beginTransaction().add(R.id.frameLayout_form, StudentFragment.newInstance()).commit();
        }
    }


    @Override
    public void addString(String Text) {
        peopleList.add(Text);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
        switch (pos){
            case 0:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_form, StudentFragment.newInstance()).commit();
                break;
            case 1:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_form, TeacherFragment.newInstance()).commit();
                break;
            case 2:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_form, AdminFragment.newInstance()).commit();

                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
