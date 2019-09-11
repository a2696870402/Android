## Android
# Android开发:简易计算器1.0
现在可以进行简单的四则运算，负数计算的功能已经添加.
初步功能的实现：
步骤1：创建视图，以及布局视图格局
创建一个activity视图，然后用TableLayout进行布局，然后再使用TableRow分行进行布局，
对每一行设定不同的控件，该项目设定的是第一行设置为Plain Text控件，用于实时显示输入的数字，第二行再设定一个PlainText控件用于显示输入的算术表达式，再往下是一个5x4的数字和清除以及加减乘除的操作按钮，然后还设定了一个切换到进制转换和三角函数的求解的activity视图。
                      

步骤2：绑定事件和计算算术表达式
此处只给出计算的算法代码，算法思想为：因为没有括号，那么首先计算的应该是乘法和除法，所以我们首先把乘除的计算通过遍历一遍算术表达式字符串计算出来并且存入到一个数组中去，比如：1+2*5+7，我们会先把1存入到一个数组中，然后把‘+’号也存到一个数组中，然后我们会先计算出2*5然后再放入到保存1的那个数组中去，然后再把后面的‘+’号继续遍历放入到算术符号数组中，这样我们遍历一遍后，我们可以得到两个数组，一个装的是数值的数组，一个装的是符号的数组，然后我从数值数组取出数组，和符号数组组合，然后依次计算，我们就能得到算术表达式的值，详细代码如下：
```java
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
```
## 增添功能
因为计算器的计算不应该只有简单表达式，我们对该项目添加了一个视图，该视图能把十进制数值转换为二进制，八进制以及十六进制，但是需要注意的是，如果是小数型的数值无法求得二进制，八进制和十六进制，所以在进行进制转换时，必须先转成整数，该产品已经开发该功能，点击转为整数即可。
现在再给出视图转换，并且数值传值的函数：
```java
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
```
该项目在对于负值进行计算的时候，采用把负号向前的方法，比如1+2*(-3)转化为1-2*3,详细代码如下：
```java
button_fu.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String str=edittext.getText().toString();
        //情况1： 1+(-2)
        String ee=str.substring(str.length()-1,str.length());
        if(ee.equals("+")){
            edittext.setText(String.valueOf(str.substring(0,str.length()-1)+"-"));
        }
        //情况2： 1-(-2)
        else if(ee.equals("-")){
            edittext.setText(String.valueOf(str.substring(0,str.length()-1)+"+"));
        }
        //情况3： 1+2*(-3)
        else {
            char chars[]=str.toCharArray();
            int i,len=str.length();
            int falt=0;
            for(i=len-2;i>=0;i--){
                if(chars[i]=='+'){
                    falt=1;
                    break;
                }
                else if(chars[i]=='-'){
                    falt=2;
                    break;
                }
            }
            if(falt==1)
            {
                edittext.setText(str.substring(0,i)+"-"+str.substring(i+1,len));
            }
            else if(falt==2){
                edittext.setText(str.substring(0,i)+"+"+str.substring(i+1,len));
            }

        }
    }
});
```
## 增强功能2：
该项目开发了横屏的功能，在横屏后布局发生变化：
