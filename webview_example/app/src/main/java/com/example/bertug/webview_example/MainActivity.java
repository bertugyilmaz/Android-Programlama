package com.example.bertug.webview_example;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends Activity {

    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        webview=(WebView)findViewById(R.id.webview);

        webview.getSettings().setJavaScriptEnabled(true);

        webview.loadUrl("http://www.bertugyilmaz.com");

        final ProgressDialog progressDialog =  ProgressDialog.show(this,"Blog Sayfam", "Yükleniyor",true);
        progressDialog.show();

        webview.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url){
                super.onPageFinished(view,url);
                Toast.makeText(MainActivity.this, "Sayfaya Yükleniyor..",Toast.LENGTH_SHORT).show();;
                progressDialog.dismiss();
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                Toast.makeText(MainActivity.this,"Bir Hata Oluştu...", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
    }
}
