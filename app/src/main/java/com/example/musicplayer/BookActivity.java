package com.example.musicplayer;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

abstract class DoubleClickListener3 implements View.OnClickListener {
    private static final long DOUBLE_TIME = 1000;
    private static long lastClickTime = 0;

    @Override
    public void onClick(View v) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - lastClickTime < DOUBLE_TIME) {
            onDoubleClick(v);
        }
        lastClickTime = currentTimeMillis;
    }

    public abstract void onDoubleClick(View v);
}


public class BookActivity extends AppCompatActivity {
    private SoundPool soundPool;
    private int soundID;
    private MediaPlayer music;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        initSound();
        Button movie = (Button) findViewById(R.id.book);
        movie.setOnClickListener(new DoubleClickListener3() {
            @Override
            public void onDoubleClick(View v) {
                Intent intent = new Intent(BookActivity.this, MovieActivity.class);
                startActivity(intent);
                playSound();
            }
        });
    }

    private void initSound() {
        soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        soundID =soundPool .load(this, R.raw.dianying, 1);

    }
    private void playSound() {
        soundPool.play(
                soundID,0.5f,0.5f,0,0,1
        );}

}
