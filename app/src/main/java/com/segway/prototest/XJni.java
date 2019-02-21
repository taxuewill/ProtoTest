package com.segway.prototest;

import com.segway.prototest.entry.NestedEntry;
import com.segway.prototest.entry.Person;

/**
 * Created by will on 19-2-19.
 */

public class XJni {
    static{
        System.loadLibrary("xjni");
    }

    public static native String getStr();

    public static native int writeProto(byte[] protoData,int index);

    public static native int writePerson(Person person,int index);

    public static native Person readPerson(int index);
    public static native byte[] readProto(int index);

    public static native int writeNestedEntry(NestedEntry nestedEntry, int index);
    public static native int writeNestedProto(byte[] protoData,int index);

    public static native byte[] readNestedProto(int index);
    public static native NestedEntry readNestedEntry(int index);
}
