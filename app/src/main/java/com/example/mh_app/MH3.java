package com.example.mh_app;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
public class MH3 extends AppCompatActivity {
    Button msignin;
    Button mregin;
    EditText Email,Password;
    FirebaseAuth fAuth;
    ProgressBar progressbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_h3);
        Email = findViewById(R.id.Email1);
        Password = findViewById(R.id.password1);
        fAuth = FirebaseAuth.getInstance();
        progressbar = findViewById(R.id.progressBar);
        mregin =findViewById(R.id.reg);
        msignin =findViewById(R.id.SignIn);
        mregin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToActivityFour();
            }
        });
        msignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = Email.getText().toString().trim();
                String password = Password.getText().toString().trim();
                if(TextUtils.isEmpty(email)){
                    Email.setError("Email field cannot be empty");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Password.setError("Password field cannot be empty");
                    return;
                }
                if(password.length() < 6){
                    Password.setError("Password must be greater than 6 characters long");
                    return;
                }
                progressbar.setVisibility(View.VISIBLE);
                //Authenticate the user
                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MH3.this ,"User Created",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MH2.class));
                        }
                        else{
                            Toast.makeText(MH3.this,"Error : " + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }

    //Check if the user reg is working
    private  void moveToActivityFour(){
        Intent intent=new Intent(MH3.this,MH4.class);
        startActivity(intent);
    }
}