package com.segway.common.entry;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by will on 19-2-21.
 */

public class Student implements Parcelable{

    String name;
    int id;
    float valFloat;
    double valDouble;
    boolean valBoolean;
    long valLong;

    protected Student(Parcel in) {
        name = in.readString();
        id = in.readInt();
        valFloat = in.readFloat();
        valDouble = in.readDouble();
        valBoolean = in.readByte() != 0;
        valLong = in.readLong();
    }

    public Student(){}

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(id);
        dest.writeFloat(valFloat);
        dest.writeDouble(valDouble);
        dest.writeByte((byte) (valBoolean ? 1 : 0));
        dest.writeLong(valLong);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getValFloat() {
        return valFloat;
    }

    public void setValFloat(float valFloat) {
        this.valFloat = valFloat;
    }

    public double getValDouble() {
        return valDouble;
    }

    public void setValDouble(double valDouble) {
        this.valDouble = valDouble;
    }

    public boolean isValBoolean() {
        return valBoolean;
    }

    public void setValBoolean(boolean valBoolean) {
        this.valBoolean = valBoolean;
    }

    public long getValLong() {
        return valLong;
    }

    public void setValLong(long valLong) {
        this.valLong = valLong;
    }
}
