package com.company;

@FunctionalInterface
interface Displayable{
    //定义一个默认方法
    default int add(int a, int b){
        return a+b;
    }
    //定义一个抽象方法
    void display();
}

public class LambdaAndInner {

    private int age = 12;
    private static String name = "Liu Kang-yu";

    public void test(){
        var book = "weRead";
        /**
         * lambda表达式
         */
        //book = "a";
        Displayable displayable = () -> {
            System.out.println("局部变量book: " + book);
            System.out.println("实例变量age: " + age);
            System.out.println("类变量name: " + name);
        };

        displayable.display();
        System.out.println("add: " + displayable.add(2,3));
    }


    /**
     * 匿名内部类
     * @param args
     */

    public void test2(){
        var book = "weRead";
        Displayable displayable = new Displayable() {
            @Override
            public void display() {
                System.out.println("局部变量book: " + book);
                System.out.println("实例变量age: " + age);
                System.out.println("类变量name: " + name);
                System.out.println("add: " + add(2,4));
            }
        };

         displayable.display();

    }

   public static void main(String[] args){
        LambdaAndInner lambdaAndInner = new LambdaAndInner();
        lambdaAndInner.test();
        lambdaAndInner.test2();
       System.out.println(SeasonEnum.SPRING);
       System.out.println(SeasonEnum.values());
       for(var value : SeasonEnum.values()){
           System.out.println(value);
       }
       System.out.println(SeasonEnum.valueOf("SPRING"));
       System.out.println(SeasonEnum.SPRING.name());
       System.out.println(SeasonEnum.SPRING.toString());
       Enum.valueOf(SeasonEnum.class, "SPRING");

   }

}
