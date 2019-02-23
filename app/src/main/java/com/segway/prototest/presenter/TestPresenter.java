package com.segway.prototest.presenter;

import android.os.RemoteException;
import android.util.Log;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.segway.common.control.ISendData;
import com.segway.common.entry.Rom;
import com.segway.common.entry.Student;
import com.segway.prototest.ProtoApplication;
import com.segway.prototest.XJni;
import com.segway.prototest.entry.ComplexEntry;
import com.segway.prototest.entry.ComplexEntryProto;
import com.segway.prototest.entry.NestedEntry;
import com.segway.prototest.entry.NestedEntryProto;
import com.segway.prototest.entry.Person;
import com.segway.prototest.entry.PersonProto;
import com.segway.prototest.entry.ProtoTestInt;
import com.segway.prototest.entry.RomProto;
import com.segway.prototest.entry.SimpleIntEntry;
import com.segway.prototest.entry.StudentProto;
import com.segway.prototest.test.ITestCallback;
import com.segway.prototest.test.JacksonTest;
import com.segway.prototest.test.ObjectTest;
import com.segway.prototest.test.ProtoBufTest;
import com.segway.prototest.test.TestResult;
import com.segway.prototest.util.CachedExecutorService;
import com.segway.prototest.util.TestUtils;
import com.segway.prototest.view.IProtoContact;


import org.apache.lucene.util.RamUsageEstimator;

import java.io.IOException;

/**
 * Created by will on 19-2-18.
 */

public class TestPresenter implements IProtoContact.IProtoPresenter {

    private static final String TAG = TestPresenter.class.getSimpleName();

