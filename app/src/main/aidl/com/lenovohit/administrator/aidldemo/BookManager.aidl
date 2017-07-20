// BookManager.aidl
package com.lenovohit.administrator.aidldemo;

// Declare any non-default types here with import statements
import com.lenovohit.administrator.aidldemo.entity.Book;
import com.lenovohit.administrator.aidldemo.INewBookArrivedListener;

interface BookManager {
    //获取所有书的列表
    List<Book> getBookList();
    //添加一本书
    void addBook(in Book book);
    //设置listener
    void RegistenerListener(in INewBookArrivedListener listener);
    //取消绑定
    void UnRegistenerListener(in INewBookArrivedListener listener);
}
