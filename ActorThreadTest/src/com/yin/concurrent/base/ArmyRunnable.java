package com.yin.concurrent.base;

//军队线程
//模拟对战双方的行为
public class ArmyRunnable implements Runnable{
    //volatile保证了线程可以正确的读取到其他线程写入的值
    //可见性 happen-before原则
    //1）保证了不同线程对这个变量进行操作时的可见性，即一个线程修改了某个变量的值，这新值对其他线程来说是立即可见的。
    //2）禁止进行指令重排序
   volatile boolean keepRunning = true;

    @Override
    public void run() {
        while (keepRunning){
            //攻击时发动五连击
            for(int i=1;i<=5;i++)
            {
                System.out.println(Thread.currentThread().getName()+"进攻对方【"+i+"】");
                //让出处理器起时间
                //当一个线程使用了这个方法之后，它就会把自己CPU执行的时间让掉
                //让自己或者其它的线程运行，注意是让自己或者其他线程运行，并不是单纯的让给其他线程。
                Thread.yield();
            }
        }
        System.out.println(Thread.currentThread().getName()+"结束战斗");
    }
}
