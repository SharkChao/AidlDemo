// INewBookArrivedListener.aidl
package com.lenovohit.administrator.aidldemo;

// Declare any non-default types here with import statements
import com.lenovohit.administrator.aidldemo.entity.Book;

interface INewBookArrivedListener {
   void OnNewBookArrived(in Book book);
}
