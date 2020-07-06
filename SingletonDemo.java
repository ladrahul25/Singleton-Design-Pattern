package com.identity.rahul.workmanagersample;

public class SingletonDemo {

    private volatile static SingletonDemo mSingletonDemo;

    //private constructor to access
    private SingletonDemo(){

        // prevents class from reflection
        if (null != mSingletonDemo){
            throw new RuntimeException("Use getInstance method to get single instance of this class");
        }
    }

    // single entry point access
    public static SingletonDemo getInstance(){
        if (null == mSingletonDemo){

            //doubly check locking
            synchronized (SingletonDemo.class){
                if (null == mSingletonDemo){
                    mSingletonDemo = new SingletonDemo();
                }
            }
        }
        return mSingletonDemo;
    }
}
