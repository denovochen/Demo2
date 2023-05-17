package com.example.demo2;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment4 extends Fragment {

    private Button btn_loginout;
    SharedPreferences sprfMain;
    SharedPreferences.Editor editorMain;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment4, container, false);//关联布局文件

        initView(view);

        return view;
    }

    private void initView(View view) {
        sprfMain = getActivity().getSharedPreferences("counter", Context.MODE_PRIVATE);
        btn_loginout = view.findViewById(R.id.btn_loginout);

        btn_loginout.setOnClickListener(view1 -> {
            editorMain = sprfMain.edit();
            editorMain.putBoolean("loginState", false);
            editorMain.commit();
            getActivity().finish();
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        MainActivity.bt4.setTextColor(Color.rgb(0, 188, 212));
        MainActivity.bt1.setTextColor(Color.rgb(148, 148, 148));
        MainActivity.bt3.setTextColor(Color.rgb(148, 148, 148));
        MainActivity.bt2.setTextColor(Color.rgb(148, 148, 148));
    }

}
