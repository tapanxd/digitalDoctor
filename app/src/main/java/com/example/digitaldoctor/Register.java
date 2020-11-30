package com.example.digitaldoctor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    EditText mName, mEmail, mPassword, mPhone, mDob;
    Button mPatient, mDoctor, mPharmacy;
    TextView mLogin;
    FirebaseAuth mAuth;
    String Gender;
    RadioButton male, female, other;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mName = findViewById(R.id.fullName);
        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        mPhone = findViewById(R.id.phoneNumber);
        mPatient = findViewById(R.id.btnPatient);
        mDoctor = findViewById(R.id.btnDoctor);
        mPharmacy = findViewById(R.id.btnPharmacy);
        mLogin = findViewById(R.id.alreadyRegistered);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        other = findViewById(R.id.other);
        mAuth = FirebaseAuth.getInstance();
        mDob = findViewById(R.id.dob);


        if(mAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }

        //button click patient
        mPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                String email = mEmail.getText().toString().trim();
                String pass = mPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(pass)){
                    mPassword.setError("Password is required");
                    return;
                }
                if(pass.length()<6){
                    mPassword.setError("Password must be >= 6 characters");
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Register.this, "Successfully Registered",Toast.LENGTH_SHORT).show();
                            //save user data
                            startActivity(new Intent(getApplicationContext(),patientRegister.class));
                        }else{
                            Toast.makeText(Register.this, "Registration failed" + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

        //button click doctor
        mDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                String email = mEmail.getText().toString().trim();
                String pass = mPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(pass)){
                    mPassword.setError("Password is required");
                    return;
                }
                if(pass.length()<6){
                    mPassword.setError("Password must be >= 6 characters");
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Register.this, "Successfully Registered",Toast.LENGTH_SHORT).show();
                            //save user data
                            startActivity(new Intent(getApplicationContext(),doctorRegister.class));
                        }else{
                            Toast.makeText(Register.this, "Registration failed" + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

        //button click pharmacy
        mPharmacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                String email = mEmail.getText().toString().trim();
                String pass = mPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(pass)){
                    mPassword.setError("Password is required");
                    return;
                }
                if(pass.length()<6){
                    mPassword.setError("Password must be >= 6 characters");
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Register.this, "Successfully Registered",Toast.LENGTH_SHORT).show();
                            //save user data
                            startActivity(new Intent(getApplicationContext(),pharmacyRegister.class));
                        }else{
                            Toast.makeText(Register.this, "Registration failed\n" + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });
    }
}