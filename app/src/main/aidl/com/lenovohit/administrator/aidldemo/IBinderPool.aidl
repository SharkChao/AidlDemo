// IBinderPool.aidl
package com.lenovohit.administrator.aidldemo;

// Declare any non-default types here with import statements
//binder连接池，用于查询binder

interface IBinderPool {
    IBinder queryBinder(int code);
}
