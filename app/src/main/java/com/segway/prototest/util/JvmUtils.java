package com.segway.prototest.util;

/**
 * Created by will on 19-2-18.
 */

public class JvmUtils {

    public static void restoreJvm(){
        System.runFinalization();
        System.gc();
    }
}
