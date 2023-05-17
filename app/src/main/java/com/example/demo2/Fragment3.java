package com.example.demo2;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo2.bean.BwlBean;

public class Fragment3 extends Fragment {

    private EditText et_title, et_text;
    private Button btn_bwl;
    private RecyclerView rv;
    private DatabaseHelper db;
    private BaseRVAdapter<BwlBean> adapter;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment3, container, false);//关联布局文件

        initView(view);
        initData();

        return view;
    }

    private void initView(View view) {
        et_title = view.findViewById(R.id.et_title);
        et_text = view.findViewById(R.id.et_text);
        btn_bwl = view.findViewById(R.id.btn_bwl);
        rv = view.findViewById(R.id.rv);
        db = new DatabaseHelper(getActivity());

        adapter = new BaseRVAdapter<BwlBean>(R.layout.item_view2) {
            @Override
            public void onBindVH(BaseRVHolder holder, BwlBean data, int position) {
                holder.setText(R.id.name, data.getBwlTitle());
                holder.setText(R.id.opus, data.getBwlTitle());

                Button btn_del = holder.getView(R.id.btn_del);
                btn_del.setOnClickListener(view1 -> {
                    db.deleteBwl(db.bwlList().get(position).getId());
                    adapter.remove(position);
                });
            }
        };

        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(adapter);
        adapter.setNewData(db.bwlList());
    }

    private void initData() {
        btn_bwl.setOnClickListener(view -> {
            if (TextUtils.isEmpty(et_title.getText().toString().trim())) {
                Toast.makeText(getActivity(), "请输入备忘录标题", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(et_text.getText().toString().trim())) {
                Toast.makeText(getActivity(), "请输入备忘录内容", Toast.LENGTH_SHORT).show();
            } else {
                long val = db.addBwl(et_title.getText().toString().trim(), et_text.getText().toString().trim());
                if (val > 0) {
                    adapter.setNewData(db.bwlList());
                }
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        MainActivity.bt3.setTextColor(Color.rgb(0, 188, 212));
        MainActivity.bt1.setTextColor(Color.rgb(148, 148, 148));
        MainActivity.bt2.setTextColor(Color.rgb(148, 148, 148));
        MainActivity.bt4.setTextColor(Color.rgb(148, 148, 148));
    }
}