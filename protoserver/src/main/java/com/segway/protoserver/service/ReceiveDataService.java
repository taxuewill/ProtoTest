package com.segway.protoserver.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.protobuf.InvalidProtocolBufferException;
import com.segway.common.control.ISendData;
import com.segway.common.entry.Rom;
import com.segway.common.entry.Student;
import com.segway.prototest.entry.RomProto;
import com.segway.prototest.entry.StudentProto;

/**
 * Created by will on 19-2-21.
 */

public class ReceiveDataService extends Service {



    private static final String TAG = ReceiveDataService.class.getSimpleName();


    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG,"onCreate...");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy...");
    }



    private ISendData.Stub mBinder = new ISendData.Stub() {
        @Override
        public void sendStudent(Student student) throws RemoteException {
            Log.i(TAG,"sendStudent "+student.getName()+","+student.getId());
        }

        @Override
        public void sendStudentP(byte[] protoData)throws RemoteException {
            try {
                StudentProto.StudentP studentP = StudentProto.StudentP.parseFrom(protoData);
                Log.i(TAG,"sendStudentP "+studentP.getName()+","+studentP.getId());

            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void sendRom(Rom rom) throws RemoteException {
            Log.i(TAG,"sendRom "+rom.getStudent().getName());
        }

        @Override
        public void sendRomP(byte[] protoData) throws RemoteException {
            try {
                RomProto.RomP romP = RomProto.RomP.parseFrom(protoData);
                Log.i(TAG,"sendRomP "+ romP.getStudent().getName());
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
        }
    };






    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
}
