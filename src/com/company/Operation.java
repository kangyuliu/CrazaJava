package com.company;

public enum Operation {
    PLUS{
        @Override
        public double value(double x, double y) {
            return x + y;
        }
    },
    MINUS{
        @Override
        public double value(double x, double y) {
            return x - y;
        }
    },
    TIMES{
        @Override
        public double value(double x, double y) {
            return x * y;
        }
    },
    DIVIDE{
        @Override
        public double value(double x, double y) {
            return x / y;
        }
    };

    public abstract double value(double x, double y);

    public static void main(String[] agrs){
        System.out.println(Operation.PLUS.value(1,3));
        System.out.println(Operation.MINUS.value(3,1));
        System.out.println(Operation.TIMES.value(2,3));
        System.out.println(Operation.DIVIDE.value(6,3));
    }
}
