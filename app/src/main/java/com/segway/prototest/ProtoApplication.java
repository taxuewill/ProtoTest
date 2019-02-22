package com.segway.prototest;

import android.app.Application;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

import com.segway.common.control.ISendData;
import com.segway.prototest.entry.ProtoTestInt;

/**
 * Created by will on 19-2-18.
 */

public class ProtoApplication extends Application {

    private static ProtoApplication mApplication;

    private static final String TAG = ProtoApplication.class.getSimpleName();

    private ISendData mBinder;

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
        Intent intent = new Intent();
        intent.setAction("com.segway.protoserver.SENDDATA");
        intent.setPackage("com.segway.protoserver");
        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.i(TAG,"onServiceConnected ...");
                mBinder = ISendData.Stub.asInterface(service);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.i(TAG,"onServiceDisconnected ...");
            }
        }, Service.BIND_AUTO_CREATE);
    }

    public ISendData getBinder(){
        return mBinder;
    }
}
