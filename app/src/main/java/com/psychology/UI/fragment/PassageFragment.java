package com.psychology.UI.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.leizhen.psychology.R;
import com.psychology.Adapter.PassageAdapter;
import com.psychology.Adapter.SecretAdapter;
import com.psychology.UI.widget.AdvancedDecoration;


import java.lang.reflect.Field;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link PassageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PassageFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private RecyclerView passage_recylerView;
    private LinearLayoutManager linearLayoutManager;
    private AdvancedDecoration passage_decoration;
    private PassageAdapter passage_adapter;

    private int lastVisibleItem;
    public PassageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment PassageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PassageFragment newInstance(String param1) {
        PassageFragment fragment = new PassageFragment();
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
        View view = inflater.inflate(R.layout.fragment_passage,container,false);

        LinearLayout linear_bar=(LinearLayout)view.findViewById(R.id.passage_linear_bar);
        linear_bar.setVisibility(View.VISIBLE);
        int statusHeight=getStatusBarHeight();
        android.widget.LinearLayout.LayoutParams params=(android.widget.LinearLayout.LayoutParams )linear_bar.getLayoutParams();
        params.height=statusHeight;
        linear_bar.setLayoutParams(params);


        passage_recylerView = (RecyclerView)view.findViewById(R.id.passage_recylerView);

        linearLayoutManager = new LinearLayoutManager(this.getActivity());
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        passage_recylerView.setLayoutManager(linearLayoutManager);
        //
        passage_adapter = new PassageAdapter(this.getActivity());
        passage_decoration = new AdvancedDecoration(this.getActivity(),OrientationHelper.VERTICAL);
        passage_recylerView.addItemDecoration(passage_decoration);
        passage_recylerView.setAdapter(passage_adapter);

        //RecyclerView滑动监听,也就是上拉加载
        passage_recylerView.setOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView,int newState){
                super.onScrollStateChanged(recyclerView, newState);
                if((newState == RecyclerView.SCROLL_STATE_IDLE) && (lastVisibleItem + 1 ==passage_adapter.getItemCount())){
                    passage_adapter.changeMoreStatus(SecretAdapter.LOADING_MORE);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            passage_adapter.addItemEnd(passage_adapter.getMoreData());
                            passage_adapter.changeMoreStatus(PassageAdapter.PULLUP_LOAD_MORE);
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


