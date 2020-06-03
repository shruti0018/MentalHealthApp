package com.example.mh_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MH2 extends AppCompatActivity {
    Button journal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_h2);


         journal = findViewById(R.id.button3);



        journal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToActivityFive();
            }
        });

    }
    public void logout(View view){
        FirebaseAuth.getInstance().signOut();//Logout
        startActivity(new Intent(getApplicationContext(),MH3.class));


    }
    private  void moveToActivityFive(){
        Intent intent=new Intent(MH2.this,MH5.class);
        startActivity(intent);

    }
}
