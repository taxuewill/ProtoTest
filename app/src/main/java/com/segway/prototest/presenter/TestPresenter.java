package com.segway.prototest.presenter;

import android.util.Log;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.InvalidProtocolBufferException;
import com.segway.prototest.entry.ComplexEntry;
import com.segway.prototest.entry.ComplexEntryProto;
import com.segway.prototest.entry.NestedEntry;
import com.segway.prototest.entry.NestedEntryProto;
import com.segway.prototest.entry.Person;
import com.segway.prototest.entry.PersonProto;
import com.segway.prototest.entry.ProtoTestInt;
import com.segway.prototest.entry.SimpleIntEntry;
import com.segway.prototest.test.ITestCallback;
import com.segway.prototest.test.JacksonTest;
import com.segway.prototest.test.ObjectTest;
import com.segway.prototest.test.ProtoBufTest;
import com.segway.prototest.test.TestResult;
import com.segway.prototest.util.CachedExecutorService;
import com.segway.prototest.util.TestUtils;
import com.segway.prototest.view.IProtoContact;

import junit.framework.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by will on 19-2-18.
 */

public class TestPresenter implements IProtoContact.IProtoPresenter {

    private static final String TAG = TestPresenter.class.getSimpleName();

    private IProtoContact.IProtoView mProtoView;
    final ObjectMapper objectMapper = new ObjectMapper();


    public TestPresenter(IProtoContact.IProtoView iProtoView) {
        mProtoView = iProtoView;
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
    }

    @Override
    public void writeProto() {
        SimpleIntEntry simpleIntEntry = new SimpleIntEntry();
        simpleIntEntry.setVal1(11);
        try {
            byte[] byteEntry = objectMapper.writeValueAsBytes(simpleIntEntry);
            Log.d(TAG, "byteEntry " + (byteEntry == null ? 0 : byteEntry.length));
            if (byteEntry != null) {
                SimpleIntEntry entry2 = objectMapper.readValue(byteEntry, SimpleIntEntry.class);
                Log.i(TAG, "entry2 is " + entry2.getVal1());
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readProto() {

    }

    @Override
    public void writeReadProto() {
        CachedExecutorService.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                testInt();
                testComplex();
                testNested();
            }
        });

    }


    private void printResult(TestResult testResult) {
        Log.i(TAG, testResult.getDesc() + "\t\tread:\t" + (testResult.getReadTime() / 1000000d) + " ms, \twrite:\t" + (testResult.getWriteTime() / 1000000d) + " ms\t" + "write size:\t" + (testResult.getWriteSize() / 1000) + "KB");
    }

    private void testInt() {
        Log.i(TAG, "testInt---");


        ProtoTestInt.IntEntry intEntry = ProtoTestInt.IntEntry.newBuilder()
                .setVal1(1)
                .build();
        TestResult time = TestUtils.testTemplate(new ProtoBufTest(), intEntry, 1000);
        printResult(time);


        SimpleIntEntry simpleIntEntry = new SimpleIntEntry();
        simpleIntEntry.setVal1(1);

        TestResult jacksonTest = TestUtils.testTemplate(new JacksonTest(objectMapper, SimpleIntEntry.class), simpleIntEntry, 1000);
        printResult(jacksonTest);


        TestResult simpleTest = TestUtils.testTemplate(new ObjectTest(), simpleIntEntry, 1000);
        printResult(simpleTest);

    }

