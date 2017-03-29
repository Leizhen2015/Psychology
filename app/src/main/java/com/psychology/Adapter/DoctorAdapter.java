package com.psychology.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.psychology.Entity.Doctor;

import java.util.List;

/**
 * Created by LeiZhen on 2017/3/29.
 */

public class DoctorAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    //上拉加载更多
    public static final int PULLUP_LOAD_MORE = 0;
    //正在加载中
    public static final int LOADING_MORE = 1;
    //上拉加载更多状态-默认为0
    private int load_more_status = 0;

    private static final int TYPE_ITEM = 0; //普通Item View
    private static final int TYPE_FOOTER = 1; //底部FootView

    private LayoutInflater mInflater;
    private List<Doctor> mDoctor = null;


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
