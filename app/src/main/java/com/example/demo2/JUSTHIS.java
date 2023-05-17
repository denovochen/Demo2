package com.example.demo2;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class JUSTHIS extends AppCompatActivity {
    private TextView justhis_name;
    private TextView justhis_info;
    private ImageView justhis_pic;
    private MediaPlayer mPlayer;
    private Button btn_back;
    private Button btn_music;
    private Button btn_stop;
    private boolean isPause = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_justhis);

        btn_music = findViewById(R.id.btn_music);
        btn_stop = findViewById(R.id.btn_stop);
        btn_back = findViewById(R.id.btn_back);
        btn_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ("播放".equals(btn_music.getText().toString())) {
                    btn_music.setText("播放中");
                    initPlayer();//加载音乐
                }
            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isPause) {
                    mPlayer.pause();//暂停音乐播放
                    btn_stop.setText("继续");
                    isPause = true;
                } else {
                    mPlayer.start();//继续开始音乐播放
                    btn_stop.setText("暂停");
                    isPause = false;
                }
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }
        });
    }
    private void initPlayer() {
        mPlayer = MediaPlayer.create(this, R.raw.justhis);
        mPlayer.setLooping(true);//设置为循环播放
        mPlayer.start();//开始播放音乐
    }

    @Override
    protected void onDestroy() {//销毁
        super.onDestroy();
        mPlayer.stop();//停止播放音乐
    }


    public void init() {
        justhis_name = (TextView) findViewById(R.id.justhis_name);
        justhis_info = (TextView) findViewById(R.id.justhis_info);
        justhis_pic = (ImageView) findViewById(R.id.justhis_pic);

    }

    private Button.OnClickListener backMain = new Button.OnClickListener() {

        @Override
        public void onClick(View arg0) {
            JUSTHIS.this.finish();
        }
    };


}