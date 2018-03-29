package com.example.administer.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = (Button)findViewById(R.id.Button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                第一次
//                Toast.makeText(MainActivity.this,"Finish",Toast.LENGTH_SHORT).show();
//                finish();

//                第二次
//                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
//                startActivity(intent);

//                第三次
                Intent intent = new Intent("com.example.administer.test.ACTION_START");
                intent.addCategory("com.example.administer.test.MY_CATEGORY");
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(MainActivity.this,"You clicked Add",Toast.LENGTH_SHORT).show();
                break;

            case R.id.remove_item:
                Toast.makeText(MainActivity.this, "You clicked Remove", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
