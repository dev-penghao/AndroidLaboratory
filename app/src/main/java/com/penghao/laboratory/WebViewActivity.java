package com.penghao.laboratory;

import android.app.*;
import android.os.*;
import android.view.*;
import android.webkit.*;
import android.widget.*;
import android.graphics.*;

public class WebViewActivity extends Activity {
	
	WebView webView;
	WebSettings webSettings;
	ProgressBar progressBar;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_activity);
		
		webView=(WebView) findViewById(R.id.mainWebView);
		progressBar=(ProgressBar) findViewById(R.id.mainProgressBar);
		webSettings=webView.getSettings();
		webView.setWebViewClient(mWebViewClient);
		webView.setWebChromeClient(mChromeClient);
		//支持屏幕缩放
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
		webSettings.setJavaScriptEnabled(true);// 允许使用JS
		webView.loadUrl("https://baidu.com");
    }
	
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) { 
			webView.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
	
	WebViewClient mWebViewClient=new WebViewClient(){

		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon)
		{
			progressBar.setVisibility(View.VISIBLE);
			super.onPageStarted(view, url, favicon);
		}

		@Override
		public void onPageFinished(WebView view, String url)
		{
			progressBar.setVisibility(View.GONE);
			super.onPageFinished(view, url);
		}

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url)
		{
			view.loadUrl(url);
			return super.shouldOverrideUrlLoading(view, url);
		}
	};
	
	WebChromeClient mChromeClient=new WebChromeClient(){

		@Override
		public void onProgressChanged(WebView view, int newProgress)
		{
			progressBar.setProgress(newProgress);
			super.onProgressChanged(view, newProgress);
		}

		@Override
		public void onReceivedTitle(WebView view, String title)
		{
			setTitle(title);
			super.onReceivedTitle(view, title);
		}
	};
}
