package com.wyson.practicewebview;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class WebAppInterface {
    Context mContext;

    public WebAppInterface(Context context) {
        mContext = context;
    }

    /**
     * targetSdkVersion >=17(4.2)以上必须增加注解
     */
    @JavascriptInterface
    public void showToast(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }
}