    private static final int TEST_TIMES = 90000;

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

//        String jniString = XJni.getStr();
//        Log.i(TAG,"jniString is "+jniString);
    }

    @Override
    public void readProto() {
        Log.i(TAG,"readProto");
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
        Log.i(TAG,"person1 size is "+RamUsageEstimator.shallowSizeOf(person1));
        Log.i(TAG,"nestedEntry1 size is "+RamUsageEstimator.shallowSizeOf(nestedEntry1));

        Student student = new Student();
        student.setName("Will");
        student.setId(1);
        student.setValBoolean(true);
        student.setValFloat(1.0f);
        student.setValDouble(1.0d);
        student.setValLong(1L);
        Rom rom = new Rom();
        rom.setStudent(student);
        rom.setId(1);
        rom.setName("Class1");
        rom.setValBoolean(true);
        rom.setValDouble(1d);
        rom.setValFloat(1f);
        rom.setValLong(1L);
        Log.i(TAG,"Student size is "+RamUsageEstimator.shallowSizeOf(student));
        Log.i(TAG,"Rom size is "+RamUsageEstimator.shallowSizeOf(rom));
    }

    @Override
    public void writeReadProto() {
        testInt();
        testComplex();
        testNested();
    }

    @Override
    public void nativeWriteProto() {
        CachedExecutorService.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                nativeWritePerson();
            }
        });
    }

    @Override
    public void nativeReadProto() {
        CachedExecutorService.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                nativeReadPerson();
            }
        });
    }

    @Override
    public void nativeWriteReadProto() {
        CachedExecutorService.getInstance().execute(new Runnable() {
            @Override
            public void run() {
//                nativeWritePerson();
//                nativeReadPerson();
                nativeWriteNested();
//                nativeReadNested();
            }
        });
    }

    @Override
    public void sendBindData(){
        CachedExecutorService.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                sendDataToServer();
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


    private void nativeWritePerson(){
        PersonProto.Person person = PersonProto.Person.newBuilder()
                .setName("Java")
                .setId(10)
                .setEmail("Hello,world!")
                .build();
        byte[] protoPerson = person.toByteArray();
        Log.i(TAG,"protoPerson length is "+protoPerson.length);
        long start = System.nanoTime();
        for(int i= 0; i< TEST_TIMES;i++){

            int index = XJni.writeProto(protoPerson,i);
            //Log.i(TAG,"nativeWriteProto index "+index);
        }
        long scope = System.nanoTime() - start;
        Log.i(TAG,"native WriteProto cost "+(scope/1000000d));
        Person person1 = new Person();
        person1.setName("Java");
        person1.setId(10);
        person1.setEmail("Hello,world!");

        start = System.nanoTime();
        for( int j = 0;j < TEST_TIMES;j++){

            int index = XJni.writePerson(person1,j);
            //Log.i(TAG,"j is "+j+",index is "+index);
        }
        scope = System.nanoTime() - start;
        Log.i(TAG,"native WriteObject cost "+(scope/1000000d));

    }

    private void nativeReadPerson(){



        long start = System.nanoTime();
        for(int i = 0; i< TEST_TIMES;i++){
            byte[] barray = XJni.readProto(i);
            try {
                PersonProto.Person person = PersonProto.Person.parseFrom(barray);
                //Log.i(TAG,"person name "+person.getName()+","+person.getEmail()+","+person.getId());
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
        }
        long scope = System.nanoTime() - start;
        Log.i(TAG,"native readProto cost:"+(scope/1000000d));

        start = System.nanoTime();

        for(int i = 0;i < TEST_TIMES;i++){
            Person person = XJni.readPerson(i);
            //Log.i(TAG,"person name is "+person.getName()+",id:"+person.getId());
        }
        scope = System.nanoTime() - start;
        Log.i(TAG,"native readObject cost:"+(scope/1000000d));


    }


    private void nativeWriteNested(){

        PersonProto.Person person = PersonProto.Person.newBuilder()
                .setName("Tome")
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


        long start = System.nanoTime();
        byte[] protoData = nestedEntry.toByteArray();
        Log.i(TAG,"protoData length "+protoData.length);
        for(int i = 0;i < TEST_TIMES; i++) {
            int index = XJni.writeNestedProto(protoData, 0);
        }
        long scope = System.nanoTime() - start;
        Log.i(TAG,"nativeWriteNestedProto cost "+(scope/1000000d));
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
        start = System.nanoTime();
        for(int i = 0; i< TEST_TIMES;i++){
            int index = XJni.writeNestedEntry(nestedEntry1,i);
        }
        scope = System.nanoTime() - start;
        Log.i(TAG,"nativeWriteNestedPerson cost: "+(scope/1000000d));

    }


    private void nativeReadNested(){
        long start = System.nanoTime();
        for(int i = 0; i< TEST_TIMES;i++){
            byte[] barray = XJni.readNestedProto(i);
            try {
                NestedEntryProto.NestedEntry nestedEntry = NestedEntryProto.NestedEntry.parseFrom(barray);
//                Log.i(TAG,"nestedEntry "+nestedEntry.getPerson().getName());
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
        }
        long scope = System.nanoTime() - start;
        Log.i(TAG,"nativeReadNestedProto cost "+(scope/1000000d));
        start = System.nanoTime();
        for(int i = 0;i<TEST_TIMES;i++){
            NestedEntry nestedEntry = XJni.readNestedEntry(0);
        }
        scope = System.nanoTime() - start;

        Log.i(TAG,"nativeReadNestedEntry cost "+(scope/1000000d));
    }


    private void sendDataToServer(){
        Student student = new Student();
        student.setName("Will");
        student.setId(1);
        student.setValBoolean(true);
        student.setValFloat(1.0f);
        student.setValDouble(1.0d);
        student.setValLong(1L);
        ISendData iSendData = ProtoApplication.getInstance().getBinder();
        long start = System.nanoTime();
//        for(int i = 0;i < TEST_TIMES;i++){
//            try {
//                student.setId(i);
//                iSendData.sendStudent(student);
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
//        }
//
        long scope = System.nanoTime() - start;
        Log.i(TAG,"Student binder cost:"+(scope/1000000d));
        StudentProto.StudentP studentP = StudentProto.StudentP.newBuilder()
                .setName("Will")
                .setId(1)
                .setValBool(true)
                .setValLong(1L)
                .setValFloat(1.0f)
                .setValDouble(1.0d)
                .build();
        Log.i(TAG,"protoStudent size "+studentP.toByteArray().length);
        start = System.nanoTime();
        for(int i = 0;i<TEST_TIMES;i++) {
            try {
                iSendData.sendStudentP(studentP.toByteArray());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        scope = System.nanoTime() -start;
        Log.i(TAG,"Student Proto cost:"+(scope/1000000d));

        Rom rom = new Rom();
        rom.setStudent(student);
        rom.setId(1);
        rom.setName("Class1");
        rom.setValBoolean(true);
        rom.setValDouble(1d);
        rom.setValFloat(1f);
        rom.setValLong(1L);
        start = System.nanoTime();
        for(int i = 0;i<TEST_TIMES;i++){
            try {
                rom.setId(i);
                iSendData.sendRom(rom);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        scope = System.nanoTime() -start;
        Log.i(TAG,"Rom binder cost "+(scope/1000000d));

        RomProto.RomP romP = RomProto.RomP.newBuilder()
                .setId(1)
                .setName("Class1")
                .setValBool(true)
                .setValDouble(1d)
                .setValFloat(1f)
                .setValLong(1l)
                .setStudent(studentP)
                .build();
        Log.i(TAG,"RomP lenght is "+romP.toByteArray().length);
        start = System.nanoTime();
        for(int i = 0;i<TEST_TIMES;i++){
            try {
                iSendData.sendRomP(romP.toByteArray());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        scope = System.nanoTime() - start;
        Log.i(TAG,"RomP Proto cost "+(scope/1000000d));


    }
}
