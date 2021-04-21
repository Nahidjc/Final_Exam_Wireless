package com.example.finalpractice;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class CelsiusFragment extends Fragment {
    TextView StudentIDText,resultText;
    EditText CelsiusValue;
    Button Calculate;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_celsius, container, false);
        String StudentID = getArguments().getString("StudentID");
        StudentIDText = root.findViewById(R.id.studentidCelsius);
        StudentIDText.setText(StudentID);
        resultText = root.findViewById(R.id.CelsiusResultID);
        CelsiusValue = root.findViewById(R.id.CelsiusTempretureID);
        Calculate = root.findViewById(R.id.CelsiusCalculteId);
        Calculate.setOnClickListener(this::CalculateCelsiusFunction);
        return root;
    }
    public void CalculateCelsiusFunction(View view){
        String celsiusValue;
        celsiusValue = CelsiusValue.getText().toString();
        Double value = Double.parseDouble(celsiusValue);
        Double Farenheit = (9*value + 160)/5;
        resultText.setText(Farenheit.toString());
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference root = database.getReference("Student ID and Celsius to Farenheit");
        String StudentID = getArguments().getString("StudentID");
        root.child(StudentID).setValue(Farenheit);
        CelsiusValue.setText("");

    }
}