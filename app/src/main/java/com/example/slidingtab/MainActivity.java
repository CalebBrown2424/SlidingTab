package com.example.slidingtab;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 pager;
    private SliderAdapter adapter;
    private TabLayout tabLayout;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout  =  (TabLayout)findViewById(R.id.tabLayout);
        pager = (ViewPager2)findViewById(R.id.pager);
        adapter = new SliderAdapter(this);
        pager.setAdapter(adapter);
        new TabLayoutMediator(tabLayout, pager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if(position == 0) tab.setText("BreakFast");
                else if(position == 1) tab.setText("Lunch");
                else if(position == 2) tab.setText("Orange Juice");
                else tab.setText("Dinner");
            }
        }).attach();
    }

    private class SliderAdapter extends FragmentStateAdapter {

        public SliderAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            if(position == 0) return  new BreakfastFragment();
            else if(position == 1) return new LunchFragment();
            else if(position == 2) return new OJFragment();
            else return  new DinnerFragment();
        }

        @Override
        public int getItemCount() {
            return 4;
        }
    }
}