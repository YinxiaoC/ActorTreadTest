package com.yin.exceptionTest;

public class Chaintest {
    public static void main(String[] args) {
        Chaintest ct = new Chaintest();
        try {
            ct.test2();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * test1():抛出“喝大了异常”
     * test2（）：调用test1（），捕获喝大了异常，并将其包装成为运行时异常，继续抛出
     * main方法中，调用test2（），尝试补货test2（0中方法抛出的异常
     *
     * */
    public void test1()throws DunkException{
        throw new DunkException("开车别喝酒异常");
    }
    public void test2(){
        try {
            test1();
        } catch (DunkException e) {
            e.printStackTrace();
            RuntimeException runtimeException =
                    new RuntimeException("开车别喝酒，喝酒别开车~~");
            //initCause()这个方法就是对异常来进行包装的，
            // 目的就是为了出了问题的时候能够追根究底。因为一个项目，越往底层，
            // 可能抛出的异常类型会用很多，
            // 如果你在上层想要处理这些异常，你就需要挨个的写很多catch语句块来捕捉异常，
            // 这样是很麻烦的。如果我们对底层抛出的异常捕获后，抛出一个新的统一的异常，
            // 会避免这个问题。但是直接抛出一个新的异常，会让最原始的异常信息丢失，这样不利于排查问题。
            // 举个例子，在底层会出现一个A异常，然后在中间代码层捕获A异常，对上层抛出一个B异常。
            // 如果在中间代码层不对A进行包装，在上层代码捕捉到B异常后就不知道为什么会导致B异常的发生，
            // 但是包装以后我们就可以用getCause()方法获得原始的A异常。这对追查BUG是很有利的。
            runtimeException.initCause(e);
            throw runtimeException;
        }

    }
}
