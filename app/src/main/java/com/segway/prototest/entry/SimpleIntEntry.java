package com.segway.prototest.entry;

import java.io.Serializable;

/**
 * Created by will on 19-2-18.
 */

public class SimpleIntEntry  implements Serializable {

    private static final long serialVersionUID = 1L;

    int val1;

    public int getVal1() {
        return val1;
    }

    public void setVal1(int val1) {
        this.val1 = val1;
    }
}
