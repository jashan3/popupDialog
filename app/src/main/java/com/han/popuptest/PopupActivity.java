package com.han.popuptest;

import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.han.popuptest.webview.DialogWebviewChromeClient;
import com.han.popuptest.webview.DialogWebviewClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PopupActivity extends AppCompatActivity {
    @OnClick(R.id.exit_btn2)
    void exitBtn(){
        finishAfterTransition();
    }

    @BindView(R.id.popup_webview2) WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);
        ButterKnife.bind(this);
        settingWebview();
        webView.loadUrl("https://lolchess.gg/cheatsheet");
    }
    public void settingWebview(){
        webView.setWebChromeClient(new DialogWebviewChromeClient());
        webView.setWebViewClient(new DialogWebviewClient());
        webView.addJavascriptInterface(new JavascriptController(),"CustomSchema");
        WebSettings settings =webView.getSettings();
        settings.setJavaScriptEnabled(true);
    }

    class JavascriptController {
        @JavascriptInterface
        public void javascriptController(){

        }
    }
}
