package com.psychology.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.leizhen.psychology.R;
import com.psychology.Entity.Secret;

/**
 * Created by LeiZhen on 2017/4/4.
 */

public class SecretItemActivityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater mInflater;
    private Secret mSecret;

    public SecretItemActivityAdapter(Context context,Secret secret){
        this.mInflater = LayoutInflater.from(context);
        this.mSecret = secret;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = mInflater.inflate(R.layout.activity_secret_item,parent,false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ItemViewHolder)holder).activity_secret_item_pinglun_textview.setText(mSecret.getPinglun()[position]);
    }

    @Override
    public int getItemCount() {
        return mSecret.getPinglun().length;
    }

    //ViewHolder
    public static class ItemViewHolder extends RecyclerView.ViewHolder{
        public TextView activity_secret_item_pinglun_textview;
        public ItemViewHolder(View view){
            super(view);
            activity_secret_item_pinglun_textview = (TextView)view.findViewById(R.id.activity_secret_item_pinglun_textview);
        }

    }

}
