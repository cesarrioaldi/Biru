package com.rio.biru;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.karan.churi.PermissionManager.PermissionManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RelativeLayout relativeLayout,main;
    LinearLayout masuk,daftar,google;
    VideoView videoview;
    PermissionManager permissionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

         //getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

       getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.StatusBar));

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        videoview = findViewById(R.id.videoview);
        relativeLayout = findViewById(R.id.relativ_background);
        main = findViewById(R.id.main);
        masuk   = findViewById(R.id.masuk);
        daftar  = findViewById(R.id.daftar);
        google  = findViewById(R.id.google);

        permissionManager = new PermissionManager() {};
        permissionManager.checkAndRequestPermissions(this);

        masuk.setEnabled(false);
        daftar.setEnabled(false);
        google.setEnabled(false);

        Uri video = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.biruv);

        videoview.setVideoURI(video);

        videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                relativeLayout.setBackgroundResource(R.drawable.bbgg);
                masuk.setEnabled(true);
                daftar.setEnabled(true);
                google.setEnabled(true);
            }
        });

        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "masuk", Toast.LENGTH_SHORT).show();
            }
        });

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, DaftarActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "google", Toast.LENGTH_SHORT).show();
            }
        });

        videoview.start();

    }

}
