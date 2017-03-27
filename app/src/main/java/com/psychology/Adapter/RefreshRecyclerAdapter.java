package com.psychology.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.leizhen.psychology.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LeiZhen on 2017/3/23.
 */

public class RefreshRecyclerAdapter extends RecyclerView.Adapter<RefreshRecyclerAdapter.ViewHolder> {

    private LayoutInflater mInflater;
    private List<String> mTextView=null;
    private List<String> mZan = null;
    private List<String> mPingLun = null;
    public RefreshRecyclerAdapter(Context context){
        this.mInflater=LayoutInflater.from(context);
        this.mTextView=new ArrayList<String>();
        this.mZan = new ArrayList<String>();
        this.mPingLun = new ArrayList<String>();
        //获取数据的方法
        //getTextViewData()
        //getZanData()
        //getPingLunData()
        for (int i=0;i<20;i++){
            int index=i+1;
            mTextView.add("Example"+index);
            mZan.add(""+index*2);
            mPingLun.add(""+index);
        }
    }
    /**
     * item显示类型
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view=mInflater.inflate(R.layout.list_item_secret,parent,false);
        //这边可以做一些属性设置，甚至事件监听绑定
        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;
    }

    /**
     * 数据的绑定显示
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.list_item_secret_textView.setText(mTextView.get(position));
        holder.list_item_secret_zan.setText("赞"+mZan.get(position));
        holder.list_item_secret_pinglun.setText("评论"+mPingLun.get(position));
        holder.itemView.setTag(position);
    }
    @Override
    public int getItemCount() {
        return mTextView.size();
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout list_item_secret_linearlayout;
        public TextView list_item_secret_textView;
        public TextView list_item_secret_zan;
        public TextView list_item_secret_pinglun;
        public Button list_item_secret_imagebutton_zan;
        public Button list_item_secret_imagebutton_pinglun;
        public Button list_item_secret_imagebutton_fenxiang;

        public ViewHolder(View view){
            super(view);
            list_item_secret_linearlayout = (LinearLayout) view.findViewById(R.id.list_item_secret_linearlayout);
            list_item_secret_textView = (TextView)view.findViewById(R.id.list_item_secret_textView);
            list_item_secret_zan = (TextView)view.findViewById(R.id.list_item_secret_zan);
            list_item_secret_pinglun = (TextView)view.findViewById(R.id.list_item_secret_pinglun);
            list_item_secret_imagebutton_zan = (Button)view.findViewById(R.id.list_item_secret_imagebutton_zan);
            list_item_secret_imagebutton_pinglun = (Button)view.findViewById(R.id.list_item_secret_imagebutton_pinglun);
            list_item_secret_imagebutton_fenxiang = (Button)view.findViewById(R.id.list_item_secret_imagebutton_fenxiang);
        }
    }

    //添加数据
    public void addItem(List<String> newDatas,List<String> newZan,List<String> newPinglun) {
        //mTitles.add(position, data);
        //notifyItemInserted(position);
        newDatas.addAll(mTextView);
        mTextView.removeAll(mTextView);
        mTextView.addAll(newDatas);

        newZan.addAll(mZan);
        mZan.removeAll(mZan);
        mZan.addAll(newZan);

        newPinglun.addAll(mPingLun);
        mPingLun.removeAll(mPingLun);
        mPingLun.addAll(newPinglun);

        notifyDataSetChanged();
    }

    public void addMoreItem(List<String> newDatas,List<String> newZan,List<String> newPinglun) {
        mTextView.addAll(newDatas);
        mZan.addAll(newZan);
        mPingLun.addAll(newPinglun);
        notifyDataSetChanged();
    }


}
