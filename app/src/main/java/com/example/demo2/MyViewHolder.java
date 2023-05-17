package com.example.demo2;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView nameView, opusView;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageview);
        nameView = itemView.findViewById(R.id.name);
        opusView = itemView.findViewById(R.id.opus);
        itemView.setOnClickListener(v -> {
            switch (getAdapterPosition()) {
                case 0:
                    Toast.makeText(v.getContext(), "当前点击的是---宋岳庭", Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(v.getContext(), SYT.class);
                    v.getContext().startActivity(intent1);
                    break;
                case 1:
                    Toast.makeText(v.getContext(), "当前点击的是---JUSTHIS", Toast.LENGTH_SHORT).show();
                    Intent intent2 = new Intent(v.getContext(), JUSTHIS.class);
                    v.getContext().startActivity(intent2);
                    break;
                case 2:
                    Toast.makeText(v.getContext(), "当前点击的是---Kanye West", Toast.LENGTH_SHORT).show();
                    break;
                case 3:
                    Toast.makeText(v.getContext(), "当前点击的是---Mercy", Toast.LENGTH_SHORT).show();
                    break;
                case 4:
                    Toast.makeText(v.getContext(), "当前点击的是---MF DOOM", Toast.LENGTH_SHORT).show();
                    break;
                case 5:
                    Toast.makeText(v.getContext(), "当前点击的是---Travis Scott", Toast.LENGTH_SHORT).show();
                    break;
                case 6:
                    Toast.makeText(v.getContext(), "当前点击的是---Eminem", Toast.LENGTH_SHORT).show();
                    break;
                case 7:
                    Toast.makeText(v.getContext(), "当前点击的是---Nafla", Toast.LENGTH_SHORT).show();
                case 8:
                    Toast.makeText(v.getContext(), "当前点击的是---Kid Milli", Toast.LENGTH_SHORT).show();
                    break;
                case 9:
                    Toast.makeText(v.getContext(), "当前点击的是---Jvcki Wai", Toast.LENGTH_SHORT).show();
                    break;
                case 10:
                    Toast.makeText(v.getContext(), "当前点击的是---Dok2", Toast.LENGTH_SHORT).show();
                case 11:
                    Toast.makeText(v.getContext(), "当前点击的是---Koonta", Toast.LENGTH_SHORT).show();
                case 12:
                    Toast.makeText(v.getContext(), "当前点击的是---D.Ark", Toast.LENGTH_SHORT).show();
                    break;
                case 13:
                    Toast.makeText(v.getContext(), "当前点击的是---Kendick Lanar", Toast.LENGTH_SHORT).show();
                    break;
            }
        });
    }
}
