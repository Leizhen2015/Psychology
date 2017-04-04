package com.psychology.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.leizhen.psychology.R;
import com.psychology.Entity.Doctor;
import com.psychology.Entity.EntityConstant.DoctorConstant;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public DoctorAdapter(Context context){

        this.mInflater = LayoutInflater.from(context);
        this.mDoctor = new ArrayList<Doctor>();

        getDataFromDb(100);
    }

    public void getDataFromDb(int xuexiao){

        if(mDoctor != null){
            if(!mDoctor.isEmpty()) {
                mDoctor.clear();
            }
        }

        ArrayList<Integer> a1 = new ArrayList<Integer>(){{
            add(1);add(2);add(3);add(4);
        }};
        String s1 = "张医生虽然工作年龄不长，但是富有年轻人的钻研精神，不畏困难，收获了大量患者的好评";
        Doctor d1 = new Doctor("张丽",27,a1,s1,1001,100,1);

        a1.clear();
        a1.add(2);a1.add(3);a1.add(4);a1.add(6);
        String s2 = "李辰医生已从事这方面的工作二十几载，经验丰富，性格温厚，成功的救助了大批患者";
        Doctor d2 = new Doctor("李辰",58,a1,s2,1001,100,1);

        a1.clear();
        a1.add(7);a1.add(8);a1.add(9);a1.add(10);
        String s3 = "徐希医生在国外工作多年，拥有丰富的经验，多次参加大型研讨会，发表很多相关论文，经验丰富";
        Doctor d3 = new Doctor("徐希",42,a1,s3,1001,100,1);

        a1.clear();
        a1.add(10);a1.add(11);a1.add(12);a1.add(13);
        String s4 = "陈晨医生博士毕业后一直潜心于研究心理疾病，成果斐然，从业以来，他将自己多年的研究应用于实际中，效果显著";
        Doctor d4 = new Doctor("陈晨",31,a1,s4,1003,100,1);

        mDoctor.add(d1);
        mDoctor.add(d2);
        mDoctor.add(d3);
        mDoctor.add(d4);

        /*
        for(int i = 0;i < 10;i++){
            ArrayList<Integer> aTime = new ArrayList<Integer>();
            Random rand = new Random(i);
                int jj = rand.nextInt(10);
                for(int j = 0;j<jj;j++){
                    int r1 = rand.nextInt(14);
                    aTime.add(r1);
                }

                int r2 = 100;//xuexiao
                int r3 = (rand.nextInt(2) + 1) * 1000 + rand.nextInt(4) + 1;//xiaoqu
                int r4 = rand.nextInt(2);//guanzhu

            Doctor lDoctor = new Doctor("name" + i,i*(rand.nextInt(10)),aTime,"jieshao" + i,r3,r2,r4);
            mDoctor.add(lDoctor);
        }
        */

    }

    public String getTimeString(ArrayList<Integer> mArray){
        String timeString = "";

        for(int i = 0; i < mArray.size();i++){
            timeString = timeString + DoctorConstant.mMap.get(mArray.get(i));
        }
        return timeString;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == TYPE_ITEM){
            final View view=mInflater.inflate(R.layout.list_item_doctor,parent,false);
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

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof DoctorAdapter.ItemViewHolder){
            ((DoctorAdapter.ItemViewHolder)holder).list_item_doctor_name.setText("姓名: " + mDoctor.get(position).getName());
            ((DoctorAdapter.ItemViewHolder)holder).list_item_doctor_age.setText("年龄: "+mDoctor.get(position).getAge());
            ((DoctorAdapter.ItemViewHolder)holder).list_item_doctor_school.setText("学校: "+ DoctorConstant.mMap.get(mDoctor.get(position).getXuexiao()) + DoctorConstant.mMap.get(mDoctor.get(position).getXiaoqu()) );
            ((DoctorAdapter.ItemViewHolder)holder).list_item_doctor_time.setText("时间: " + getTimeString(mDoctor.get(position).getaTime()));
            ((DoctorAdapter.ItemViewHolder)holder).list_item_doctor_jieshao.setText("简介: " + mDoctor.get(position).getJieshao());
            ((DoctorAdapter.ItemViewHolder)holder).itemView.setTag(position);
        }else if(holder instanceof DoctorAdapter.FootViewHolder){
            DoctorAdapter.FootViewHolder footViewHolder = (DoctorAdapter.FootViewHolder)holder;
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
    public int getItemCount(){return mDoctor.size()+1;}




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

    //ViewHolder
    public static class ItemViewHolder extends RecyclerView.ViewHolder{
        public ImageView list_item_doctor_image;
        public TextView list_item_doctor_name;
        public TextView list_item_doctor_age;
        public TextView list_item_doctor_school;
        public TextView list_item_doctor_time;
        public TextView list_item_doctor_jieshao;
        public Button list_item_doctor_yuyue;
        public ItemViewHolder(View itemView) {
            super(itemView);
            list_item_doctor_image = (ImageView) itemView.findViewById(R.id.list_item_doctor_image);
            list_item_doctor_name = (TextView) itemView.findViewById(R.id.list_item_doctor_name);
            list_item_doctor_age = (TextView) itemView.findViewById(R.id.list_item_doctor_age);
            list_item_doctor_school = (TextView) itemView.findViewById(R.id.list_item_doctor_school);
            list_item_doctor_time = (TextView) itemView.findViewById(R.id.list_item_doctor_time);
            list_item_doctor_jieshao = (TextView)itemView.findViewById(R.id.list_item_doctor_jieshao);
            list_item_doctor_yuyue = (Button)itemView.findViewById(R.id.list_item_doctor_yuyue);
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

    //add item in the head
    public void addItemStart(List<Doctor> newDoctor){
        newDoctor.addAll(mDoctor);
        mDoctor.removeAll(mDoctor);
        mDoctor.addAll(newDoctor);
        notifyDataSetChanged();
    }

    //add item in the end
    public void addItemEnd(List<Doctor> newDoctor){
        mDoctor.addAll(newDoctor);
        notifyDataSetChanged();
    }

    //sort by four rules and refresh the adapter
    /*

        2 = xiaoqu
        3 = time
        4 = guanzhu
     */
    public void sort(int i){

        switch(i){
            case 2:

                notifyDataSetChanged();
                break;
            case 3:

                notifyDataSetChanged();
                break;
            case 4:

                notifyDataSetChanged();
                break;
        }
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

    //get more data
    public List<Doctor>  getMoreData(){

        int xuexiao = mDoctor.get(0).getXuexiao();
        List<Doctor> newDoctor = new ArrayList<Doctor>();

        for(int i = 0;i < 5;i++){
            ArrayList<Integer> aTime = new ArrayList<Integer>();
            Random rand = new Random(i*2);
            int jj = rand.nextInt(10);
            for(int j = 0;j<jj;j++){
                int r1 = rand.nextInt(14);
                aTime.add(r1);
            }

            int r2 = xuexiao;//xuexiao
            int r3 = (rand.nextInt(2) + 1) * 1000 + rand.nextInt(4) + 1;//xiaoqu
            int r4 = rand.nextInt(2);//guanzhu

            Doctor lDoctor = new Doctor("NewName" + i,i*(rand.nextInt(10)),aTime,"NewJieshao" + i,r3,r2,r4);
            newDoctor.add(lDoctor);
        }
        return newDoctor;
    }


}
