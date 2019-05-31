package com.example.calc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;


public class Nums extends Fragment {
View view;
View v;

    public static final String KEY = "text";
     public TextView textView= MainActivity.textView;
     double num1=MainActivity.num1,num2=MainActivity.num2;
     String str =MainActivity.str;

     boolean check=MainActivity.check;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_nums, container, false);
       // String textFromActivity = getArguments().getString("text");
       // textView.setText(textFromActivity);
        Button result = view.findViewById(R.id.equals);
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result(v);
            }
        });
        Button minus = view.findViewById(R.id.minus);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation(v);
            }
        });
        Button plus = view.findViewById(R.id.plus);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation(v);
            }
        });
        Button divide = view.findViewById(R.id.divide);
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation(v);
            }
        });
        Button multiply = view.findViewById(R.id.multiply);
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation(v);
            }
        });
        Button n0 = view.findViewById(R.id.n0);
        n0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums(v);
            }
        });
        Button n1 = view.findViewById(R.id.n1);
        n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums(v);
            }
        });
        Button n2 = view.findViewById(R.id.n2);
        n2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums(v);
            }
        });
        Button n3 = view.findViewById(R.id.n3);
        n3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums(v);
            }
        });
        Button n4 = view.findViewById(R.id.n4);
        n4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums(v);
            }
        });
        Button n5 = view.findViewById(R.id.n5);
        n5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums(v);
            }
        });
        Button n6 = view.findViewById(R.id.n6);
        n6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums(v);
            }
        });
        Button n7 = view.findViewById(R.id.n7);
        n7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums(v);
            }
        });
        Button n8 = view.findViewById(R.id.n8);
        n8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums(v);
            }
        });
        Button n9 = view.findViewById(R.id.n9);
        n9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums(v);
            }
        });
        Button cl = view.findViewById(R.id.Cs);
        cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView=MainActivity.textView;
                String c= textView.getText().toString();
                cl(c);

            }
        });





        return view;
    }


    @SuppressLint("SetTextI18n")
    public void nums(View v) {
        Button n = (Button) v;

        textView= MainActivity.textView;
        textView.setText(textView.getText().toString()+n.getText().toString());
        check=false;
    }
    public void stmt (double a,double b){

        if (!check)
        {
            try {
                b = Double.parseDouble(textView.getText().toString());
            }
            catch (Exception e){
                return;
            }
        }

        // num2=Double.parseDouble(textView.getText().toString());
        switch (str){
            case "+":
                a+=b;

                break;
            case "-":
                a -= b;
                break;
            case "*":
                a*=b;
                break;
            case "/":
                a/=b;
                break;
        }

        textView.setText("");
        num1 = a;
        num2 = b;
        check = true;

    }

    public void operation(View v){
        Button sign=(Button) v;
        textView= MainActivity.textView;
        if(str.equals("")){
            if (!textView.getText().toString().equals(""))
            {
                str=sign.getText().toString();
                num1=Double.parseDouble(textView.getText().toString());
                //stmt(num1,num2);
                textView.setText("");
                check=false;
            }
        }else{
            stmt(num1,num2);
            str=sign.getText().toString();
        }

        check=false;

    }
    public String cl (String str) {
        textView=MainActivity.textView;
        if (str != null && str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        }
        textView.setText(str);
        return str;
    }

    public void result(View view){
        textView= MainActivity.textView;
        if(str.equals("")&&!textView.getText().equals("")) textView.setText(textView.getText());
        else if(textView.getText().equals("")) textView.setText("");
        else{
            if (!check)num2=Double.parseDouble(textView.getText().toString());
            switch (str){
                case "+":
                    num1+=num2;
                    break;
                case "-":
                    num1 -= num2;
                    break;
                case "*":
                    num1*=num2;
                    break;
                case "/":
                    num1/=num2;
                    break;
            }

            textView.setText(String.valueOf(num1));
            check = true;
            str="";
        }
    }

}
