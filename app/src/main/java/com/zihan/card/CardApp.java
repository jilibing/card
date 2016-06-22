package com.zihan.card;

import android.app.Application;
import android.content.Context;

import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by jilibing on 2016/6/20/0020.
 */
public class CardApp extends Application {

    private static Context sAppContext;

    @Override
    public void onCreate() {
        super.onCreate();

        sAppContext = this;

        FlowManager.init(new FlowConfig.Builder(getApplicationContext()).build());
    }

    public static Context getsAppContext() {
        return sAppContext;
    }
}
