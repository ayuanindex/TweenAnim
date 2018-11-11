package com.ayuan.tweenanim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        Button btn4 = (Button) findViewById(R.id.btn4);
        Button btn5 = (Button) findViewById(R.id.btn5);
        Button jump = (Button) findViewById(R.id.btn_jump);
        jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestActivity.class);
                startActivity(intent);
            }
        });
        iv = (ImageView) findViewById(R.id.iv);
        //点击按钮实现透明效果
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * fromAlpha：设置为1.0表示完全不透明，0.0表示完全透明
                 * toAlpha:设置为1.0表示完全不透明，0.0表示完全透明
                 */
                AlphaAnimation aa = new AlphaAnimation(1.0f, 0.0f);
                //设置动画执行的时长
                aa.setDuration(1000);
                //设置动画执行重复的次数
                aa.setRepeatCount(3);
                //设置动画执行的模式
                aa.setRepeatMode(Animation.REVERSE);
                //开始播放动画
                iv.startAnimation(aa);
            }
        });


        //点击按钮执行旋转动画
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * fromDegrees:开始旋转的角度
                 * toDegrees：结束的角度
                 */
                //RotateAnimation ra = new RotateAnimation(0, 360);
                RotateAnimation ra = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                ra.setDuration(500);
                ra.setRepeatCount(200);
                ra.setRepeatMode(Animation.REVERSE);
                iv.startAnimation(ra);
            }
        });

        //点击按钮执行缩放
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScaleAnimation sa = new ScaleAnimation(1.0f, 2.0f, 1.0f, 2.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                sa.setDuration(500);
                sa.setRepeatCount(200);
                sa.setRepeatMode(Animation.REVERSE);
                iv.startAnimation(sa);
            }
        });

        //点击按钮执行位移
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TranslateAnimation ta = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0.2f);
                ta.setDuration(500);
                //ta.setRepeatCount(1);
                //如果设置为true，则当动画结束后  动画停留在动画结束的位置
                ta.setFillAfter(true);
                ta.setRepeatMode(Animation.REVERSE);
                iv.startAnimation(ta);
            }
        });

        //动画一起被执行
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationSet set = new AnimationSet(true);
                AlphaAnimation aa = new AlphaAnimation(1.0f, 0.0f);
                //设置动画执行的时长
                aa.setDuration(1000);
                //设置动画执行重复的次数
                aa.setRepeatCount(200);
                //设置动画执行的模式
                aa.setRepeatMode(Animation.REVERSE);
                //------------------------------------------
                RotateAnimation ra = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                ra.setDuration(500);
                ra.setRepeatCount(200);
                ra.setRepeatMode(Animation.REVERSE);
                iv.startAnimation(ra);
                //-------------------------------------------------------------------
                ScaleAnimation sa = new ScaleAnimation(1.0f, 2.0f, 1.0f, 2.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                sa.setDuration(500);
                sa.setRepeatCount(200);
                sa.setRepeatMode(Animation.REVERSE);
                iv.startAnimation(sa);
                //---------------------------------------------------------------
                TranslateAnimation ta = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0.2f);
                ta.setDuration(500);
                ta.setRepeatCount(200);
                //如果设置为true，则当动画结束后  动画停留在动画结束的位置
                ta.setFillAfter(true);
                ta.setRepeatMode(Animation.REVERSE);
                iv.startAnimation(ta);
                //---------------------------------
                set.addAnimation(aa);
                set.addAnimation(ra);
                set.addAnimation(sa);
                set.addAnimation(ta);
                //执行动画
                iv.startAnimation(set);
            }
        });
    }
}
