package com.rio.biru;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.animation.Animator;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;

public class Daftar2Activity extends AppCompatActivity {

    Animation anim_daftar3,carilokasi,searchbox;
    //LinearLayout linearLayout;
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar2);
        getSupportActionBar().hide();

        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        getWindow().setStatusBarColor(ContextCompat.getColor(Daftar2Activity.this, R.color.StatusBar));

        anim_daftar3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_daftar3);
        carilokasi = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.carilokasi);
        searchbox = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.searchbox);
        //linearLayout = findViewById(R.id.linearputih);
        textView = findViewById(R.id.tvcarilokasi);
        editText = findViewById(R.id.searchbox);



        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                rio();
            }
        },100);

        //linearLayout.startAnimation(anim_daftar3);
        textView.startAnimation(carilokasi);
        editText.startAnimation(searchbox);

    }

    private void rio() {
        // previously invisible view
        LinearLayout myView = findViewById(R.id.linearputih);

        // Check if the runtime version is at least Lollipop
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // get the center for the clipping circle
            //int cx = myView.getWidth() / 2;//540
            //int cy = myView.getHeight() / 2;//865

            int cx = 800;
            int cy = 1500;

            // get the final radius for the clipping circle
            int finalRadius = Math.max(myView.getWidth(), myView.getHeight());

            // create the animator for this view (the start radius is zero)
            Animator anim = ViewAnimationUtils.createCircularReveal(myView, cx, cy, 0, finalRadius);

            // make the view visible and start the animation
            myView.setVisibility(View.VISIBLE);
            anim.setDuration(800);
            anim.start();
        } else {
            // set the view to invisible without a circular reveal animation below Lollipop
            myView.setVisibility(View.INVISIBLE);
        }
    }
}
