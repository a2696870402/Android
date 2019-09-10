package com.example.homework2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1);
        final TextView textView=findViewById(R.id.number);
        final TextView textView1=findViewById(R.id.editText2);
        Intent i=getIntent();
        textView.setText(i.getStringExtra("number"));
        Button button2=findViewById(R.id.button2);
        Button button8=findViewById(R.id.button8);
        Button button16=findViewById(R.id.button16);
        Button button_sin=findViewById(R.id.button_sin);
        Button button_cos=findViewById(R.id.button_cos);
        Button button_tan=findViewById(R.id.button_tan);
        Button return0=findViewById(R.id.button_return);
        Button zhuan=findViewById(R.id.button_zhuanhuan);
        zhuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double d=new Double(textView.getText().toString());
                int d1=(int)d;
                textView.setText(String.valueOf(d1));
            }
        });
        return0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(activity1.this,MainActivity.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = textView.getText().toString();
                // 二进制也只存在在整数中
                try {
                    textView1.setText(Integer.toBinaryString(Integer.parseInt(number)));
                }
                catch (Exception e){
                    new AlertDialog.Builder(activity1.this).
                            setTitle("异常").setMessage(e.toString()+"二进制只存在整数中")
                            .setPositiveButton("确定",null).show();
                }
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = textView.getText().toString();
                try {
                    //八进制只存在在整数中
                    textView1.setText(Integer.toOctalString(Integer.parseInt(number)));
                }
                catch (Exception e){
                    new AlertDialog.Builder(activity1.this).
                            setTitle("异常").setMessage(e.toString()+"八进制只存在整数中")
                            .setPositiveButton("确定",null).show();
                }
            }
        });
        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number=textView.getText().toString();
                double num=Double.parseDouble(number);
                textView1.setText(Double.toHexString(num));
            }
        });
        button_sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number=textView.getText().toString();
                double num=Double.parseDouble(number);
                textView1.setText(String.valueOf(Math.sin(num)));
            }
        });
        button_cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number=textView.getText().toString();
                double num=Double.parseDouble(number);
                textView1.setText(String.valueOf(Math.cos(num)));
            }
        });
        button_tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number=textView.getText().toString();
                double num=Double.parseDouble(number);
                textView1.setText(String.valueOf(Math.tan(num)));
            }
        });
    }
}
