package com.segway.prototest;

import android.app.Application;

/**
 * Created by will on 19-2-18.
 */

public class ProtoApplication extends Application {

    private static ProtoApplication mApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        init();
    }

    public static ProtoApplication getInstance(){
        return mApplication;
    }

    private void init(){

    }
}
