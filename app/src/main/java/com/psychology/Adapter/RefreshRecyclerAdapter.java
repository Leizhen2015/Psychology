package com.psychology.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.leizhen.psychology.R;
import com.psychology.Entity.Doctor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LeiZhen on 2017/3/23.
 */

public class RefreshRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    //上拉加载更多
    public static final int PULLUP_LOAD_MORE = 0;
    //正在加载中
    public static final int LOADING_MORE = 1;
    //上拉加载更多状态-默认为0
    private int load_more_status = 0;

    private static final int TYPE_ITEM = 0; //普通Item View
    private static final int TYPE_FOOTER = 1; //底部FootView

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
        for (int i=0;i<8;i++){
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
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
     if(viewType == TYPE_ITEM){
         final View view=mInflater.inflate(R.layout.list_item_secret,parent,false);
         //这边可以做一些属性设置，甚至事件监听绑定
         ItemViewHolder itemViewHolder =new ItemViewHolder(view);
         return itemViewHolder;
     }else if(viewType == TYPE_FOOTER){
         final View foot_view = mInflater.inflate(R.layout.footview_loadmore_layout,parent,false);
         //这边可以做一些属性设置，甚至事件监听绑定
         FootViewHolder footViewHolder = new FootViewHolder(foot_view);
         return footViewHolder;
     }
     return null;
    }

    /**
     * 数据的绑定显示
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ItemViewHolder){
            ((ItemViewHolder)holder).list_item_secret_textView.setText(mTextView.get(position));
            ((ItemViewHolder)holder).list_item_secret_zan.setText("赞"+mZan.get(position));
            ((ItemViewHolder)holder).list_item_secret_pinglun.setText("评论"+mPingLun.get(position));
            ((ItemViewHolder)holder).itemView.setTag(position);
        }else if(holder instanceof FootViewHolder){
            FootViewHolder footViewHolder = (FootViewHolder)holder;
            switch(load_more_status){
                case PULLUP_LOAD_MORE:
                    footViewHolder.foot_view_item_tv.setText("上拉加载更多...");
                    break;
                case LOADING_MORE:
                    footViewHolder.foot_view_item_tv.setText("正在加载更多数据...");
                    break;
            }
        }
    }

    @Override
    public int getItemViewType(int position){
        int i = position + 1;
        int item = getItemCount();
        if((position + 1) == getItemCount()){
            return TYPE_FOOTER;
        }else{
            return TYPE_ITEM;
        }
    }

    @Override
    public int getItemCount() {
        return mTextView.size()+1;
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout list_item_secret_linearlayout;
        public TextView list_item_secret_textView;
        public TextView list_item_secret_zan;
        public TextView list_item_secret_pinglun;
        public ImageButton list_item_secret_imagebutton_zan;
        public ImageButton list_item_secret_imagebutton_pinglun;
        public ImageButton list_item_secret_imagebutton_fenxiang;

        public ItemViewHolder(View view){
            super(view);
            list_item_secret_linearlayout = (LinearLayout) view.findViewById(R.id.list_item_secret_linearlayout);
            list_item_secret_textView = (TextView)view.findViewById(R.id.list_item_secret_textView);
            list_item_secret_zan = (TextView)view.findViewById(R.id.list_item_secret_zan);
            list_item_secret_pinglun = (TextView)view.findViewById(R.id.list_item_secret_pinglun);
            list_item_secret_imagebutton_zan = (ImageButton)view.findViewById(R.id.list_item_secret_imagebutton_zan);
            list_item_secret_imagebutton_pinglun = (ImageButton)view.findViewById(R.id.list_item_secret_imagebutton_pinglun);
            list_item_secret_imagebutton_fenxiang = (ImageButton)view.findViewById(R.id.list_item_secret_imagebutton_fenxiang);
        }
    }

    //底部FootView布局
    public static class FootViewHolder extends RecyclerView.ViewHolder{
        private TextView foot_view_item_tv;
        public FootViewHolder(View view){
            super(view);
            foot_view_item_tv = (TextView)view.findViewById(R.id.foot_view_item_tv);
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

    /**
     * //上拉加载更多
     * PULLUP_LOAD_MORE=0;
     * //正在加载中
     * LOADING_MORE=1;
     * //加载完成已经没有更多数据了
     * NO_MORE_DATA=2;
     * @param status
     */
    public void changeMoreStatus(int status){
        load_more_status = status;
        notifyDataSetChanged();
    }



}
