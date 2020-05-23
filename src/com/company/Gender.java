package com.company;

public enum Gender implements GenderDesc{
    MALE("男"){
        @Override
        public void info() {
            System.out.println("这个枚举类代表男性");
        }
    },
    FEMALE("女") {
        @Override
        public void info() {
            System.out.println("这个枚举类代表女性");
        }
    };
    private String name;
    private Gender(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public static void main(String[]args){
        Gender.MALE.info();
        System.out.println(MALE.getName());
    }
}
