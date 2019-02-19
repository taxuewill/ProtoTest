package com.segway.prototest.util;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by will on 2018/4/22.
 */

public class TaskTimerUtil extends Timer {

    private static final String TAG = "TaskTimerUtil";
    private static volatile TaskTimerUtil mTimer;
    private static Map<String, TimerTask> mTaskMap = new HashMap<String, TimerTask>();

    private TaskTimerUtil() {
        super("TaskTimerUtil used thread");
    }

    public static TaskTimerUtil getInstance() {
        if (mTimer == null) {
            synchronized (TaskTimerUtil.class){
                if(mTimer == null){
                    mTimer = new TaskTimerUtil();
                }
            }

        }
        return mTimer;
    }

    public void startTimer(TimerTask task, String taskName, long millisec) {
        Log.i(TAG, "startTimer,taskName:" + taskName);
        TimerTask timerTask = mTaskMap.get(taskName);
        if (timerTask != null) {
            timerTask.cancel();
            mTaskMap.remove(taskName);
        }
        mTaskMap.put(taskName, task);
        try {
            mTimer.schedule(task, millisec);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    public void startTimer(TimerTask task, String taskName, int firstDelay, int millisecInterval) {
        Log.i(TAG, "startTimer,timer num" + mTaskMap.size());
        TimerTask timerTask = mTaskMap.get(taskName);
        if (timerTask != null) {
            timerTask.cancel();
            mTaskMap.remove(taskName);
        }
        mTaskMap.put(taskName, task);
        try {
            mTimer.schedule(task, firstDelay, millisecInterval);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    public void cancelTimer(String taskName) {
        Log.i(TAG, "cancelTimer,taskName:" + taskName);
        TimerTask timerTask = mTaskMap.get(taskName);
        if (timerTask != null) {
            timerTask.cancel();
            mTaskMap.remove(taskName);
        }
    }


}
