package com.example.demo2;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SYT extends AppCompatActivity {

    private MediaPlayer mPlayer;
    private Button btn_back2;
    private Button btn_music2;
    private Button btn_stop2;
    private boolean isPause = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syt);

        btn_music2 = findViewById(R.id.btn_music2);
        btn_stop2 = findViewById(R.id.btn_stop2);
        btn_back2 = findViewById(R.id.btn_back2);
        btn_music2.setOnClickListener(view -> {
            if ("播放".equals(btn_music2.getText().toString())) {
                btn_music2.setText("播放中");
                initPlayer();//加载音乐
            }
        });

        btn_stop2.setOnClickListener(view -> {
            if (!isPause) {
                mPlayer.pause();//暂停音乐播放
                btn_stop2.setText("继续");
                isPause = true;
            } else {
                mPlayer.start();//继续开始音乐播放
                btn_stop2.setText("暂停");
                isPause = false;
            }
        });

        btn_back2.setOnClickListener(v -> {
            finish();
        });
    }

    private void initPlayer() {
        mPlayer = MediaPlayer.create(this, R.raw.syt);
        mPlayer.setLooping(true);//设置为循环播放
        mPlayer.start();//开始播放音乐
    }

    @Override
    protected void onDestroy() {//销毁
        super.onDestroy();
        if (mPlayer != null) {
            mPlayer.stop();//停止播放音乐
        }
    }
}