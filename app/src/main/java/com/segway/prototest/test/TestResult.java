package com.segway.prototest.test;

/**
 * Created by will on 19-2-18.
 */

public class TestResult {

    long readTime;

    long writeTime;

    long writeSize;

    private String desc;

    public long getReadTime() {
        return readTime;
    }

    public void setReadTime(long readTime) {
        this.readTime = readTime;
    }

    public long getWriteTime() {
        return writeTime;
    }

    public void setWriteTime(long writeTime) {
        this.writeTime = writeTime;
    }

    public long getWriteSize() {
        return writeSize;
    }

    public void setWriteSize(long writeSize) {
        this.writeSize = writeSize;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
