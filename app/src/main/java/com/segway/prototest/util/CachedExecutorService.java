package com.segway.prototest.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by will on 18-10-9.
 */

public class CachedExecutorService {

    private static final CachedExecutorService ourInstance = new CachedExecutorService();

    private ExecutorService mExecutorService;
    public static CachedExecutorService getInstance() {
        return ourInstance;
    }

    private CachedExecutorService() {
        mExecutorService = Executors.newCachedThreadPool();
    }

    public void execute(Runnable runnable){
        mExecutorService.execute(runnable);
    }

    public void shutdown(){
        mExecutorService.shutdown();
    }
}
