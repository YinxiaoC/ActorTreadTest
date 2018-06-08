package com.yin.concurrent.base;

public class KeyPerson extends Thread {

    public void run() {

        System.out.println(Thread.currentThread().getName()+"开始战斗 ！ ");

        //关键人物十连击攻击
        for(int i=0;i<10;i++){

            System.out.println("左突右杀，攻击隋军");

        }

        System.out.println(Thread.currentThread().getName()+"结束战斗 ！ ");
    }
}
