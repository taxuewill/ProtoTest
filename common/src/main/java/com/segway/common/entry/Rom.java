package com.segway.common.entry;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by will on 19-2-21.
 */

public class Rom implements Parcelable{

    String name;
    int id;
    float valFloat;
    double valDouble;
    boolean valBoolean;
    long valLong;
    Student student;



    protected Rom(Parcel in) {
        name = in.readString();
        id = in.readInt();
        valFloat = in.readFloat();
        valDouble = in.readDouble();
        valBoolean = in.readByte() != 0;
        valLong = in.readLong();
        student = in.readParcelable(Student.class.getClassLoader());
    }

    public Rom(){}

    public static final Creator<Rom> CREATOR = new Creator<Rom>() {
        @Override
        public Rom createFromParcel(Parcel in) {
            return new Rom(in);
        }

        @Override
        public Rom[] newArray(int size) {
            return new Rom[size];
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
        dest.writeParcelable(student, flags);
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
