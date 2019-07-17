package com.mosesokeny.alc.alc4phase1;

import android.net.http.SslError;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Bitmap;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class WebActivity extends AppCompatActivity {

    WebView myWebView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("About ALC");

        myWebView = (WebView) findViewById(R.id.my_web_view);




        myWebView.loadUrl("https://andela.com/alc/ ");
        myWebView.getSettings().setJavaScriptEnabled(true);

        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }
        });

        myWebView.setWebChromeClient(new WebChromeClient(){
        });
    }

    @Override
    public void onBackPressed() {
        if(myWebView.canGoBack()){
            myWebView.goBack();
        }

        else {
            finish();
        }
    }
}
