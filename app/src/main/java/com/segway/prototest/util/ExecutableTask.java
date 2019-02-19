package com.segway.prototest.util;

import java.util.TimerTask;

/**
 * Created by will on 18-6-6.
 */

public abstract class ExecutableTask extends TimerTask {

    public String TAG = this.getClass().getSimpleName();
    boolean canceled;

    @Override
    public boolean cancel() {
        canceled = true;
        return super.cancel();
    }

    @Override
    public void run() {
        if (canceled) {
            return;
        }
        execute();
    }

    public abstract void execute();
}
