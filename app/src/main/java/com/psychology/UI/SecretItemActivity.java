package com.psychology.UI;

import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.leizhen.psychology.R;
import com.psychology.Adapter.SecretItemActivityAdapter;
import com.psychology.Entity.Secret;

import java.lang.reflect.Field;

public class SecretItemActivity extends AppCompatActivity {

    private Secret mSecret;

    private ImageButton activity_secret_item_return;
    private TextView activity_secret_item_description;
    private TextView activity_secret_item_zan;
    private TextView activity_secret_item_pinglun;
    private ImageButton activity_secret_item_imagebutton_zan;
    private ImageButton activity_secret_item_imagebutton_pinglun;
    private ImageButton activity_secret_item_imagebutton_fenxiang;
    private RecyclerView activity_secret_item_recyclerview;

    private SecretItemActivityAdapter mAdapter;
    private LinearLayoutManager linearLayoutManager;

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
        LinearLayout linear_bar=(LinearLayout)findViewById(R.id.secret_linear_bar);
        linear_bar.setVisibility(View.VISIBLE);
        int statusHeight=getStatusBarHeight();
        android.widget.LinearLayout.LayoutParams params=(android.widget.LinearLayout.LayoutParams )linear_bar.getLayoutParams();
        params.height=statusHeight;
        linear_bar.setLayoutParams(params);


        Intent intent = this.getIntent();
        mSecret = (Secret)intent.getSerializableExtra("Secret");

        //
        activity_secret_item_return = (ImageButton)findViewById(R.id.activity_secret_item_return);
        activity_secret_item_description = (TextView)findViewById(R.id.activity_secret_item_description);
        activity_secret_item_zan = (TextView)findViewById(R.id.activity_secret_item_zan);
        activity_secret_item_pinglun = (TextView)findViewById(R.id.activity_secret_item_pinglun);
        activity_secret_item_imagebutton_zan = (ImageButton)findViewById(R.id.activity_secret_item_imagebutton_zan);
        activity_secret_item_imagebutton_pinglun =(ImageButton)findViewById(R.id.activity_secret_item_imagebutton_pinglun);
        activity_secret_item_imagebutton_fenxiang = (ImageButton)findViewById(R.id.activity_secret_item_imagebutton_fenxiang);
        activity_secret_item_recyclerview = (RecyclerView)findViewById(R.id.activity_secret_item_recyclerview);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        mAdapter = new SecretItemActivityAdapter(this,mSecret);
        activity_secret_item_recyclerview.setAdapter(mAdapter);

    }

    /**
     * 获取状态栏的高度
     * @return
     */

    private int getStatusBarHeight(){
        try
        {
            Class<?> c=Class.forName("com.android.internal.R$dimen");
            Object obj=c.newInstance();
            Field field=c.getField("status_bar_height");
            int x=Integer.parseInt(field.get(obj).toString());
            return  getResources().getDimensionPixelSize(x);
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

}
