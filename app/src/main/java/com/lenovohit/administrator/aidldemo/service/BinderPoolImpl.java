package com.lenovohit.administrator.aidldemo.service;

import android.os.IBinder;
import android.os.RemoteException;

import com.lenovohit.administrator.aidldemo.IBinderPool;

/**
 * Created by SharkChao on 2017-07-22.
 * binder池的实现类
 */

public class BinderPoolImpl extends IBinderPool.Stub {

    public static final int ANQUAN = 1;
    public static final int ADD = 2;

    @Override
    public IBinder queryBinder(int code) throws RemoteException {
        IBinder binder = null;
        switch (code){
            case ANQUAN:
                binder = new AnQuanCenterImpl();
                break;
            case ADD:
                binder = new ComputeImpl();
        }
        return binder;
    }
}
