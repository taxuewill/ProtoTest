package com.segway.prototest.view;

/**
 * Created by will on 19-2-18.
 */

public interface IProtoContact {

    interface IProtoPresenter{
        void writeProto();
        void readProto();
        void writeReadProto();

        //below is native test
        void nativeWriteProto();
        void nativeReadProto();
        void nativeWriteReadProto();
    }

    interface IProtoView{
        void showTime(long time);
    }
}
