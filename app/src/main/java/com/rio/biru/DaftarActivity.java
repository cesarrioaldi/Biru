package com.rio.biru;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class DaftarActivity extends AppCompatActivity {

    LinearLayout linear1,linear2;
    Animation pushleftin,pushleftin2;
    ImageButton klik;
    EditText etnama,etemail,etpassword,etkonfirmasipassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
        getSupportActionBar().hide();
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        getWindow().setStatusBarColor(ContextCompat.getColor(DaftarActivity.this, R.color.StatusBar));

        pushleftin = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.push_left_in);
        pushleftin2 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.push_left_in2);
        linear1 = findViewById(R.id.linear1);
        linear2 = findViewById(R.id.linear2);
        klik = findViewById(R.id.klik);
        etnama = findViewById(R.id.etnama);
        etemail = findViewById(R.id.etemail);
        etpassword = findViewById(R.id.etpassword);
        etkonfirmasipassword = findViewById(R.id.etkonfirmasipassword);

        klik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String pass,cpass;
//                pass = etpassword.getText().toString();
//                cpass = etkonfirmasipassword.getText().toString();
//
//                if (TextUtils.isEmpty(etnama.getText())){
//                    etnama.setError("Nama Wajib diisi");
//                }
//                else if (TextUtils.isEmpty(etemail.getText())){
//                    etemail.setError("Email Wajib diisi");
//                }
//                else if (TextUtils.isEmpty(etpassword.getText())){
//                    etpassword.setError("Password Wajib diisi");
//                }
//                else if (!pass.equals(cpass)){
//                    etkonfirmasipassword.setError("Password tidak cocok");
//                }
//                else {
//                    startActivity(new Intent(DaftarActivity.this, Daftar2Activity.class));
//                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
//                }
                startActivity(new Intent(DaftarActivity.this, Daftar2Activity.class));
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
            }
        });

        linear1.startAnimation(pushleftin);
        linear2.startAnimation(pushleftin2);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
