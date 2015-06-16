package com.example.divya.addition;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import com.example.divya.addition.MainActivity;
/**
 * Created by Divya on 11-06-2015.
 */
public class WebAppInterface {

        Context mContext;

        /** Instantiate the interface and set the context */
        WebAppInterface(Context c) {
            mContext = c;
        }

        /** Show a toast from the web page */
        @JavascriptInterface
        public void showToast(String toast) {
            Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
        }
        @JavascriptInterface
        public void init(String toast){
            showToast(toast);

        }

}
