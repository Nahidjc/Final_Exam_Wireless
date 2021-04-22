package com.example.finalpractice;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import javax.microedition.khronos.egl.EGLDisplay;


public class BmiFragment extends Fragment {
TextView resultText;
EditText heightText,weightText;
Double BMI;
Button Calculate;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_bmi, container, false);
        heightText = root.findViewById(R.id.BMIheightID);
        weightText = root.findViewById(R.id.BMIweightID);
        String StudentID = getArguments().getString("StudentID");
        resultText = root.findViewById(R.id.BMIresult);
        resultText.setText(StudentID);
        Calculate = root.findViewById(R.id.CalculateBmiID);
        Calculate.setOnClickListener(this::CalculateBMIFunction);
        return  root;
    }
    public void CalculateBMIFunction(View view){
        String height,weight;
        height = heightText.getText().toString();
        weight = weightText.getText().toString();
        Double Height = Double.parseDouble(height);
        Double Weight = Double.parseDouble(weight);
        Double MeterHeight = Height /100;
        BMI = Weight / (MeterHeight*MeterHeight);
        if(BMI > 25.0){
            Toast.makeText(this.getActivity(), "Overweight", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this.getActivity(), "Not Overweight", Toast.LENGTH_SHORT).show();
        }
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference root = database.getReference("Student ID and BMI");
        String StudentID = getArguments().getString("StudentID");
        root.child(StudentID).setValue(BMI);
        heightText.setText("");
        weightText.setText("");
    }
}