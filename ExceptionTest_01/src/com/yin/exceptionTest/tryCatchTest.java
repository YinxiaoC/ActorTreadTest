package com.yin.exceptionTest;

public class tryCatchTest {
    public static void main(String[] args) {
          tryCatchTest tryCatchTest = new tryCatchTest();
          int result = tryCatchTest.test();
//        System.out.println("这是test " + result);
//        int result2 = tryCatchTest.test2();
//        System.out.println("这是test2 " +result2);
          int result2 = tryCatchTest.test3();
          System.out.println("这是test2 " +result2);
    }
    //编写一个test方法，演示try-catch
    /*
    * divider(除数)
    * result(结果)
    * try-catch补货while循环
    * 每次循环，divider减一，result=result+100/divider
    * 补货异常，打印输出
    * 否则返回result
    *
    * */

    public int test(){
        int devider = 10;
        int result = 100;
       try {
           while(devider>-1){
               devider--;
               result = result + 100/devider;
           }
           return result;
       }catch (Exception e){
           System.out.println("test1循环有异常抛出");
           //打印异常
           e.printStackTrace();
           return -1;
       }
    }
    /*
     * divider(除数)
     * result(结果)
     * try-catch补货while循环
     * 每次循环，divider减一，result=result+100/divider
     * 补货异常，打印输出
     * 否则返回result
     *finally：打印输出“finally”，同时输出resyult的值
     * */
    public int test2(){
        int devider = 10;
        int result = 100;
        try {
            while(devider>-1){
                devider--;
                result = result + 100/devider;
            }
            return result;
        }catch (Exception e){
            System.out.println("test2循环有异常抛出");
            //打印异常
            e.printStackTrace();
            return result=999;
        }
        //try-catch之后，调用者之前
        finally {
            System.out.println("这是finally");
            System.out.println("finally里面打印result "+result);
        }
    }
    /*
     * divider(除数)
     * result(结果)
     * try-catch补货while循环
     * 每次循环，divider减一，result=result+100/divider
     * 补货异常，打印输出
     * 否则返回result
     *finally：打印输出“finally”，同时输出resyult的值
     * */
    public int test3(){
        int devider = 10;
        int result = 100;
        try {
            while(devider>-1){
                devider--;
                result = result + 100/devider;
            }
        }catch (Exception e){
            System.out.println("test3循环有异常抛出");
            //打印异常
            e.printStackTrace();
        }
        //try-catch之后，调用者之前
        finally {
            System.out.println("这是finally");
            System.out.println("finally里面打印result "+result);
        }
        return 1111;
    }
}
