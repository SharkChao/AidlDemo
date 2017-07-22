package com.lenovohit.administrator.aidldemo.service;

import android.os.RemoteException;

import com.lenovohit.administrator.aidldemo.IAnQuanCenter;

/**
 * Created by SharkChao on 2017-07-22.
 */

public class AnQuanCenterImpl extends IAnQuanCenter.Stub{

    @Override
    public String encrypt(String content) throws RemoteException {

        return "这是加密之后的文本";
    }

    @Override
    public String decrypt(String content) throws RemoteException {
        return "这是解密之后的文本";
    }
}
