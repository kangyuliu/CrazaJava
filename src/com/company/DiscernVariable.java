package com.company;

public class DiscernVariable {
    private String prop = "外部类实例变量";
    private class InClass{
        private String prop = "内部类实例变量";

        public void info(){
            String prop = "局部变量";
            System.out.println("外部类实例变量： " + DiscernVariable.this.prop);
            System.out.println("内部类的实例变量: " + this.prop);
            System.out.println("局部类变量: " + prop);
        }
    }

    private static class In{}

    public void test(){
        InClass ic = new InClass();
        ic.info();
    }

    public static void main(String[] args){
        new DiscernVariable().test();
        new CharTest();
        //new InClass();
        new In();
    }
}
