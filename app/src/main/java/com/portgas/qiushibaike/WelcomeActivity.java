package com.portgas.qiushibaike;

import android.content.Intent;
import android.media.Image;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class WelcomeActivity extends AppCompatActivity implements Runnable {
    private ImageView mImageView;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0x123:
                    mImageView.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        mImageView = (ImageView) findViewById(R.id.welcome_image_view);

        getSupportActionBar().hide();

        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);

            handler.sendEmptyMessage(0x123);

            Thread.sleep(2000);
            startActivity(new Intent(this, MainActivity.class));

            finish();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
