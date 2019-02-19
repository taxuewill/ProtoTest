package com.segway.prototest.test;

/**
 * Created by will on 19-2-18.
 */

public interface ITestCallback {

    String getName();

    byte[] writeObject(Object source);

    Object readObject(byte[] bytes);
}
