package com.example.demo2;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 vp;
    public static Button bt1, bt2, bt3, bt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();

        initClick();
    }

    private void initFragment() {
        final List<Fragment> list = new ArrayList<>();
        list.add(new Fragment1());
        list.add(new Fragment2());
        list.add(new Fragment3());
        list.add(new Fragment4());

        vp = findViewById(R.id.viewpage2);//获得ViewPager2控件
        vp.setOffscreenPageLimit(list.size() - 1);

        //设置适配器
        FragmentStateAdapter adapter = new FragmentStateAdapter(MainActivity.this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                return list.get(position);
            }

            @Override
            public int getItemCount() {
                return list.size();
            }
        };

        vp.setAdapter(adapter);//把适配器添加给ViewPager2
    }

    @SuppressLint("WrongViewCast")
    private void initClick() {
        //给新品选项添加点击事件
        bt1 = findViewById(R.id.button);
        bt1.setOnClickListener(view -> {
            vp.setCurrentItem(0, false);
            bt1.setTextColor(Color.rgb(0, 188, 212));
            bt2.setTextColor(Color.rgb(148, 148, 148));
            bt3.setTextColor(Color.rgb(148, 148, 148));
            bt4.setTextColor(Color.rgb(148, 148, 148));
        });

        bt2 = findViewById(R.id.button2);
        bt2.setOnClickListener(view -> {
            vp.setCurrentItem(1, false);
            bt2.setTextColor(Color.rgb(0, 188, 212));
            bt1.setTextColor(Color.rgb(148, 148, 148));
            bt3.setTextColor(Color.rgb(148, 148, 148));
            bt4.setTextColor(Color.rgb(148, 148, 148));
        });

        bt3 = findViewById(R.id.button3);
        bt3.setOnClickListener(view -> {
            vp.setCurrentItem(2, false);
            bt3.setTextColor(Color.rgb(0, 188, 212));
            bt2.setTextColor(Color.rgb(148, 148, 148));
            bt1.setTextColor(Color.rgb(148, 148, 148));
            bt4.setTextColor(Color.rgb(148, 148, 148));
        });

        bt4 = findViewById(R.id.button4);
        bt4.setOnClickListener(view -> {
            vp.setCurrentItem(4, false);
            bt4.setTextColor(Color.rgb(0, 188, 212));
            bt2.setTextColor(Color.rgb(148, 148, 148));
            bt3.setTextColor(Color.rgb(148, 148, 148));
            bt1.setTextColor(Color.rgb(148, 148, 148));
        });
    }
}