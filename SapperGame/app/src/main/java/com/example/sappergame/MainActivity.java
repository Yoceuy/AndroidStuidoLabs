package com.example.sappergame;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TableRow.LayoutParams;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView textView;
    Button apply=null;
    EditText editText;
    TableLayout tableLayout;
    boolean status=false;
    int radId=0;
    int clicks=0;
    int mines;
    int field=5;
    private int countID;
    int ROWS = 5;
    int COLUMNS = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup=findViewById(R.id.radioGroup);
        textView=findViewById(R.id.textView);
        editText=findViewById(R.id.editText);
        apply = findViewById(R.id.apply);
        tableLayout = findViewById(R.id.tableLayout);
    }

    public void onClick(View v) {
        clicks=0;
        radId = radioGroup.getCheckedRadioButtonId();
        tableLayout.removeAllViews();
        radioButton=findViewById(radId);
        if (editText.getText().toString().equals(""))
            textView.setText(R.string.empty);
        else {
            mines=Integer.parseInt(editText.getText().toString());
            switch (radioButton.getId()){

                case R.id.size5:
                    field=5;
                    getSize(v,field,mines);
                    break;
                case R.id.size6:
                    field = 6;
                    getSize(v,field,mines);
                    break;
                case R.id.size7:
                    field=7;
                    getSize(v,field,mines);
                    break;
            }
        }

    }
    public void createTableRow(View v,int field_d,int mines_check) {

            clicks=0;
            countID = 0;
            String check = "";
            TableLayout tl = findViewById(R.id.tableLayout);
            int[][] mines_arr = new int[2][field * field];
            for (int i = 0; i < field_d; i++) {

                TableRow tr = new TableRow(this);
                TableRow.LayoutParams lp = new TableRow.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 1);
                for (int d = 0; d < field_d; d++) {

                    Button b = new Button(this);
                    b.setLayoutParams(lp);
                    b.setMinimumWidth(30);
                    b.setText(R.string.pre);
                    b.setId(countID);
                    mines_arr[0][d] = countID;
                    countID++;
                    tr.addView(b);
                    checkM(v, mines_arr, field, b, mines_check);

                }
                tl.addView(tr);

            }
            shuffle(mines, mines_arr, field);
                for (int c = 0; c < field_d * field_d; c++) {
                    check = check + mines_arr[1][c];
            }
            textView.setText(check);

    }
    public void checkButton (View v){
        //clicks=0;
        radId = radioGroup.getCheckedRadioButtonId();
        radioButton=findViewById(radId);
    }
    public void checkM (View v, final int[][] minesm, final int field, final Button b, final int mines){

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //apply.setText(R.string.apply);
                clicks++;
                int countM = 0;
                if ((clicks+mines)!=field*field){


                    int bID = b.getId();
                    if (minesm[1][bID] == 1) {
                        clicks=0;
                        status=true;
                        textView.setText(R.string.lost);
                        for (bID = 0; bID < field * field; bID++) {

                            if (minesm[1][bID] == 1) {
                                Button b = findViewById(bID);
                                b.setText(R.string.mine);
                                falseclick(field);
                                apply.setText(R.string.restart);
                            }
                        }
                    } else {
                                if (bID % field == field - 1) {
                                    //b.setText(String.valueOf(bID%field));
                                    try { if (minesm[1][bID - 1] == 1) { countM++; }
                                    } catch (java.lang.ArrayIndexOutOfBoundsException e) { }

                                    try {
                                        if (minesm[1][bID - field] == 1) { countM++; }
                                    } catch (java.lang.ArrayIndexOutOfBoundsException e) { }
                                    try {
                                        if (minesm[1][bID + field] == 1) { countM++;}
                                    } catch (java.lang.ArrayIndexOutOfBoundsException e) { }

                                    try {
                                        if (minesm[1][bID + field - 1] == 1) { countM++; }
                                    } catch (java.lang.ArrayIndexOutOfBoundsException e) { }

                                    try {
                                        if (minesm[1][bID - field - 1] == 1) { countM++; }
                                    } catch (java.lang.ArrayIndexOutOfBoundsException e) { }

                                }

                                if (bID % field == 0) {
                                    try {
                                        if (minesm[1][bID + 1] == 1) { countM++; }
                                    } catch (java.lang.ArrayIndexOutOfBoundsException e) { }

                                    try {
                                        if (minesm[1][bID + field] == 1) { countM++; }
                                    } catch (java.lang.ArrayIndexOutOfBoundsException e) { }

                                    try {
                                        if (minesm[1][bID + field + 1] == 1) { countM++; }
                                    } catch (java.lang.ArrayIndexOutOfBoundsException e) { }

                                    try {
                                        if (minesm[1][bID - field] == 1) { countM++; }
                                    } catch (java.lang.ArrayIndexOutOfBoundsException e) { }

                                    try {
                                        if (minesm[1][bID - field + 1] == 1) { countM++; }
                                    } catch (java.lang.ArrayIndexOutOfBoundsException e) { }
                                }

                            if (bID % field != 0&&bID % field != field - 1) {
                                try{
                                     if (minesm[1][bID + 1] == 1) { countM++; }
                                } catch (java.lang.ArrayIndexOutOfBoundsException e) { }

                                try{
                                    if (minesm[1][bID + field - 1] == 1) { countM++; }
                                } catch (java.lang.ArrayIndexOutOfBoundsException e) { }

                                try{
                                    if (minesm[1][bID + field + 1] == 1) { countM++; }
                                } catch (java.lang.ArrayIndexOutOfBoundsException e) { }

                                try{
                                if (minesm[1][bID + field] == 1) { countM++; }
                                } catch (java.lang.ArrayIndexOutOfBoundsException e) { }

                                try{
                                    if ((minesm[1][bID - field] == 1)) { countM++; }
                                } catch (java.lang.ArrayIndexOutOfBoundsException e) { }

                                try{
                                    if ((minesm[1][bID - 1] == 1)) { countM++; }
                                } catch (java.lang.ArrayIndexOutOfBoundsException e) { }

                                try{
                                    if ((minesm[1][bID - field + 1] == 1)) { countM++; }
                                } catch (java.lang.ArrayIndexOutOfBoundsException e) { }

                                try{
                                    if ((minesm[1][bID - field - 1] == 1) ) { countM++; }
                                } catch (java.lang.ArrayIndexOutOfBoundsException e) { }
                            }

                        b.setText(String.valueOf(countM));
                        b.setClickable(false);
                    }
                }else {
                    b.setText(String.valueOf(countM));
                    textView.setText(R.string.win);
                    falseclick(field);
                }
            }
        });
    }
    public void shuffle (int mines_m, int [][] array,int field_s){

        for (int size=0;size<mines_m;size++){
            array[1][size]=1;
            array[1][size+1]=0;

        }
        Random rnd = ThreadLocalRandom.current();
        for (int i = array[1].length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i);
            int a = array[1][index];
            array[1][index] = array[1][i];
            array[1][i] = a;
        }
    }
    public void falseclick(int field){
        for (int i=0;i<field*field;i++){
            Button u= findViewById(i);
            u.setClickable(false);
        }
    }
    public void getSize (View v,int field,int mines){
        if (mines>(field*field-15)){
            textView.setText(R.string.full);
        }else
        if (mines<field){
            textView.setText(R.string.needmore);
        }else
            createTableRow(v,field,mines);
        clicks=0;
    }
}

