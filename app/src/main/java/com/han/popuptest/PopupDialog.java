package com.han.popuptest;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.han.popuptest.webview.DialogWebviewChromeClient;
import com.han.popuptest.webview.DialogWebviewClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PopupDialog extends Dialog {

    private Context mContext;
    @BindView(R.id.popup_webview1) WebView popWebview;
    @OnClick(R.id.exit_btn1) void exit_btn1 (){ this.dismiss(); }

    public PopupDialog(Context mContext) {
        super(mContext);
        this.mContext = mContext;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_dialog_layout);
        ButterKnife.bind(this);
        settingWebview();
        popWebview.loadUrl("https://lolchess.gg/cheatsheet");
    }

    public void settingWebview(){
        popWebview.setWebChromeClient(new DialogWebviewChromeClient());
        popWebview.setWebViewClient(new DialogWebviewClient());
        popWebview.addJavascriptInterface(new JavascriptController(),"CustomSchema");
        WebSettings settings =popWebview.getSettings();
        settings.setJavaScriptEnabled(true);
    }

    class JavascriptController {
        @JavascriptInterface
        public void javascriptController(){

        }
    }

}
