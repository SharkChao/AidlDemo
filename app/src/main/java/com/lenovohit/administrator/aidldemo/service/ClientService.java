package com.lenovohit.administrator.aidldemo.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.lenovohit.administrator.aidldemo.BookManager;
import com.lenovohit.administrator.aidldemo.INewBookArrivedListener;
import com.lenovohit.administrator.aidldemo.entity.Book;

import java.util.List;

/**
 * Created by SharkChao on 2017-07-20.
 */

public class ClientService extends Service{
    private BookManager mManager;
    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, final IBinder service) {
            mManager = BookManager.Stub.asInterface(service);
            try {
                List<Book> bookList = mManager.getBookList();
                Log.e("tag",bookList.size()+"....");
                Book book=new Book();
                book.setName("明朝那些年");
                mManager.addBook(book);


                mManager.RegistenerListener(new INewBookArrivedListener.Stub() {
                    @Override
                    public void OnNewBookArrived(Book book) throws RemoteException {
                        Log.e("tag",book.getName());
                    }
                });
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        Intent intent=new Intent(this,BookManagerService.class);
        bindService(intent,mConnection, Context.BIND_AUTO_CREATE);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
