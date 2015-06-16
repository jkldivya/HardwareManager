package com.example.divya.addition;

import android.app.IntentService;
import android.content.Intent;
import android.content.ServiceConnection;
import android.webkit.WebView;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class CloudService extends IntentService {
    public static WebView CloudInterface;
    public CloudService() {
        super("CloudService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
//            bindService(intent,JOB_SCHEDULER_SERVICE.);
        }
    }
}
