package com.psychology.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.leizhen.psychology.R;
import com.psychology.Entity.Compass;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by xiaoqiang on 2017/4/7.
 */

public class CompassAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    //上拉加载更多
    public static final int PULLUP_LOAD_MORE = 0;
    //正在加载中
    public static final int LOADING_MORE = 1;
    //上拉加载更多状态-默认为0
    private int load_more_status = 0;

    private static final int TYPE_ITEM = 0; //普通Item View
    private static final int TYPE_FOOTER = 1; //底部FootView

    private LayoutInflater mInflater;
    private List<Compass> mCompass = null;

    public CompassAdapter(Context context) {

        this.mInflater = LayoutInflater.from(context);
        this.mCompass = new ArrayList<Compass>();
        getCompassFromDB();

    }

    public void getCompassFromDB() {
        if (mCompass != null) {
            if (!mCompass.isEmpty()) {
                mCompass.clear();
            }
        }
        Date date1 = new Date(2016, 10, 10);
        Compass p1 = new Compass("缓解压力", "如何缓解压力", "人们在日常生活中，如何缓解和消除精神压力呢？ \n" +
                "　　1、轻快、舒畅的音乐不仅能给人美的熏陶和享受，而且还能使人的精神得到有效放松，因此，人们在紧张的工作和学习之余，不妨多听听音乐，让优美的乐曲来化解精神的疲惫。 \n" +
                "　　2、健康的开怀大笑是消除精神压力的最佳方法之一，同时也是一种愉快的发泄方式，为此，人们不妨遗忧忘虑，笑口常开。 \n" +
                "　　3、出门旅游也不失为一种好方法，但应多选择远离城市喧嚣的原野和乡村，因为人与自然的关系远比人与城市的关系亲近得多。 \n" +
                "　　4、有意识的放慢生活节奏，甚至可以把无所事事的时间也安排在日程表中，要明白悠然和闲散并不等于无聊，无聊才没有意义。 \n" +
                "　　5、沉着、冷静地处理各种纷繁复杂的事情，即使做错了事，也不要耿耿于怀的责备自已，要想到人人都会有犯错误的时候，这有利于人的心理平衡，同时也有助于舒缓人的精神压力。 \n" +
                "　　6、勇敢地面对现实，不要害伯承认自己的能力有限，在某些的确不能办到的事务中，坦实地说一声“不”比硬撑着要轻松得多。 ", "王强", date1);
        Date date2 = new Date(2016, 11, 10);
        Compass p2 = new Compass("缓解压力", "如何缓解压力", "人们在日常生活中，如何缓解和消除精神压力呢？ \n" +
                "　　1、轻快、舒畅的音乐不仅能给人美的熏陶和享受，而且还能使人的精神得到有效放松，因此，人们在紧张的工作和学习之余，不妨多听听音乐，让优美的乐曲来化解精神的疲惫。 \n" +
                "　　2、健康的开怀大笑是消除精神压力的最佳方法之一，同时也是一种愉快的发泄方式，为此，人们不妨遗忧忘虑，笑口常开。 \n" +
                "　　3、出门旅游也不失为一种好方法，但应多选择远离城市喧嚣的原野和乡村，因为人与自然的关系远比人与城市的关系亲近得多。 \n" +
                "　　4、有意识的放慢生活节奏，甚至可以把无所事事的时间也安排在日程表中，要明白悠然和闲散并不等于无聊，无聊才没有意义。 \n" +
                "　　5、沉着、冷静地处理各种纷繁复杂的事情，即使做错了事，也不要耿耿于怀的责备自已，要想到人人都会有犯错误的时候，这有利于人的心理平衡，同时也有助于舒缓人的精神压力。 \n" +
                "　　6、勇敢地面对现实，不要害伯承认自己的能力有限，在某些的确不能办到的事务中，坦实地说一声“不”比硬撑着要轻松得多。 ", "王强", date2);
        Date date4 = new Date(2016, 12, 10);
        Compass p4 = new Compass("缓解压力", "如何缓解压力", "人们在日常生活中，如何缓解和消除精神压力呢？ \n" +
                "　　1、轻快、舒畅的音乐不仅能给人美的熏陶和享受，而且还能使人的精神得到有效放松，因此，人们在紧张的工作和学习之余，不妨多听听音乐，让优美的乐曲来化解精神的疲惫。 \n" +
                "　　2、健康的开怀大笑是消除精神压力的最佳方法之一，同时也是一种愉快的发泄方式，为此，人们不妨遗忧忘虑，笑口常开。 \n" +
                "　　3、出门旅游也不失为一种好方法，但应多选择远离城市喧嚣的原野和乡村，因为人与自然的关系远比人与城市的关系亲近得多。 \n" +
                "　　4、有意识的放慢生活节奏，甚至可以把无所事事的时间也安排在日程表中，要明白悠然和闲散并不等于无聊，无聊才没有意义。 \n" +
                "　　5、沉着、冷静地处理各种纷繁复杂的事情，即使做错了事，也不要耿耿于怀的责备自已，要想到人人都会有犯错误的时候，这有利于人的心理平衡，同时也有助于舒缓人的精神压力。 \n" +
                "　　6、勇敢地面对现实，不要害伯承认自己的能力有限，在某些的确不能办到的事务中，坦实地说一声“不”比硬撑着要轻松得多。 ", "王强", date4);
        Date date3 = new Date(2016, 11, 20);
        Compass p3 = new Compass("缓解压力", "如何缓解压力", "人们在日常生活中，如何缓解和消除精神压力呢？ \n" +
                "　　1、轻快、舒畅的音乐不仅能给人美的熏陶和享受，而且还能使人的精神得到有效放松，因此，人们在紧张的工作和学习之余，不妨多听听音乐，让优美的乐曲来化解精神的疲惫。 \n" +
                "　　2、健康的开怀大笑是消除精神压力的最佳方法之一，同时也是一种愉快的发泄方式，为此，人们不妨遗忧忘虑，笑口常开。 \n" +
                "　　3、出门旅游也不失为一种好方法，但应多选择远离城市喧嚣的原野和乡村，因为人与自然的关系远比人与城市的关系亲近得多。 \n" +
                "　　4、有意识的放慢生活节奏，甚至可以把无所事事的时间也安排在日程表中，要明白悠然和闲散并不等于无聊，无聊才没有意义。 \n" +
                "　　5、沉着、冷静地处理各种纷繁复杂的事情，即使做错了事，也不要耿耿于怀的责备自已，要想到人人都会有犯错误的时候，这有利于人的心理平衡，同时也有助于舒缓人的精神压力。 \n" +
                "　　6、勇敢地面对现实，不要害伯承认自己的能力有限，在某些的确不能办到的事务中，坦实地说一声“不”比硬撑着要轻松得多。 ", "王强", date3);

        mCompass.add(p1);
        mCompass.add(p2);
        mCompass.add(p3);
        mCompass.add(p4);
    }
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder (ViewGroup parent,int viewType){
            if (viewType == TYPE_ITEM) {
                final View view = mInflater.inflate(R.layout.list_item_compass, parent, false);
                //这边可以做一些属性设置，甚至事件监听绑定
                CompassAdapter.ItemViewHolder itemViewHolder = new CompassAdapter.ItemViewHolder(view);
                return itemViewHolder;
            } else if (viewType == TYPE_FOOTER) {
                final View foot_view = mInflater.inflate(R.layout.footview_loadmore_layout, parent, false);
                //这边可以做一些属性设置，甚至事件监听绑定
                CompassAdapter.FootViewHolder footViewHolder = new CompassAdapter.FootViewHolder(foot_view);
                return footViewHolder;
            }
            return null;
        }

        @Override
        public void onBindViewHolder (RecyclerView.ViewHolder holder,int position){
            if (holder instanceof CompassAdapter.ItemViewHolder) {
                ((CompassAdapter.ItemViewHolder) holder).compass_title.setText(mCompass.get(position).getTitle());
                ((CompassAdapter.ItemViewHolder) holder).compass_type.setText(mCompass.get(position).getType());
                ((CompassAdapter.ItemViewHolder) holder).compass_con.setText(mCompass.get(position).getContent());
            } else if (holder instanceof CompassAdapter.FootViewHolder) {
                CompassAdapter.FootViewHolder footViewHolder = (CompassAdapter.FootViewHolder) holder;
                switch (load_more_status) {
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
        public int getItemCount () {
            return mCompass.size() + 1;
        }


        @Override
        public int getItemViewType ( int position){
            int i = position + 1;
            int item = getItemCount();
            if ((position + 1) == getItemCount()) {
                return TYPE_FOOTER;
            } else {
                return TYPE_ITEM;
            }
        }

        //ViewHolder
        public static class ItemViewHolder extends RecyclerView.ViewHolder {

            public TextView compass_type;
            public TextView compass_title;
            public TextView compass_con;

            public ItemViewHolder(View itemView) {
                super(itemView);
                compass_type = (TextView) itemView.findViewById(R.id.compass_type);
                compass_title = (TextView) itemView.findViewById(R.id.compass_title);
                compass_con = (TextView) itemView.findViewById(R.id.compass_con);
            }
        }

        //底部FootView布局
        public static class FootViewHolder extends RecyclerView.ViewHolder {
            private TextView foot_view_item_tv;

            public FootViewHolder(View view) {
                super(view);
                foot_view_item_tv = (TextView) view.findViewById(R.id.foot_view_item_tv);
            }
        }

        //add item in the head

    public void addItemStart(List<Compass> newCompass) {
        newCompass.addAll(mCompass);
        mCompass.removeAll(mCompass);
        mCompass.addAll(newCompass);
        notifyDataSetChanged();
    }

    //add item in the end
    public void addItemEnd(List<Compass> newCompass) {
        mCompass.addAll(newCompass);
        notifyDataSetChanged();
    }
    public void sort(int i) {

        switch (i) {
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
     *
     * @param status
     */
    public void changeMoreStatus(int status) {
        load_more_status = status;
        notifyDataSetChanged();
    }

    //get more data
    public List<Compass> getMoreData() {


        List<Compass> newCompass = new ArrayList<Compass>();

        for (int i = 0; i < 5; i++) {
            int a = 10;
            Date date1 = new Date(2016, 20, a + 1);
            Compass lCompass = new Compass("缓解压力", "如何缓解压力", "人们在日常生活中，如何缓解和消除精神压力呢？ \n" +
                    "　　1、轻快、舒畅的音乐不仅能给人美的熏陶和享受，而且还能使人的精神得到有效放松，因此，人们在紧张的工作和学习之余，不妨多听听音乐，让优美的乐曲来化解精神的疲惫。 \n" +
                    "　　2、健康的开怀大笑是消除精神压力的最佳方法之一，同时也是一种愉快的发泄方式，为此，人们不妨遗忧忘虑，笑口常开。 \n" +
                    "　　3、出门旅游也不失为一种好方法，但应多选择远离城市喧嚣的原野和乡村，因为人与自然的关系远比人与城市的关系亲近得多。 \n" +
                    "　　4、有意识的放慢生活节奏，甚至可以把无所事事的时间也安排在日程表中，要明白悠然和闲散并不等于无聊，无聊才没有意义。 \n" +
                    "　　5、沉着、冷静地处理各种纷繁复杂的事情，即使做错了事，也不要耿耿于怀的责备自已，要想到人人都会有犯错误的时候，这有利于人的心理平衡，同时也有助于舒缓人的精神压力。 \n" +
                    "　　6、勇敢地面对现实，不要害伯承认自己的能力有限，在某些的确不能办到的事务中，坦实地说一声“不”比硬撑着要轻松得多。 ", "王强", date1);
            newCompass.add(lCompass);
        }
        return newCompass;
    }

}



