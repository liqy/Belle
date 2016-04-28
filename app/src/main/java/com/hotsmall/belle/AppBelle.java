package com.hotsmall.belle;

import android.app.Application;

import com.hotsmall.belle.client.BelleClient;
import com.orhanobut.logger.Logger;


/**
 * Created by liqy on 16/1/16.
 */
public class AppBelle extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        BelleClient.init(this);
        Logger.init("Belle")
                .hideThreadInfo()
                .methodOffset(3);
    }


}
