package com.lenovohit.administrator.aidldemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.lenovohit.administrator.aidldemo.BookManager;
import com.lenovohit.administrator.aidldemo.INewBookArrivedListener;
import com.lenovohit.administrator.aidldemo.entity.Book;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by SharkChao on 2017-07-20.
 */

public class BookManagerService extends Service {
    private CopyOnWriteArrayList<Book> list= new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<INewBookArrivedListener>arrivedList=new CopyOnWriteArrayList<>();
    private AtomicBoolean isServiceDestory = new AtomicBoolean(false);
    @Override
    public void onCreate() {
        super.onCreate();
        Book book1=new Book();
        book1.setName("上下五千年");
        book1.setValue("100");
        Book book2 = new Book();
        book2.setName("史记");
        book2.setValue("80");
        list.add(book1);
        list.add(book2);
        new Thread(new ServiceWorder()).start();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBookManager();
    }
    class MyBookManager extends BookManager.Stub {

        @Override
        public List<Book> getBookList() throws RemoteException {
            return list;
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            list.add(book);
            Log.e("tag","添加书成功"+","+book.getName());
        }

        @Override
        public void RegistenerListener(INewBookArrivedListener listener) throws RemoteException {
            if (!arrivedList.contains(listener)){
                arrivedList.add(listener);
            }
        }

        @Override
        public void UnRegistenerListener(INewBookArrivedListener listener) throws RemoteException {
            if (arrivedList.contains(listener)){
                arrivedList.remove(listener);
            }
        }
    }
    //通知每一个用户
    private void TZ2One(Book book){
        for (int i=0; i<arrivedList.size();i++){
            INewBookArrivedListener listener=arrivedList.get(i);
            try {
                listener.OnNewBookArrived(book);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    private class ServiceWorder implements Runnable{

        @Override
        public void run() {
           while(!isServiceDestory.get()){
               try {
                   Thread.sleep(1000);
                   int bookId = list.size()+1;
                   Book book=new Book();
                   book.setName(bookId+"");
                    TZ2One(book);
                   list.add(book);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        isServiceDestory.set(true);
    }
}
