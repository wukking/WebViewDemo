package com.wyson.practicewebview.webview;

import android.os.Build;
import android.util.Log;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.wyson.practicewebview.R;

public class MyRendererTrackingWebViewClient extends WebViewClient {
    private WebView mWebView;

    @Override
    public boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if (!detail.didCrash()){
                //由于内存泄漏，渲染器被杀掉
                //可以创建一个新的来恢复
                Log.e("MY_APP_TAG", "System killed the WebView rendering process " +
                        "to reclaim memory. Recreating...");

                if (mWebView != null) {
//                    ViewGroup webViewContainer =
//                            (ViewGroup) findViewById(R.id.my_web_view_container);
//                    webViewContainer.removeView(mWebView);
//                    mWebView.destroy();
//                    mWebView = null;
                }
                // The app continues executing.
                return true;
            }
            Log.e("MY_APP_TAG", "The WebView rendering process crashed!");
            // In this example, the app itself crashes after detecting that the
            // renderer crashed. If you choose to handle the crash more gracefully
            // and allow your app to continue executing, you should 1) destroy the
            // current WebView instance, 2) specify logic for how the app can
            // continue executing, and 3) return "true" instead.
            return false;
        }

        return super.onRenderProcessGone(view, detail);
    }
}
