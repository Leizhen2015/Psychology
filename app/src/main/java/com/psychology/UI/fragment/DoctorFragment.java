package com.psychology.UI.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leizhen.psychology.R;
import com.psychology.Adapter.DoctorAdapter;
import com.psychology.UI.widget.DoctorDecoration;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link DoctorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DoctorFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";





    // TODO: Rename and change types of parameters
    private String mParam1;
    private RecyclerView doctor_recylerView;
    private SwipeRefreshLayout doctor_swipeRefreshLayout;
    private LinearLayoutManager linearLayoutManager;
    private DoctorDecoration doctor_decoration;
    private DoctorAdapter doctor_adapter;

    public DoctorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment DoctorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DoctorFragment newInstance(String param1) {
        DoctorFragment fragment = new DoctorFragment();
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
        View view = inflater.inflate(R.layout.fragment_doctor,container,false);

        doctor_swipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.doctor_swipeRefreshLayout);
        doctor_recylerView = (RecyclerView)view.findViewById(R.id.doctor_recylerView);
        //
        doctor_swipeRefreshLayout.setProgressBackgroundColorSchemeResource(android.R.color.white);
        doctor_swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light,android.R.color.holo_red_light,
                android.R.color.holo_orange_light,android.R.color.holo_green_light);
        linearLayoutManager = new LinearLayoutManager(this.getActivity());
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        doctor_recylerView.setLayoutManager(linearLayoutManager);
        //
        doctor_adapter = new DoctorAdapter();
        doctor_decoration = new DoctorDecoration(this.getActivity(),OrientationHelper.VERTICAL);



        return view;
    }

}
