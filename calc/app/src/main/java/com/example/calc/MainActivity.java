package com.example.calc;

import android.annotation.SuppressLint;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    static public TextView textView;
    static public double num1=0,num2=0;
    static public String str = "";
    static public boolean check=false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        textView.setText("");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("text",textView.getText().toString());

    }
    public void onRestoreInstanceState (Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        textView.setText(savedInstanceState.getString("text"));
    }

    public void cls(View view){
        textView.setText("");
        num1=0;
        num2=0;
        str="";

    }


}
