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
            myFragment = new BmiFragment();
        }else if(view.getId()==R.id.FarenhiteID){
            myFragment = new FarenheitFragment();
        }else if (view.getId()==R.id.CelsiusID){
            myFragment = new CelsiusFragment();
        }
        String StudentId = getIntent().getStringExtra("StudentID");
        Toast.makeText(this, StudentId, Toast.LENGTH_SHORT).show();
        Bundle bundle = new Bundle();
        bundle.putString("StudentID",StudentId);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragmentID,myFragment);
        ft.commit();

    }
}