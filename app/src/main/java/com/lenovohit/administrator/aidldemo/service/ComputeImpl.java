package com.lenovohit.administrator.aidldemo.service;

import android.os.RemoteException;

import com.lenovohit.administrator.aidldemo.ICompute;

/**
 * Created by SharkChao on 2017-07-22.
 */

public class ComputeImpl extends ICompute.Stub{
    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }
}
