package com.caraesten.webviewallocationtest;

import android.webkit.JavascriptInterface;

public class WebviewInterface {
    private WebviewListener listener;
    public WebviewInterface(WebviewListener listener) {
        this.listener = listener;
    }

    @JavascriptInterface
    public void sendString(String string) {
        listener.onStringReceived(string);
    }

    public interface WebviewListener {
        void onStringReceived(String str);
    }
}
