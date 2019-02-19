package com.segway.prototest.test;

import android.util.Log;

import com.google.protobuf.InvalidProtocolBufferException;
import com.segway.prototest.entry.ProtoTestInt;
import com.segway.prototest.entry.ProtoTestString;

/**
 * Created by will on 19-2-18.
 */

public class ProtoBufTest implements ITestCallback {

    private static final String TAG = ProtoBufTest.class.getSimpleName();


    @Override
    public String getName() {
        return "ProtoBuf";
    }

    @Override
    public byte[] writeObject(Object source) {
        if(source instanceof ProtoTestInt.IntEntry){
            ProtoTestInt.IntEntry intEntry = (ProtoTestInt.IntEntry) source;
            return intEntry.toByteArray();
        }
        return null;
    }

    @Override
    public Object readObject(byte[] bytes) {
        try{
            return ProtoTestInt.IntEntry.parseFrom(bytes);
        }catch (InvalidProtocolBufferException e){
            Log.e(TAG,e.toString());
        }

        return null;
    }
}
