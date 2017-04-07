package com.psychology.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import com.psychology.Entity.Secret;
import com.psychology.UI.SecretItemActivity;
import com.psychology.UI.fragment.SecretFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LeiZhen on 2017/3/23.
 */

public class SecretAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    //上拉加载更多
    public static final int PULLUP_LOAD_MORE = 0;
    //正在加载中
    public static final int LOADING_MORE = 1;
    //上拉加载更多状态-默认为0
    private int load_more_status = 0;

    private static final int TYPE_ITEM = 0; //普通Item View
    private static final int TYPE_FOOTER = 1; //底部FootView

    private LayoutInflater mInflater;
    private int mPosition = 0;

    private ArrayList<Secret> mSecret = null;


    public SecretAdapter(Context context){
        this.mInflater=LayoutInflater.from(context);
        this.mSecret = new ArrayList<Secret>();

        getSecretFromDb();
    }

    public Secret getSecret(){
        return mSecret.get(mPosition);
    }

    public void getSecretFromDb(){
        if(mSecret != null){
            if(!mSecret.isEmpty()){
                mSecret.clear();
            }
        }

        String n1 = "好烦啊啊啊 啊啊，我期末考试挂了三科，感觉无颜见父母了";
        String d1 = "我今年大二，上个学期有点贪玩，经常翘课，然后上个学期期末的时候，还发现了一款特别好玩的游戏，导致期末没有好好复习，现在挂了三科，父母对我的期望一直特别高，现在感觉无颜回去见他们，好烦好烦";
        String [] p1 = {"不用烦的，挂个科而已，下个学期努力就行","挂科不是很正常吗，这么多人都挂过科，他们也没有太悲伤啊","塞翁失马，焉知非福","加油！下学期争取别挂了","反思下你这学期都干嘛去了","记得总结，多问同学问题","挂科而已，还有人说，没挂过科的大学是不完整的呢","加油！","别灰心丧气，加油！","下学期认真上课，别翘课就行了","加油！努力！坚持！"};
        Secret s1 = new Secret(n1,5,p1,d1);

        String n2 = "。。。昨天跟我女朋友大吵了一架，现在很难受";
        String d2 = "...";
        String [] p2 = {"...","..."};
        Secret s2 = new Secret(n2,3,p2,d2);

        String n3 = "室友天天晚上打游戏，真的吵死人了，好想换寝室啊，怎么说都没用";
        String d3 = "...";
        String [] p3 = {"...","...",",,,,"};
        Secret s3 = new Secret(n3,5,p3,d3);

        String n4 = "总感觉融入不了学校，感觉自己和他们格格不入";
        String d4 = "...";
        String [] p4 = {"..."};
        Secret s4 = new Secret(n4,2,p4,d4);

        String n5 = "感觉自己被室友孤立了";
        String d5 = "...";
        String [] p5 = {"...","..."};
        Secret s5 = new Secret(n5,2,p5,d5);

        mSecret.add(s1);mSecret.add(s2);mSecret.add(s3);mSecret.add(s4);mSecret.add(s5);
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
            ((ItemViewHolder)holder).list_item_secret_textView.setText(mSecret.get(position).getNeirong());
            ((ItemViewHolder)holder).list_item_secret_zan.setText("赞"+mSecret.get(position).getZan());
            ((ItemViewHolder)holder).list_item_secret_pinglun.setText("评论"+mSecret.get(position).getPinglun().length);
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
        mPosition = position;
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
        return mSecret.size()+1;
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

    //add in the start
    public void addItem(ArrayList<Secret> newSecret) {
        //mTitles.add(position, data);
        //notifyItemInserted(position);

        newSecret.addAll(mSecret);
        mSecret.removeAll(mSecret);
        mSecret.addAll(newSecret);

        notifyDataSetChanged();
    }

    //add in the end
    public void addMoreItem(ArrayList<Secret> moreSecret) {
        mSecret.addAll(moreSecret);
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
