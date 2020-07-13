package com.example.demo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txt_marqee1,txt_marqee2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txt_marqee1=(TextView)findViewById(R.id.txt_marquee);
        txt_marqee2=(TextView)findViewById(R.id.txt_marquee1);


        txt_marqee1.setSelected(true);
        txt_marqee2.setSelected(true);


    }

    public void Click(View view) {
       startActivity(new Intent(getApplicationContext(),Login_Form.class));

    }

    public void sign(View view) {
        startActivity(new Intent(getApplicationContext(),Signup_Form.class));
    }
}
