package com.example.myapplication;

import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Canal_1 extends AppCompatActivity {

    WebView wv;
    FrameLayout cvc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.canal_1);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("WebView");

        Toast.makeText(getApplicationContext(), "Un momento por favor...", Toast.LENGTH_LONG).show();
        cvc = (FrameLayout) findViewById(R.id.cvc);
        wv = (WebView) findViewById(R.id.wv);
        WebSettings settings = wv.getSettings(); settings.setTextZoom(90);
        wv = findViewById(R.id.wv);
        wv.loadUrl("https://www.instagram.com/technology.es");
        WebView myWebView = (WebView) findViewById(R.id.wv);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        wv=(WebView)findViewById(R.id.wv);
        wv.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url){view.loadUrl(url);
                return true;
            }

        });
    }

    @Override
    public void onBackPressed(){
        if(wv.canGoBack()){wv.goBack();}
        else{super.onBackPressed();}
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
