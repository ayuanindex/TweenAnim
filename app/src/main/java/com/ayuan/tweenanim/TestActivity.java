package com.ayuan.tweenanim;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class TestActivity extends AppCompatActivity {

    private ImageView iv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        iv = (ImageView) findViewById(R.id.iv);
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        Button btn4 = (Button) findViewById(R.id.btn4);
        Button btn5 = (Button) findViewById(R.id.btn5);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation aa = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                iv.startAnimation(aa);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation ra = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
                iv.startAnimation(ra);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation sa = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scales);
                iv.startAnimation(sa);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation ta = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate);
                iv.startAnimation(ta);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation sa = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.set);
                iv.startAnimation(sa);
            }
        });
    }
}
