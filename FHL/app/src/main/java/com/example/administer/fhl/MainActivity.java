package com.example.administer.fhl;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final EditText editText = (EditText)findViewById(R.id.editText);
        Button button = (Button) findViewById(R.id.button);

        Button button1 = (Button) findViewById(R.id.button1) ;
        final TextView textView = (TextView)findViewById(R.id.textView);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        textView.setHorizontallyScrolling(true);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editText.setText("");
                textView.setText("");
            }
        });
        button.setOnClickListener(new View.OnClickListener(){
            String str  = "";
            String result = "";
            int sum = 0;
            @Override
            public void onClick(View view) {
                result = "";
                sum = 0; 
                if(editText.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this,"please input a word first",Toast.LENGTH_SHORT).show();
                }else{
                    str = editText.getText().toString();
                    try{
                            InputStream instream = getResources().getAssets().open("Shi300.txt");
                            if (instream != null) {
                                    InputStreamReader inputreader = new InputStreamReader(instream);
                                    StringBuffer buffer = new StringBuffer();
                                    String line; // 用来保存每行读取的内容
                                    BufferedReader bufferreader = new BufferedReader(new InputStreamReader(instream));
                                    line = bufferreader.readLine(); // 读取第一行
                                    while (line != null) {// 如果 line 为空说明读完了
                                        if(line.indexOf(str)!=-1) {
                                            result += line+"\n";
                                            sum++;
                                        }
                                        buffer.append(line); // 将读到的内容添加到 buffer 中
		                                buffer.append("\n"); // 添加换行符
                                        line = bufferreader.readLine(); // 读取下一行

                                    }
                            if(sum!=0)
                                Toast.makeText(MainActivity.this,"搜索完毕，共搜索到"+sum+"条结果", Toast.LENGTH_SHORT).show();
                            else
                                Toast.makeText(MainActivity.this,"对不起，没有你要搜索的结果，请重新输入", Toast.LENGTH_SHORT).show();
                            textView.setText(result);
                            instream.close();
                    }

                    }catch(Exception e){
                        Toast.makeText(MainActivity.this,"找不到文件",Toast.LENGTH_SHORT).show();
                    }

                    //调用查找方法
//                    try {
//                        result = search(str, shiJu);
//                        textView.setText(result.toString());
//                    }catch(Exception e){
//                        Toast.makeText(MainActivity.this,"UNKNOW ERROR",Toast.LENGTH_SHORT).show();
//                    }
                }
            }
        });





    }

    //查找文本有无文字
    public ArrayList<String> search(String str,ArrayList<String> arr){
        String note = str;
        String line;
        int sum = 0;
        ArrayList<String> result = new ArrayList<String>();
        Iterator<String> iter = arr.iterator();
        while(iter.hasNext()){
            line = iter.next().toString();
            if(line.indexOf(str) != -1){
                result.add(line);
                sum++;
            }

        }

        if(sum!=0)
            Toast.makeText(MainActivity.this,"搜索完毕，共搜索到"+sum+"条结果", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity.this,"对不起，没有你要搜索的结果，请重新输入", Toast.LENGTH_SHORT).show();
        return result;

    }
}
