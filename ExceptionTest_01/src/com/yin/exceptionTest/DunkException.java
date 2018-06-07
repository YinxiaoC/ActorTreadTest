package com.yin.exceptionTest;
//自定义异常
public class DunkException extends Exception{
    //无参构造器
    public DunkException(){

    }
    public DunkException(String message){
        super(message);
    }
}
