package com.example.finalpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void FragmentChangeFunction(View view) {

        Fragment myFragment = null;
        if(view.getId()==R.id.BmiId){
            String StudentId = getIntent().getStringExtra("StudentID");
            Bundle bundle = new Bundle();
            bundle.putString("StudentID",StudentId);
            myFragment = new BmiFragment();
            myFragment.setArguments(bundle);
        }else if(view.getId()==R.id.FarenhiteID){
            String StudentId = getIntent().getStringExtra("StudentID");
            Bundle bundle = new Bundle();
            bundle.putString("StudentID",StudentId);
            myFragment = new FarenheitFragment();
            myFragment.setArguments(bundle);
        }else if (view.getId()==R.id.CelsiusID){
            String StudentId = getIntent().getStringExtra("StudentID");
            Bundle bundle = new Bundle();
            bundle.putString("StudentID",StudentId);
            myFragment = new CelsiusFragment();
            myFragment.setArguments(bundle);
        }

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragmentID,myFragment);
        ft.commit();

    }
}