package com.segway.prototest.entry;

import java.io.Serializable;

/**
 * Created by will on 19-2-19.
 */

public class NestedEntry implements Serializable {

    private static final long serialVersionUID = 1L;

    String strObj;
    int int32Obj;
    long int64Obj;
    float floatObj;
    double doubleObj;
    boolean   boolObj;
    byte[]  bytesObj;
    Person person;

    public String getStrObj() {
        return strObj;
    }

    public void setStrObj(String strObj) {
        this.strObj = strObj;
    }

    public int getInt32Obj() {
        return int32Obj;
    }

    public void setInt32Obj(int int32Obj) {
        this.int32Obj = int32Obj;
    }

    public long getInt64Obj() {
        return int64Obj;
    }

    public void setInt64Obj(long int64Obj) {
        this.int64Obj = int64Obj;
    }

    public float getFloatObj() {
        return floatObj;
    }

    public void setFloatObj(float floatObj) {
        this.floatObj = floatObj;
    }

    public double getDoubleObj() {
        return doubleObj;
    }

    public void setDoubleObj(double doubleObj) {
        this.doubleObj = doubleObj;
    }

    public boolean isBoolObj() {
        return boolObj;
    }

    public void setBoolObj(boolean boolObj) {
        this.boolObj = boolObj;
    }

    public byte[] getBytesObj() {
        return bytesObj;
    }

    public void setBytesObj(byte[] bytesObj) {
        this.bytesObj = bytesObj;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
