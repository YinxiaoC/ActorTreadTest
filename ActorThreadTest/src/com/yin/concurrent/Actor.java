package com.yin.concurrent;
//两种创建线程的方式
public class Actor extends Thread{
// 通过继承Thread类来创建并启动多线程的一般步骤如下
//1】d定义Thread类的子类，并重写该类的run()方法，该方法的方法体就是线程需要完成的任务，run()方法也称为线程执行体。
//2】创建Thread子类的实例，也就是创建了线程对象
//3】启动线程，即调用线程的start()方法
    public void run(){
        System.out.println(getName()+"演出开始");
        //计数器，记录演出次数
        int count = 0;
        boolean keepRunning = true;
        while (keepRunning)
        {System.out.println(getName()+ "登台演出次数 "+(++count));
        if (count == 100){
            keepRunning = false;
            }
            if (count%10 ==0){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
          System.out.println(getName()+"演出结束");
    }
    public static void main(String[] args) {
        Thread actor = new Actor();
        actor.setName("Mr.Thread");
        actor.start();
        //创建线程对象
        //new Actress()是Runnable实现类的实例，作为Thread的target
        Thread actress = new Thread(new Actress(),"Ms.Runnable");
        actress.start();
    }
}
//Java中实现多线程有两种途径:继承Thread类或者实现Runnable接口.
//Runnable接口非常简单,就定义了一个方法run(),
// 继承Runnable并实现这个方法就可以实现多线程了,
// 但是这个run()方法不能自己调用,必须由系统来调用,
// 否则就和别的方法没有什么区别了.

//通过实现Runnable接口创建并启动线程一般步骤如下：
//1】定义Runnable接口的实现类，一样要重写run()方法，这个run（）方法和Thread中的run()方法一样是线程的执行体
//2】创建Runnable实现类的实例，并用这个实例作为Thread的target来创建Thread对象，这个Thread对象才是真正的线程对象
//3】第三部依然是通过调用线程对象的start()方法来启动线程
class Actress implements Runnable{
    @Override
    //run方法内部是执行体
    public void run() {
        System.out.println(Thread.currentThread().getName()+"演出开始");
        //计数器，记录演出次数
        int count = 0;
        boolean keepRunning = true;
        while (keepRunning)
        {System.out.println(Thread.currentThread().getName()+ "登台演出次数 "+(++count));
            if (count == 100){
                keepRunning = false;
            }
            if (count%10 ==0){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(Thread.currentThread().getName()+"演出结束");

    }
}