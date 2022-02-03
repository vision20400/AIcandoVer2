package com.sandburg.aicandover2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class pdf extends AppCompatActivity {

    WebView mWebView;
    WebSettings mWebSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        Intent intent = getIntent();//이전 액티비티로부터 넘겨진 인텐트 = 현재 Activity인스턴스를 시작한 인텐트 반환
        String getData = intent.getStringExtra("key");

        mWebView = (WebView) findViewById(R.id.pdf_webview);
        mWebView.setWebViewClient(new WebViewClient()); // 클릭시 새창 안뜨게

        mWebSettings = mWebView.getSettings(); //세부 세팅 등록

        mWebSettings.setJavaScriptEnabled(true); // 웹페이지 자바스클비트 허용 여부

        mWebSettings.setSupportMultipleWindows(false); // 새창 띄우기 허용 여부

        mWebSettings.setJavaScriptCanOpenWindowsAutomatically(false); // 자바스크립트 새창 띄우기(멀티뷰) 허용 여부

        mWebSettings.setLoadWithOverviewMode(true); // 메타태그 허용 여부

        mWebSettings.setUseWideViewPort(true); // 화면 사이즈 맞추기 허용 여부

        mWebSettings.setSupportZoom(false); // 화면 줌 허용 여부

        mWebSettings.setBuiltInZoomControls(false); // 화면 확대 축소 허용 여부

        mWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN); // 컨텐츠 사이즈 맞추기

        mWebSettings.setCacheMode(WebSettings.LOAD_NO_CACHE); // 브라우저 캐시 허용 여부

        mWebSettings.setDomStorageEnabled(true); // 로컬저장소 허용 여부
        mWebView.loadUrl(getData);

    }
}