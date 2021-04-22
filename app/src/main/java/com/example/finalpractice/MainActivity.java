package com.example.finalpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    //private static final String TAG = "MainActivity";
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

    public void allUserFunction(View view) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference root = database.getReference("Student ID and Farenheit to Celsius");
        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String value = dataSnapshot.getValue().toString();
                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
               Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
}