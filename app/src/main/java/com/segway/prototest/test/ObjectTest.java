package com.segway.prototest.test;

import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by will on 19-2-18.
 */

public class ObjectTest implements ITestCallback {
    private static final String TAG = ObjectTest.class.getSimpleName();

    @Override
    public String getName() {
        return "Serializable";
    }

    @Override
    public byte[] writeObject(Object source) {
        try {
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            ObjectOutputStream output = new ObjectOutputStream(bout);
            output.writeObject(source);
            return bout.toByteArray();
        } catch (IOException e) {
            Log.e(TAG,e.toString());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Object readObject(byte[] bytes) {
        try {
            ByteArrayInputStream bin = new ByteArrayInputStream(bytes);
            ObjectInputStream input = new ObjectInputStream(bin);
            return input.readObject();
        } catch (Exception e) {
            Log.e(TAG,e.toString());
            e.printStackTrace();
        }
        return null;
    }
}
