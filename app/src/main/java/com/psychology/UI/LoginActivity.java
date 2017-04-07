package com.psychology.UI;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.leizhen.psychology.R;

/**
 * Created by xiaoqiang on 2017/4/5.
 */

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button button = (Button)this.findViewById(R.id.login_btn);
        button.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){

                LoginActivity.this.finish();

            }
        });



    }
}
