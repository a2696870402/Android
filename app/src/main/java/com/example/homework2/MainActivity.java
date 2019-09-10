package com.example.homework2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textnumber=findViewById(R.id.textnumber);
        Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,activity1.class);
                //进行跳转 并且传值
                intent.putExtra("number",textnumber.getText().toString());
                startActivity(intent);
            }
        });
        Button button0=findViewById(R.id.button0);
        Button button1=findViewById(R.id.button1);
        Button button2=findViewById(R.id.button2);
        Button button3=findViewById(R.id.button3);
        Button button4=findViewById(R.id.button4);
        Button button5=findViewById(R.id.button5);
        Button button6=findViewById(R.id.button6);
        Button button7=findViewById(R.id.button7);
        Button button8=findViewById(R.id.button8);
        Button button9=findViewById(R.id.button9);
        Button add=findViewById(R.id.add);
        Button cut=findViewById(R.id.cut);
        Button clear=findViewById(R.id.clear);
        Button mul=findViewById(R.id.mul);
        Button div=findViewById(R.id.div);
        Button equal=findViewById(R.id.equal);
        Button dian=findViewById(R.id.button_dian);
        dian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textnumber.append(".");
            }
        });
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textnumber.getText().toString().substring(0,1).equals("0")){
                    textnumber.setText("0");
                }
                else {
                    textnumber.append("0");
                }
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textnumber.getText().toString().substring(0, 1).equals("0")) {

                    textnumber.setText("1");
                } else {
                    textnumber.append("1");
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textnumber.getText().toString().substring(0, 1).equals("0")) {

                    textnumber.setText("2");
                } else {
                    textnumber.append("2");
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textnumber.getText().toString().substring(0, 1).equals("0")) {

                    textnumber.setText("3");
                } else {
                    textnumber.append("3");
                }
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textnumber.getText().toString().substring(0, 1).equals("0")) {

                    textnumber.setText("4");
                } else {
                    textnumber.append("4");
                }
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textnumber.getText().toString().substring(0, 1).equals("0")) {

                    textnumber.setText("5");
                } else {
                    textnumber.append("5");
                }
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textnumber.getText().toString().substring(0, 1).equals("0")) {

                    textnumber.setText("6");
                } else {
                    textnumber.append("6");
                }
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textnumber.getText().toString().substring(0, 1).equals("0")) {

                    textnumber.setText("7");
                } else {
                    textnumber.append("7");
                }
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textnumber.getText().toString().substring(0, 1).equals("0")) {

                    textnumber.setText("8");
                } else {
                    textnumber.append("8");
                }
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textnumber.getText().toString().charAt(0) == '0') {
                    textnumber.setText("9");
                } else {
                    textnumber.append("9");
                }
            }
        });
        final TextView edittext=findViewById(R.id.editText);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textnumber.setText("0");
                edittext.setText("");
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=" ";
                if(!edittext.getText().toString().equals("")) {
                    str = edittext.getText().toString().substring(edittext.getText().length() - 1, edittext.getText().length());
                    System.out.println(str);
                }
                if (edittext.getText().toString().equals("")|| (str.equals("+")||str.equals("-")||str.equals("*")||str.equals("/"))) {
                    edittext.append(textnumber.getText() + "+");
                }
                else {
                    edittext.append("+"+textnumber.getText());
                }
                textnumber.setText("0");
            }
        });
        cut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=" ";
                if(!edittext.getText().toString().equals("")) {
                    str = edittext.getText().toString().substring(edittext.getText().length() - 1, edittext.getText().length());
                    System.out.println(str);
                }
                if (edittext.getText().toString().equals("")|| (str.equals("+")||str.equals("-")||str.equals("*")||str.equals("/"))) {
                    edittext.append(textnumber.getText() + "-");
                }
                else {
                    edittext.append("-"+textnumber.getText());
                }
                textnumber.setText("0");
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=" ";
                if(!edittext.getText().toString().equals("")) {
                    str = edittext.getText().toString().substring(edittext.getText().length() - 1, edittext.getText().length());
                    System.out.println(str);
                }
                if (edittext.getText().toString().equals("")|| (str.equals("+")||str.equals("-")||str.equals("*")||str.equals("/"))) {
                    edittext.append(textnumber.getText() + "*");
                }
                else {
                    edittext.append("*"+textnumber.getText());
                }
                textnumber.setText("0");
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=" ";
                if(!edittext.getText().toString().equals("")) {
                    str = edittext.getText().toString().substring(edittext.getText().length() - 1, edittext.getText().length());
                    System.out.println(str);
                }
                if (edittext.getText().toString().equals("") || (str.equals("+")||str.equals("-")||str.equals("*")||str.equals("/"))) {
                    edittext.append(textnumber.getText() + "/");
                }
                else {
                    edittext.append("/"+textnumber.getText());
                }
                textnumber.setText("0");
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char str[]=(edittext.getText().toString()+textnumber.getText().toString()).toCharArray();
                System.out.println(str);
                //思路是 先把乘除的计算出来，然后把加减存入数组 最后遍历完第一遍字符串后就只剩下存在加减的运算
                //然后再从左到右依次计算即可
                double [] a=new double[100];
                char [] b=new char[100];
                int t=0;
                String number="";
                for(int i=0;i<str.length;i++){
                    if(str[i]=='+'||str[i]=='-'){
                        a[t]=Double.parseDouble(number);
                        b[t]=str[i];
                        t++;
                        number="";
                    }
                    else if(str[i]=='*'||str[i]=='/'){
                        //计算
                        String number2="";
                        for(int j=i+1;;j++){
                            if(j==str.length){
                                break;
                            }
                            if(str[j]=='+'||str[j]=='-'||str[j]=='*'||str[j]=='/'){
                                b[t]=str[j];
                                break;
                            }
                            number2=number2+str[j];
                        }
                        double n1=Double.parseDouble(number);
                        double n2=Double.parseDouble(number2);
                        number="";
                        number2="";
                        if(str[i]=='*'){
                            a[t]=n1*n2;
                        }
                        else {
                            a[t]=n1/n2;
                        }
                        t++;
                    }
                    else
                    {
                        number=number+str[i];
                    }
                }
                a[t]=Double.parseDouble(number);
                // 然后计算
                double sum=a[0];
                for(int i=1;i<=t;i++){
                    if(b[i-1]=='+'){
                        sum+=a[i];
                    }
                    else if(b[i-1]=='-'){
                        sum-=a[i];
                    }
                }
                textnumber.setText(String.valueOf(sum));
                edittext.setText("");
            }
        });
    }
}
