package com.lenovohit.administrator.aidldemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by SharkChao on 2017-07-22.
 * binder的类似线程池，用来选择开启那个binder
 *
 */

public class BinderPoolService extends Service{

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new BinderPoolImpl();
    }


}
