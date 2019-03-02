package com.example.saimouni.surakhsmaa;

import android.content.DialogInterface;
import android.content.Intent;
import android.opengl.ETC1;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button otpBtn,registerBtn;
    EditText otpEt;
    Spinner gender;
    ArrayList<String> genderList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        otpBtn = findViewById(R.id.otpBtn);
        otpEt = findViewById(R.id.otpET);
        registerBtn = findViewById(R.id.registerBtn);
        gender = findViewById(R.id.gender);

        genderList.add("Male");
        genderList.add("Female");
        genderList.add("Prefer not to say");
        gender.setOnItemSelectedListener(this);
        arrayAdapter = new ArrayAdapter(this,R.layout.listitem,R.id.textview,genderList);
        gender.setAdapter(arrayAdapter);

        otpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                otpEt.setText("254601");
            }
        });
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog = null;
                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(RegisterActivity.this,HomeActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }
                });
                builder.setTitle("Hurray!");
                builder.setMessage("Your account has been successfully registered");
                builder.setCancelable(false);
                alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
