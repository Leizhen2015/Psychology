package com.psychology.UI;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.leizhen.psychology.R;
import com.psychology.UI.fragment.CompassFragment;
import com.psychology.UI.fragment.PassageFragment;
import com.psychology.UI.fragment.SecretFragment;
import com.psychology.UI.fragment.SettingFragment;
import com.psychology.UI.fragment.DoctorFragment;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener{

    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar)findViewById(R.id.main_bottom_navigation_bar);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_SHIFTING);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);
        bottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.ic_passage,"News").setActiveColorResource(R.color.colorOrange))
                .addItem(new BottomNavigationItem(R.mipmap.ic_compass,"Compass").setActiveColorResource(R.color.colorTeal))
                .addItem(new BottomNavigationItem(R.mipmap.ic_secret,"Secret").setActiveColorResource(R.color.colorBlue))
                .addItem(new BottomNavigationItem(R.mipmap.ic_doctor,"Doctor").setActiveColorResource(R.color.colorBrown))
                .addItem(new BottomNavigationItem(R.mipmap.ic_setting,"Setting").setActiveColorResource(R.color.colorGrey))
                .setFirstSelectedPosition(0)
                .initialise();

        fragments = getFragments();
        setDefaultFragment();
        bottomNavigationBar.setTabSelectedListener(this);

    }

    private  void setDefaultFragment(){

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.main_layFrame, PassageFragment.newInstance("Home"));
        transaction.commit();

    }

    private ArrayList<Fragment> getFragments(){

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(PassageFragment.newInstance("Home"));
        fragments.add(CompassFragment.newInstance("Books"));
        fragments.add(SecretFragment.newInstance("Music"));
        fragments.add(DoctorFragment.newInstance("Movies & TV"));
        fragments.add(SettingFragment.newInstance("Games"));
        return fragments;

    }

    @Override
    public void onTabSelected(int position){

        if (fragments != null) {
            if (position < fragments.size()) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment fragment = fragments.get(position);
                if (fragment.isAdded()) {
                    ft.replace(R.id.main_layFrame, fragment);
                } else {
                    ft.add(R.id.main_layFrame, fragment);
                }
                ft.commitAllowingStateLoss();
            }
        }

    }

    @Override
    public void onTabUnselected(int position){

        if (fragments != null) {
            if (position < fragments.size()) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment fragment = fragments.get(position);
                ft.remove(fragment);
                ft.commitAllowingStateLoss();
            }
        }

    }

    @Override
    public void onTabReselected(int position) {

    }




}
