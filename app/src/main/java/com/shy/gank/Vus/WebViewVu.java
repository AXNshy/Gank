package com.shy.gank.Vus;

import android.app.Activity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.shy.gank.Model.Bean.GanHuo;
import com.shy.gank.R;



/**
 * Created by axnshy on 16/8/30.
 */
public class WebViewVu implements Vu {

    Toolbar toolbar;
    ImageView backIv;
    ImageView menuIv;
    TextView titleTx;
    WebView webview ;
    View view;
    WebViewClient client = new WebViewClient(){
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }



        @Override
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
        }
    };

    WebChromeClient chromeClient = new WebChromeClient(){
        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
        }
    };
    @Override
    public void init(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.webview, container, false);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        backIv= (ImageView) view.findViewById(R.id.iv_back);
        menuIv = (ImageView) view . findViewById(R.id.iv_menu);
        titleTx = (TextView) view.findViewById(R.id.tv_title);
        webview = (WebView) view.findViewById(R.id.webView);
        backIv.setImageResource(R.drawable.arrow_left);
        menuIv.setImageResource(R.drawable.menu);
        webview.setWebChromeClient(chromeClient);
        webview.setWebViewClient(client);
    }

    @Override
    public View getView() {
        return view;
    }


    public void load(GanHuo ganhuo){
        webview.loadUrl(ganhuo.getUrl());
    }

    public void setOnClickListener(final Activity activity){
        backIv .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.onBackPressed();
            }
        });
        menuIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopup();
            }
        });
    }

    private void showPopup() {
    }
}
