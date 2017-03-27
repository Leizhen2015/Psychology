package com.psychology.UI.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.leizhen.psychology.R;
import com.psychology.UI.widget.AdvancedDecoration;
import com.psychology.Adapter.RefreshRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link SecretFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecretFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    private LinearLayout top_bar_linear_back;
    private TextView top_bar_title;
    private SwipeRefreshLayout secret_swipeRefreshLayout;
    private RecyclerView secret_recylerView;
    private RefreshRecyclerAdapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private int lastVisibleItem;

    // TODO: Rename and change types of parameters
    private String mParam1;

    public SecretFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment SecretFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SecretFragment newInstance(String param1) {
        SecretFragment fragment = new SecretFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_secret,container,false);
        secret_swipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.secret_swipeRefreshLayout);
        secret_recylerView = (RecyclerView)view.findViewById(R.id.secret_recylerView);
        //
        secret_swipeRefreshLayout.setProgressBackgroundColorSchemeResource(android.R.color.white);
        secret_swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light,android.R.color.holo_red_light,
                android.R.color.holo_orange_light,android.R.color.holo_green_light);
        linearLayoutManager = new LinearLayoutManager(this.getActivity());
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        secret_recylerView.setLayoutManager(linearLayoutManager);
        //
        secret_recylerView.addItemDecoration(new AdvancedDecoration(this.getActivity(),OrientationHelper.VERTICAL));
        secret_recylerView.setAdapter(adapter = new RefreshRecyclerAdapter(this.getActivity()));
        secret_swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
            @Override
            public void onRefresh(){
                Log.d("onrefresh","invoke onRefresh...");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        List<String> newTextView = new ArrayList<String>();
                        List<String> newZan = new ArrayList<String>();
                        List<String> newPingLun = new ArrayList<String>();

                        //获取数据的方法
                        //getTextViewData()
                        //getZanData();
                        //getPingLunData();

                        for(int i = 0;i<5;i++){
                            int index = i*2 -1;
                            newTextView.add("this is new TextView " + index);
                            newZan.add("zan" + index);
                            newPingLun.add("pinglun" + index);
                        }
                        adapter.addItem(newTextView,newZan,newPingLun);
                        secret_swipeRefreshLayout.setRefreshing(false);
                        Toast.makeText(getActivity(),"更新了五条数据...",Toast.LENGTH_LONG).show();
                    }
                },5000);
            }
        });

        //RecyclerView滑动监听,也就是上拉加载
        secret_recylerView.setOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView,int newState){
                super.onScrollStateChanged(recyclerView, newState);
                if((newState == RecyclerView.SCROLL_STATE_IDLE) && (lastVisibleItem + 1 ==adapter.getItemCount())){
                    adapter.changeMoreStatus(RefreshRecyclerAdapter.LOADING_MORE);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            List<String> newTextView = new ArrayList<String>();
                            List<String> newZan = new ArrayList<String>();
                            List<String> newPingLun = new ArrayList<String>();

                            //获取数据的方法
                            //getTextViewData()
                            //getZanData();
                            //getPingLunData();

                            for(int i = 0;i<5;i++){
                                int index = i*2 + 1;
                                newTextView.add("this is more TextView " + index);
                                newZan.add("zan" + index);
                                newPingLun.add("pinglun" + index);
                            }
                            adapter.addMoreItem(newTextView,newZan,newPingLun);
                            adapter.changeMoreStatus(RefreshRecyclerAdapter.PULLUP_LOAD_MORE);
                        }
                    },1000);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView,int dx, int dy){
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
            }
        });

        return view;
    }

}
