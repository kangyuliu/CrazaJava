package com.company;

public class SyncThread {
    public static void main(String[] args){
        LockObject lockObject = new LockObject(0);
        MyTread[] myTreads = new MyTread[10];
        for(int i=0; i< 10; i++){
           /* myTreads[i] = new MyTread(i, lockObject);
            myTreads[i].start();*/
           new MyTread(i,lockObject).start();
        }
    }
}


class LockObject{
    int orderNum;
    final int MAX_VALUE = 10;

    public LockObject(int orderNum){
        this.orderNum = orderNum;
    }
}

class MyTread extends Thread{
    private LockObject lockObject;
    private int printVal;
    public MyTread(int printVal, LockObject lockObject){
        this.printVal = printVal;
        this.lockObject = lockObject;
    }

    @Override
    public void run(){
        synchronized (lockObject){
            while(lockObject.orderNum < lockObject.MAX_VALUE){
                if(lockObject.orderNum == printVal ){
                    System.out.println(printVal);
                    lockObject.orderNum++;
                    if(lockObject.orderNum == lockObject.MAX_VALUE){
                        System.out.println("finshed print");
                    }
                    lockObject.notifyAll();
                }else {
                    try {
                        lockObject.wait();
                    }catch (InterruptedException e){
                        System.out.println("线程" + printVal + "被打断了");
                        e.printStackTrace();
                    }

                }
            }
        }
    }
}
