package com.hotsmall.belle.client;


import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by liqy on 16/1/16.
 */
public class BelleClient {

    private static RequestQueue requestQueue;

    public BelleClient() {
    }

    public static void init(Context context) {
        requestQueue = Volley.newRequestQueue(context);
    }

    public static RequestQueue getRequestQueue() {
        if (requestQueue != null) {
            return requestQueue;
        } else {
            throw new IllegalStateException("RequestQueue not initialized");
        }
    }
}
