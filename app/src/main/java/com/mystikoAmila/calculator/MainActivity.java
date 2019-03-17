package com.mystikoAmila.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 EditText idEditText;
 Button addButton;
 Button subButton;
 Button mulButton;
 Button divButton;
 Button getButton;
double x=0.0;
int buttonCliked=0;
int FirstValEntered=0;
double val=0.0;
double y=1.0;

int divVal=0;
double Firstval=0.0;
double divAns=0.0;

    int subVal=0;
    double Firstvalsub=0.0;
    double subAns=0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idEditText=(EditText)findViewById(R.id.editTextNumber);
        addButton=(Button)findViewById(R.id.adderButton);
        subButton=(Button)findViewById(R.id.subtractorButton);
        mulButton=(Button)findViewById(R.id.multiplyButton);
        divButton=(Button)findViewById(R.id.dividerButton);
        getButton=(Button)findViewById(R.id.equalButton);

       /* if(!TextUtils.isEmpty(idEditText.getText().toString()) && (FirstValEntered==0)){
            Double newF=Double.parseDouble(idEditText.getText().toString());
            val=newF;
            FirstValEntered=1;
        }*/

        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
              public void onClick(View v) {
                if(buttonCliked==1) {
                    if (!TextUtils.isEmpty(idEditText.getText().toString())) {
                        double Num=Double.parseDouble(idEditText.getText().toString());
                        x=x+Num;
                        idEditText.setText(String.valueOf(x));
                        //x = 0.0;
                    }}

                if(buttonCliked==3) {
                    if (!TextUtils.isEmpty(idEditText.getText().toString())) {
                        double Num=Double.parseDouble(idEditText.getText().toString());
                        y=y*Num;
                        idEditText.setText(String.valueOf(y));
                        //y= 0.0;
                    }}
                if(buttonCliked==4) {
                    if (!TextUtils.isEmpty(idEditText.getText().toString())) {
                        double Num=Double.parseDouble(idEditText.getText().toString());
                        Firstval=Firstval/Num;
                        idEditText.setText(String.valueOf(Firstval));
                        //x = 0.0;
                    }}
                if(buttonCliked==2) {
                    if (!TextUtils.isEmpty(idEditText.getText().toString())) {
                        double Num=Double.parseDouble(idEditText.getText().toString());
                        Firstvalsub=Firstvalsub-Num;
                        idEditText.setText(String.valueOf(Firstvalsub));
                        //x = 0.0;
                    }}
                   /* else{
                        idEditText.setText(String.valueOf(x));
                        x=0.0;
                    }*/

                         }
     });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty(idEditText.getText().toString())) {
                    cal("+", idEditText.getText().toString());
                }
                else{
                    Toast.makeText(MainActivity.this, "No empty Number allowed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        divButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty(idEditText.getText().toString())) {
                    cal("/", idEditText.getText().toString());
                }
                else{
                    Toast.makeText(MainActivity.this, "No empty Number allowed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mulButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty(idEditText.getText().toString())) {
                    cal("*", idEditText.getText().toString());
                }
                else{
                    Toast.makeText(MainActivity.this, "No empty Number allowed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty(idEditText.getText().toString())){
                    cal("-",idEditText.getText().toString());
                }
                else{
                    Toast.makeText(MainActivity.this, "No empty Number allowed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    void cal(String type,String number){
if(type.equals("+")){
    buttonCliked=1;
    double Number= Double.parseDouble(number);
    x=x+Number;
    Toast.makeText(this, String.valueOf(x), Toast.LENGTH_SHORT).show();
    idEditText.setText("");
}


        if(type.equals("/")){
            buttonCliked=4;
            double Number= Double.parseDouble(number);

            if(divVal==0){
                Firstval=Number;
                divVal++;
                Toast.makeText(this, String.valueOf(Firstval), Toast.LENGTH_SHORT).show();
                idEditText.setText("");
            }
            else{
                divAns=Firstval/Number;
                Firstval=divAns;
                Toast.makeText(this, String.valueOf(divAns), Toast.LENGTH_SHORT).show();
                idEditText.setText("");
            }
        }





        if(type.equals("*")){
            buttonCliked=3;
            double Number= Double.parseDouble(number);
            y=y*Number;
            Toast.makeText(this, String.valueOf(y), Toast.LENGTH_SHORT).show();
            idEditText.setText("");
        }

        if(type.equals("-")){
            buttonCliked=2;
            double Number= Double.parseDouble(number);

            if(subVal==0){
                Firstvalsub=Number;
                subVal++;
                Toast.makeText(this, String.valueOf(Firstvalsub), Toast.LENGTH_SHORT).show();
                idEditText.setText("");
            }
            else{
                subAns=Firstvalsub-Number;
                Firstvalsub=subAns;
                Toast.makeText(this, String.valueOf(subAns), Toast.LENGTH_SHORT).show();
                idEditText.setText("");
            }
        }

    }
}
