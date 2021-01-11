package com.yitu;

public interface Output {


    //inner class
    class InClass{}

    //public statistic final
    //since java8
    int MAX_CACHE_LINE = 50;

    //一般方法，及实例方法，public abstract
    public abstract void getData();
    void out();

    //默认方法，必须default开头，必须有方法体
    //since java8
    default void print(String... msgs){
        for(var msg : msgs){
            System.out.println(msg);
        }
       ///foo();
    }

    default void test(){
        System.out.println("默认test()方法");
        //foo();
        //staticFoo();
    }

    //定义静态方法，必须有static
    //since java8
    static String staticTest(){
        //staticFoo();
        return "静态staticTest()方法";

        //foo();
    }

    //一般私有方法
  /*  //since java9
    private void foo(){
        System.out.println("foo私有方法");
    }

    //静态私有方法
    //since java9
    private static void staticFoo(){
        System.out.println("静态staticFoo()方法");
    }
*/
}
