package com.hp.hp.online_shopping;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    ViewPager viewPager;
    TabLayout indicator;
    private List<Integer> imageites;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        viewPager=(ViewPager) view.findViewById(R.id.viewPager);
        indicator=(TabLayout)view.findViewById(R.id.indicator);
        imageites=new ArrayList<>();
        imageites.add(R.drawable.splash1);
        imageites.add(R.drawable.banner1);
        imageites.add(R.drawable.splash1);
        imageites.add(R.drawable.banner1);
        viewPager.setAdapter(new SliderAdapter(getContext(),imageites));
        indicator.setupWithViewPager(viewPager,true);
        Timer timer=new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(),3000,3000);

        return view;
    }
    class SliderTimer extends TimerTask {

        @Override
        public void run() {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem()<imageites.size()-1){
                        viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                    }else {
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }
}