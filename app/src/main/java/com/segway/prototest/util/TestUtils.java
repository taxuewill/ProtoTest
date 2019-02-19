package com.segway.prototest.util;

import android.util.Log;

import com.google.protobuf.InvalidProtocolBufferException;
import com.segway.prototest.entry.ProtoTestInt;
import com.segway.prototest.entry.ProtoTestInts;
import com.segway.prototest.entry.ProtoTestString;
import com.segway.prototest.entry.SimpleIntEntry;
import com.segway.prototest.test.ITestCallback;
import com.segway.prototest.test.TestResult;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by will on 19-2-18.
 */

public class TestUtils {

    private static final String TAG = TestUtils.class.getSimpleName();

    private static final int WARMUP_TIME = 2;
    private static final int TEST_TIME = 1000;


    public static TestResult testTemplate(ITestCallback iTestCallback, Object source, int count){
        TestResult testResult = new TestResult();
        testResult.setDesc(iTestCallback.getName());
        long totalTime;
        for(int i = 0; i < WARMUP_TIME; i++){
            byte[] bytes = iTestCallback.writeObject(source);
            if(bytes == null){
                Log.i(TAG,"bytes is null");
            }
            iTestCallback.readObject(bytes);
        }
        JvmUtils.restoreJvm();

        long size = 0l;

        long start = System.nanoTime();
        for(int i= 0 ;i < count;i++){
            byte[] bytes = iTestCallback.writeObject(source);
            if(bytes == null){
                Log.e(TAG,"bytes is null "+i);
            }else {
                size += bytes.length;
            }
        }
        totalTime = System.nanoTime() - start;
        testResult.setWriteSize(size);
        testResult.setWriteTime(totalTime);
        byte [] bytes = iTestCallback.writeObject(source);
        start = System.nanoTime();
        for(int i= 0 ;i < count;i++){
            Object object = iTestCallback.readObject(bytes);
        }
        totalTime = System.nanoTime() - start;
        testResult.setReadTime(totalTime);
        JvmUtils.restoreJvm();


        return testResult;
    }

    public static TestResult testProtoIntsTemplate(){
        TestResult testResult = new TestResult();
        testResult.setDesc("testProtoInts");
        ProtoTestInts.IntsEntry entry = ProtoTestInts.IntsEntry.newBuilder()
                .setVal1(1)
                .setVal2(1)
                .setVal3(1)
                .setVal4(1)
                .setVal5(1)
                .setVal6(1)
                .setVal7(1)
                .setVal8(1)
                .setVal9(1)
                .setVal10(1)
                .build();

        long totalTime;
        for(int i = 0; i < WARMUP_TIME; i++){
            byte[] bytes = entry.toByteArray();
            if(bytes == null){
                Log.i(TAG,"bytes is null");
            }
            try {
                ProtoTestInt.IntEntry.parseFrom(bytes);
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
        }
        JvmUtils.restoreJvm();

        long size = 0l;

        long start = System.nanoTime();
        for(int i= 0 ;i < TEST_TIME;i++){
            byte[] bytes = entry.toByteArray();
            size += bytes.length;
        }
        totalTime = System.nanoTime() - start;
        testResult.setWriteSize(size);
        testResult.setWriteTime(totalTime);
        byte [] parseBytes = entry.toByteArray();
        start = System.nanoTime();
        for(int i= 0 ;i < TEST_TIME;i++){
            try {
                ProtoTestInt.IntEntry.parseFrom(parseBytes);
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
        }
        totalTime = System.nanoTime() - start;
        testResult.setReadTime(totalTime);
        JvmUtils.restoreJvm();


        return testResult;
    }

    public static TestResult testProtoStringTemplate(){
        TestResult testResult = new TestResult();
        testResult.setDesc("testProtoString");
        ProtoTestString.StringEntry entry = ProtoTestString.StringEntry.newBuilder()
                .setVal1("abcdefghijklmnopqrstuvwxyz")
                .build();

        long totalTime;
        for(int i = 0; i < WARMUP_TIME; i++){
            byte[] bytes = entry.toByteArray();
            if(bytes == null){
                Log.i(TAG,"bytes is null");
            }
            try {
                ProtoTestString.StringEntry.parseFrom(bytes);
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
        }
        JvmUtils.restoreJvm();

        long size = 0l;

        long start = System.nanoTime();
        for(int i= 0 ;i < TEST_TIME;i++){
            byte[] bytes = entry.toByteArray();
            size += bytes.length;
        }
        totalTime = System.nanoTime() - start;
        testResult.setWriteSize(size);
        testResult.setWriteTime(totalTime);
        byte [] parseBytes = entry.toByteArray();
        start = System.nanoTime();
        for(int i= 0 ;i < TEST_TIME;i++){
            try {
                ProtoTestString.StringEntry.parseFrom(parseBytes);
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
        }
        totalTime = System.nanoTime() - start;
        testResult.setReadTime(totalTime);
        JvmUtils.restoreJvm();


        return testResult;
    }

    public static TestResult testSimpleIntEntry(){
        TestResult testResult = new TestResult();
        testResult.setDesc("testSimpleIntEntry");
        SimpleIntEntry simpleIntEntry = new SimpleIntEntry();
        simpleIntEntry.setVal1(1);
        long totalTime;
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new ByteArrayOutputStream());

            JvmUtils.restoreJvm();

            long size = 0l;

            long start = System.nanoTime();
            for(int i= 0 ;i < TEST_TIME;i++){
                outputStream.writeObject(simpleIntEntry);
            }
            outputStream.flush();
            totalTime = System.nanoTime() - start;
            testResult.setWriteSize(size);
            testResult.setWriteTime(totalTime);
            outputStream.close();
//
//            byte [] parseBytes = entry.toByteArray();
//            start = System.nanoTime();
//            for(int i= 0 ;i < TEST_TIME;i++){
//                try {
//                    ProtoTestString.StringEntry.parseFrom(parseBytes);
//                } catch (InvalidProtocolBufferException e) {
//                    e.printStackTrace();
//                }
//            }
//            totalTime = System.nanoTime() - start;
//            testResult.setReadTime(totalTime);
            JvmUtils.restoreJvm();
        } catch (IOException e) {
            e.printStackTrace();
        }



        return testResult;
    }
}
