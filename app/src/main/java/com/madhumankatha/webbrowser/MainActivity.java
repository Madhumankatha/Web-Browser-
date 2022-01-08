package com.madhumankatha.webbrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Components declared in ui -> activity_main.xml
    private EditText edUrl;
    private Button btnGo,btnBack;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //UI Bind with Java objects
        edUrl = findViewById(R.id.edUrl);
        btnGo = findViewById(R.id.btnGo);
        btnBack = findViewById(R.id.btnBack);
        webView = findViewById(R.id.webView);

        btnGo.setOnClickListener(v -> {
            String url = edUrl.getText().toString();
            if (url.isEmpty()){
                Toast.makeText(MainActivity.this, "Please Enter a url!! ", Toast.LENGTH_SHORT).show();
            }else{
               webView.getSettings().setLoadsImagesAutomatically(true);
               webView.getSettings().setJavaScriptEnabled(true);
               webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
               webView.setWebViewClient(new MyWeb());
               webView.loadUrl(url);
            }
        });

        btnBack.setOnClickListener(v -> {
            if (webView.canGoBack()){
                webView.goBack();
            }
        });

    }

    private class MyWeb extends WebViewClient{

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

}