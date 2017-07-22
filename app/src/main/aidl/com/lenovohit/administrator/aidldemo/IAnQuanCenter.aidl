// IAnQuanCenter.aidl
package com.lenovohit.administrator.aidldemo;

// Declare any non-default types here with import statements
//安全中心  用于加密和解密

interface IAnQuanCenter {
  String encrypt(String content);//加密
  String decrypt(String content);//解密
}
