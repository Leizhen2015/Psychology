package com.psychology.UI.fragment;

import android.content.Intent;
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
import com.psychology.Entity.Secret;
import com.psychology.UI.SecretItemActivity;
import com.psychology.UI.widget.SecretDecoration;
import com.psychology.Adapter.SecretAdapter;

import java.lang.reflect.Field;
import java.util.ArrayList;

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
    private SecretAdapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private TextView list_item_secret_textview;
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

        LinearLayout linear_bar=(LinearLayout)view.findViewById(R.id.secret_linear_bar);
        linear_bar.setVisibility(View.VISIBLE);
        int statusHeight=getStatusBarHeight();
        android.widget.LinearLayout.LayoutParams params=(android.widget.LinearLayout.LayoutParams )linear_bar.getLayoutParams();
        params.height=statusHeight;
        linear_bar.setLayoutParams(params);

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
        secret_recylerView.addItemDecoration(new SecretDecoration(this.getActivity(),OrientationHelper.VERTICAL));
        adapter = new SecretAdapter(this.getActivity());
        secret_recylerView.setAdapter(adapter);
        secret_swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
            @Override
            public void onRefresh(){
                Log.d("onrefresh","invoke onRefresh...");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        ArrayList<Secret> newAl = new ArrayList<Secret>();

                        for(int i = 0;i<5;i++){
                            int index = i*2 -1;
                            String [] s1 = {"fff","ffff","ffd"};
                            Secret s = new Secret("Example" + i ,3+i,s1,"description" + i);
                            newAl.add(s);
                        }
                        adapter.addItem(newAl);
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
                    adapter.changeMoreStatus(SecretAdapter.LOADING_MORE);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ArrayList<Secret> newAl = new ArrayList<Secret>();

                            for(int i = 0;i<5;i++){
                                int index = i*2 -1;
                                String [] s1 = {"fff","ffff","ffd"};
                                Secret s = new Secret("MoreExample" + i ,3+i,s1,"MoreDescription" + i);
                                newAl.add(s);
                            }
                            adapter.addMoreItem(newAl);
                            adapter.changeMoreStatus(SecretAdapter.PULLUP_LOAD_MORE);
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

        list_item_secret_textview = (TextView)view.findViewById(R.id.list_item_secret_textView);
        list_item_secret_textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle mBundle = new Bundle();
                mBundle.putSerializable("Secret",adapter.getSecret());
                Intent intent = new Intent();
                intent.putExtras(mBundle);
                intent.setClass(getActivity(), SecretItemActivity.class);
                startActivity(intent);
                onDestroy();


            }
        });


        return view;
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
