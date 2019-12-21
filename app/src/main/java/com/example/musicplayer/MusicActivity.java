package com.example.musicplayer;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

abstract class DoubleClickListener2 implements View.OnClickListener {
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

public class MusicActivity extends AppCompatActivity{
    private SoundPool soundPoolm;
    private int soundIDm;
    private MediaPlayer music;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        initSoundm();
        Button manzu= (Button) findViewById(R.id.manzu);
        manzu.setOnClickListener(new DoubleClickListener2() {
            @Override
            public void onDoubleClick(View v) {
                Intent intent = new Intent(MusicActivity.this, ManzuActivity.class);
                startActivity(intent);
                playSoundm();
            }
        });
    }

    private void initSoundm() {
        soundPoolm = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        soundIDm =soundPoolm .load(this, R.raw.manzu, 1);

    }
    private void playSoundm() {
        soundPoolm.play(
                soundIDm,0.5f,0.5f,0,0,1
        );}

}


