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


public class FarenheitFragment extends Fragment {
TextView StudentIDText,resultText;
EditText FarenheitValue;
Button Calculate;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root = inflater.inflate(R.layout.fragment_farenheit, container, false);
        String StudentID = getArguments().getString("StudentID");
        StudentIDText = root.findViewById(R.id.studentidFarenheit);
        StudentIDText.setText(StudentID);
        resultText = root.findViewById(R.id.FarenheitResultID);
        FarenheitValue = root.findViewById(R.id.FarenhiteTempretureID);
        Calculate = root.findViewById(R.id.FarenhiteCalculteId);
        Calculate.setOnClickListener(this::CalculateFarenheitFunction);
        return root;
    }
    public void CalculateFarenheitFunction(View view){
     String farenheitValue;
     farenheitValue = FarenheitValue.getText().toString();
     Double value = Double.parseDouble(farenheitValue);
     Double Celsius = (5 *(value - 32))/ 9;
     resultText.setText(String.format("%.2f",Celsius));
     FarenheitValue.setText("");

    }
}