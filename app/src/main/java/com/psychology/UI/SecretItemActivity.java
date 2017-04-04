package com.psychology.UI;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.leizhen.psychology.R;
import com.psychology.Entity.Secret;

public class SecretItemActivity extends AppCompatActivity {

    private Secret mSecret;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secret_item);

        //当系统版本为4.4或者4.4以上时可以使用沉浸式状态栏

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        Intent intent = this.getIntent();
        mSecret = (Secret)intent.getSerializableExtra("Secret");


    }
}
