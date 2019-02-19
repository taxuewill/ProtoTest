package com.segway.prototest.view;

/**
 * Created by will on 19-2-18.
 */

public interface IProtoContact {

    interface IProtoPresenter{
        void writeProto();
        void readProto();
        void writeReadProto();
    }

    interface IProtoView{
        void showTime(long time);
    }
}
