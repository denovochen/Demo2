package com.example.demo2;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {
    private WebView webView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, container, false);//关联布局文件

        webView = (WebView) view.findViewById(R.id.webview);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        webView.loadUrl("https://cn.bing.com/");
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        MainActivity.bt2.setTextColor(Color.rgb(0, 188, 212));
        MainActivity.bt1.setTextColor(Color.rgb(148, 148, 148));
        MainActivity.bt3.setTextColor(Color.rgb(148, 148, 148));
        MainActivity.bt4.setTextColor(Color.rgb(148, 148, 148));
    }
}
