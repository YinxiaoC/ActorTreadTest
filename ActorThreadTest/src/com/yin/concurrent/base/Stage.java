package com.yin.concurrent.base;

import java.util.TreeMap;

/*
* 隋唐演义大戏舞台
*
* */
public class Stage extends Thread{
    //复写run方法
    public void run() {
        System.out.println("欢迎观看隋唐演义");
        //演出五秒中后开始
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("大幕缓缓拉开");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("话说隋朝末年，隋军与起义军杀得昏天黑地");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ArmyRunnable armyTaskOfSuiDynasty = new ArmyRunnable();
        ArmyRunnable armyTaskOfRevolt = new ArmyRunnable();
       //创建线程
        Thread armyOfSuiDynasty = new Thread(armyTaskOfSuiDynasty,"隋军");
        Thread armyOfRevolt = new Thread(armyTaskOfRevolt,"起义军");

        //启动线程，开始作战
        armyOfSuiDynasty.start();
        armyOfRevolt.start();

        //舞台线程休眠，大家专注观看军队厮杀
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        armyTaskOfSuiDynasty.keepRunning = false;
        armyTaskOfSuiDynasty.keepRunning = false;
        try {
            //Thread的非静态方法join()让一个线程B“加入”到另外一个线程A的尾部。
            // 在A执行完毕之前，B不能工作。
            armyOfRevolt.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("双方激战正酣，半路杀出程咬金");

        Thread mrCheng = new Thread();
        mrCheng.setName("程咬金");

        System.out.println("程咬金要结束战斗维护世界和平");

        //军队停止作战
        //线程停止
        armyTaskOfSuiDynasty.keepRunning = false;
        armyTaskOfRevolt.keepRunning = false;

        //舞台休眠两秒钟
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //陈咬金开始入场

        mrCheng.start();

        //所有线程等待程先生完成历史使命
        try {
            mrCheng.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("战争结束，人民安居乐业 ");
        System.out.println("谢谢观看! ");
    }

    public static void main(String[] args) {
        new Stage().start();
    }
}
