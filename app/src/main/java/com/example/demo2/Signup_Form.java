package com.example.demo2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Signup_Form extends AppCompatActivity {
    EditText txt_email,txt_passwoed,txt_confirmPasseord;
    Button btnRegistor;

    FirebaseAuth firebaseAuth;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup__form);

        txt_email=(EditText)findViewById(R.id.txtEmail);
        txt_passwoed=(EditText)findViewById(R.id.txtPassword);
        txt_confirmPasseord=(EditText)findViewById(R.id.txtConfimPassword);
        btnRegistor=(Button)findViewById(R.id.btn_Registor);

        firebaseAuth=FirebaseAuth.getInstance();
        btnRegistor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email=txt_email.getText().toString();
                String password=txt_passwoed.getText().toString();
                String confimPassword=txt_confirmPasseord.getText().toString();


                if (TextUtils.isEmpty(email)){
                    Toast.makeText(Signup_Form.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(Signup_Form.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(confimPassword)){
                    Toast.makeText(Signup_Form.this, "Please Enter ConfirmPassword", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length()<6){
                    Toast.makeText(Signup_Form.this, "Password too Short", Toast.LENGTH_SHORT).show();

                }
                if (password.equals(confimPassword)){

                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(Signup_Form.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                        Toast.makeText(Signup_Form.this, "Registor Complete", Toast.LENGTH_SHORT).show();

                                    } else {
                                        Toast.makeText(Signup_Form.this, "Authentication Failed", Toast.LENGTH_SHORT).show();

                                    }

                                }
                            });





                }




            }
        });







    }
}