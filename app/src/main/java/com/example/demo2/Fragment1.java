package com.example.demo2;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Fragment1 extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);          //关联布局文件

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);

        List<item> items = new ArrayList<item>();
        items.add(new item("宋岳庭", "代表作:Life's A Struggle ", R.drawable.syt));
        items.add(new item("JUSTHIS", "代表作:4 the Youth", R.drawable.justhis));
        items.add(new item("Kanye West", "代表作：Runnaway", R.drawable.kanyewest));
        items.add(new item("Mercy", "代表作:Back To Back Freestyle", R.drawable.mercy));
        items.add(new item("MF DOOM", "代表作:Doomsday", R.drawable.mfdoom));
        items.add(new item("Travis Scott", "代表作:YOSEMITE", R.drawable.travisscott));
        items.add(new item("Eminem", "代表作:Stan", R.drawable.eminem));
        items.add(new item("Nafla", "代表作:Wu", R.drawable.nafla));
        items.add(new item("Kid Milli", "代表作:Cliché", R.drawable.kidmilli));
        items.add(new item("Jvcki Wai", "代表作:Hyperreal", R.drawable.jvckiwai));
        items.add(new item("Dok2", "代表作:Click Me", R.drawable.dok2));
        items.add(new item("Koonta", "代表作:REPLICA", R.drawable.koonta));
        items.add(new item("D.Ark", "代表作:730Freestyle", R.drawable.dark));
        items.add(new item("Kendick Lanar", "代表作:N95", R.drawable.kendicklanar));
        items.add(new item("Drake", "代表作:In My Feelings", R.drawable.drake));

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new MyAdapter(getContext(), items));

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        MainActivity.bt1.setTextColor(Color.rgb(0, 188, 212));
        MainActivity.bt2.setTextColor(Color.rgb(148, 148, 148));
        MainActivity.bt3.setTextColor(Color.rgb(148, 148, 148));
        MainActivity.bt4.setTextColor(Color.rgb(148, 148, 148));
    }
}
