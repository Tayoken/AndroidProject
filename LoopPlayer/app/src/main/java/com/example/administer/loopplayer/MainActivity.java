package com.example.administer.loopplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    public void onBackPressed() {
        Intent setIntent = new Intent(Intent.ACTION_MAIN);
        setIntent.addCategory(Intent.CATEGORY_HOME);
        setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(setIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.release();
                finish();
            }

        });

        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.qby);


        final Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
                button1.setVisibility(View.INVISIBLE);
                ImageView imageView = (ImageView)findViewById(R.id.imageView);
                imageView.setVisibility(View.VISIBLE);


            }
        });


        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
                mediaPlayer.setLooping(true);
            }
        });

    }
}
//    private void play() {
//        try {
//            mediaPlayer.reset();
//            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.qby);//重新设置要播放的音频
//            mediaPlayer.start();//开始播放
//        } catch (Exception e) {
//            e.printStackTrace();//输出异常信息
//        }
//    }