    private void testComplex(){
        Log.i(TAG,"testComplex----");
        ComplexEntryProto.ComplexEntry complexEntryProto = ComplexEntryProto.ComplexEntry.newBuilder()
                .setStrObj("Hello")
                .setInt32Obj(1)
                .setInt64Obj(1L)
                .setFloatObj(1F)
                .setDoubleObj(1D)
                .setBoolObj(true)
                .setBytesObj(ByteString.copyFrom(new byte[]{1,2,3}))
                .build();
        TestResult protoTest = TestUtils.testTemplate(new ITestCallback() {
            @Override
            public String getName() {
                return "ProtoBuf";
            }

            @Override
            public byte[] writeObject(Object source) {
                if(source instanceof ComplexEntryProto.ComplexEntry){
                    ComplexEntryProto.ComplexEntry complexEntry = (ComplexEntryProto.ComplexEntry) source;
                    return complexEntry.toByteArray();
                }
                return null;
            }

            @Override
            public Object readObject(byte[] bytes) {
                try{
                    return ComplexEntryProto.ComplexEntry.parseFrom(bytes);
                }catch (InvalidProtocolBufferException e){
                    Log.e(TAG,e.toString());
                }

                return null;
            }
        },complexEntryProto,1000);
        printResult(protoTest);


        ComplexEntry complexEntry = new ComplexEntry();
        complexEntry.setStrObj("Hello");
        complexEntry.setInt32Obj(1);
        complexEntry.setInt64Obj(1L);
        complexEntry.setFloatObj(1F);
        complexEntry.setDoubleObj(1D);
        complexEntry.setBoolObj(true);
        complexEntry.setBytesObj(new byte[]{1,2,3});

        TestResult jacksonTest = TestUtils.testTemplate(new JacksonTest(objectMapper, ComplexEntry.class), complexEntry, 1000);
        printResult(jacksonTest);


        TestResult simpleTest = TestUtils.testTemplate(new ObjectTest(), complexEntry, 1000);
        printResult(simpleTest);
    }

    private void testNested(){
        Log.i(TAG,"testNested---");
        PersonProto.Person person = PersonProto.Person.newBuilder()
                .setName("Tom")
                .setId(1)
                .setEmail("email")
                .build();
        NestedEntryProto.NestedEntry nestedEntry = NestedEntryProto.NestedEntry.newBuilder()
                .setStrObj("Hello")
                .setInt32Obj(1)
                .setInt64Obj(1L)
                .setFloatObj(1F)
                .setDoubleObj(1D)
                .setBoolObj(true)
                .setBytesObj(ByteString.copyFrom(new byte[]{1,2,3}))
                .setPerson(person)
                .build();

        TestResult protoTest = TestUtils.testTemplate(new ITestCallback() {
            @Override
            public String getName() {
                return "ProtoBuf";
            }

            @Override
            public byte[] writeObject(Object source) {
                if(source instanceof NestedEntryProto.NestedEntry){
                    NestedEntryProto.NestedEntry nestedEntry = (NestedEntryProto.NestedEntry) source;
                    return nestedEntry.toByteArray();
                }
                return null;
            }

            @Override
            public Object readObject(byte[] bytes) {
                try{
                    return NestedEntryProto.NestedEntry.parseFrom(bytes);
                }catch (InvalidProtocolBufferException e){
                    Log.e(TAG,e.toString());
                }

                return null;
            }
        },nestedEntry,1000);
        printResult(protoTest);

        NestedEntry nestedEntry1 = new NestedEntry();
        Person person1 = new Person();
        person1.setName("Tome");
        person1.setId(1);
        person1.setEmail("email");
        nestedEntry1.setStrObj("Hello");
        nestedEntry1.setInt32Obj(1);
        nestedEntry1.setInt64Obj(1L);
        nestedEntry1.setFloatObj(1F);
        nestedEntry1.setDoubleObj(1D);
        nestedEntry1.setBoolObj(true);
        nestedEntry1.setBytesObj(new byte[]{1,2,3});
        nestedEntry1.setPerson(person1);

        TestResult jacksonTest = TestUtils.testTemplate(new JacksonTest(objectMapper,NestedEntry.class),nestedEntry1,1000);
        printResult(jacksonTest);

        TestResult serializeTest = TestUtils.testTemplate(new ObjectTest(),nestedEntry1,1000);
        printResult(serializeTest);

    }
}
