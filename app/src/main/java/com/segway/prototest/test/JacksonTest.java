package com.segway.prototest.test;

import android.util.Log;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by will on 19-2-18.
 */

public class JacksonTest implements ITestCallback {

    private static final String TAG = JacksonTest.class.getSimpleName();

    ObjectMapper mObjectMapper;
    Class mParaClass;

    public JacksonTest(ObjectMapper objectMapper,Class paraClass){
        mObjectMapper = objectMapper;
        mParaClass = paraClass;
    }





    @Override
    public String getName() {
        return "Jackson  ";
    }

    @Override
    public byte[] writeObject(Object source) {
        try {
            return mObjectMapper.writeValueAsBytes(source);
        } catch (JsonProcessingException e) {
            Log.e(TAG,e.toString());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Object readObject(byte[] bytes) {
        try {
            return mObjectMapper.readValue(bytes,mParaClass);
        } catch (IOException e) {
            Log.e(TAG,e.toString());
        }
        return null;
    }
}
